package com.ALTbruno.encurtadorurl.controller;

import com.ALTbruno.encurtadorurl.model.URL;
import com.ALTbruno.encurtadorurl.service.UrlService;
import com.google.common.hash.Hashing;
import org.apache.commons.validator.routines.UrlValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;

@RestController
@RequestMapping("/encurtar")
public class UrlController {

	private UrlService urlService;

	@Autowired
	public UrlController(UrlService urlService) {
		this.urlService = urlService;
	}

	@PostMapping
	public URL encurtar(@RequestBody URL url) {
		return urlService.encurtarUrl(url);
	}

}
