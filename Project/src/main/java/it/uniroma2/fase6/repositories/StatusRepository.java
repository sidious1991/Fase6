package it.uniroma2.fase6.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.uniroma2.fase6.model.Status;

public interface StatusRepository extends MongoRepository<Status, String> {

}
