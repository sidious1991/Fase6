package it.uniroma2.fase6.repositories;

import org.springframework.data.mongodb.repository.MongoRepository;

import it.uniroma2.fase6.model.Goal;

public interface GoalRepository extends MongoRepository<Goal, String> {

}
