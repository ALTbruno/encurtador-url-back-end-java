package com.ALTbruno.encurtadorurl.service;

import com.ALTbruno.encurtadorurl.model.URL;
import com.ALTbruno.encurtadorurl.repository.UrlRepository;
import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.util.Optional;

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


		String urlServer = "http://localhost:8080/";

		UrlValidator urlValidator = new UrlValidator();

		if (urlValidator.isValid(url.getBigUrl())) {
			if (urlRepository.existsByBigUrl(url.getBigUrl())) {
				url.setId(urlRepository.findByBigUrl(url.getBigUrl()).get().getId());
				url.setBigUrl(urlRepository.findByBigUrl(url.getBigUrl()).get().getBigUrl());
				url.setHash(urlRepository.findByBigUrl(url.getBigUrl()).get().getHash());
				url.setShortUrl(urlRepository.findByBigUrl(url.getBigUrl()).get().getShortUrl());
				return url;
			} else {
				String hash = Hashing.murmur3_32_fixed().hashString(url.getBigUrl(), StandardCharsets.UTF_8).toString();
				url.setId(sequenceGeneratorService.getSequenceNumber(URL.SEQUENCE_NAME));
				url.setHash(hash);
				url.setShortUrl(urlServer.concat(hash));
			}

		}
		return urlRepository.save(url);
	}

	public Optional<URL> buscarHash(String hash) {

		URL url = urlRepository.findByHash(hash).get();

		return urlRepository.findByHash(url.getHash());
	}
}
