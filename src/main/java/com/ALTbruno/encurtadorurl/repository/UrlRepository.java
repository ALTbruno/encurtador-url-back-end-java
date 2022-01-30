package com.ALTbruno.encurtadorurl.repository;

import com.ALTbruno.encurtadorurl.model.URL;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UrlRepository extends MongoRepository<URL, Long> {

	boolean existsByBigUrl(String bigUrl);

	Optional<URL> findByBigUrl(String bigUrl);

	Optional<URL> findByHash(String hash);
}
