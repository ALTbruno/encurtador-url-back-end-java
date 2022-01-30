package com.ALTbruno.encurtadorurl.controller;

import com.ALTbruno.encurtadorurl.model.URL;
import com.ALTbruno.encurtadorurl.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

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
	public RedirectView redirecionar(@PathVariable String hash) {
		RedirectView redirectView = new RedirectView();
		String url = urlService.buscarHash(hash).get().getBigUrl();
		redirectView.setUrl(url);
		return redirectView;
	}

}
