package com.ALTbruno.encurtadorurl.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DATABASE_SEQUENCE")
public class DatabaseSequence {

	@Id
	private String id;

	private Long sequenceNumber;


	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public Long getSequenceNumber() {
		return sequenceNumber;
	}

	public void setSequenceNumber(Long sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
}
