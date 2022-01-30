package com.ALTbruno.encurtadorurl.repository;

import com.ALTbruno.encurtadorurl.model.URL;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UrlRepository extends MongoRepository<URL, Long> {
}
