package com.ALTbruno.encurtadorurl.service;

import com.ALTbruno.encurtadorurl.model.URL;
import com.ALTbruno.encurtadorurl.repository.UrlRepository;
import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;

@Service
public class UrlService {

	private UrlRepository urlRepository;
	private SequenceGeneratorService sequenceGeneratorService;


	@Autowired
	public UrlService(UrlRepository urlRepository, SequenceGeneratorService sequenceGeneratorService) {
		this.urlRepository = urlRepository;
		this.sequenceGeneratorService = sequenceGeneratorService;
	}

	public URL encurtarUrl(URL url) {
		UrlValidator urlValidator = new UrlValidator();
		if (urlValidator.isValid(url.getBigUrl())) {

			String urlServer = "http://localhost:8080/";
			String hash = Hashing.murmur3_32_fixed().hashString(url.getBigUrl(), StandardCharsets.UTF_8).toString();

			url.setId(sequenceGeneratorService.getSequenceNumber(URL.SEQUENCE_NAME));
			url.setHash(hash);
			url.setShortUrl(urlServer.concat(hash));
		}
		return urlRepository.save(url);
	}
}
