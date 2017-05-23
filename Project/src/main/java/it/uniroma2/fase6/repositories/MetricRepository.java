package it.uniroma2.fase6.repositories;


import org.springframework.data.mongodb.repository.MongoRepository;

import it.uniroma2.fase6.model.Metric;

public interface MetricRepository extends MongoRepository<Metric, String> {
   

}
