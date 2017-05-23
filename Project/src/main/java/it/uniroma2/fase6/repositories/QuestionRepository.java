package it.uniroma2.fase6.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import it.uniroma2.fase6.model.Question;

public interface QuestionRepository extends MongoRepository<Question, String> {
   

}
