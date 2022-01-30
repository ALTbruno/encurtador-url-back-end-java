package com.ALTbruno.encurtadorurl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "URLS")
public class URL {

	@Id
	private Long id;

	private String bigUrl;

	private String hash;

	private String shortUrl;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getBigUrl() {
		return bigUrl;
	}

	public void setBigUrl(String bigUrl) {
		this.bigUrl = bigUrl;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public String getShortUrl() {
		return shortUrl;
	}

	public void setShortUrl(String shortUrl) {
		this.shortUrl = shortUrl;
	}
}
