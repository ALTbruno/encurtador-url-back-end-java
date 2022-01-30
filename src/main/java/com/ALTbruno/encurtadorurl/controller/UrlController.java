package com.ALTbruno.encurtadorurl.controller;

import com.ALTbruno.encurtadorurl.model.URL;
import com.ALTbruno.encurtadorurl.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("")
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

	@GetMapping("/{hash}")
	public URL buscarPeloHash(@PathVariable String hash) {
		return urlService.buscarHash(hash);
	}

}
