package it.uniroma2.fase6.controller;



import org.springframework.http.ResponseEntity;

import it.uniroma2.fase6.model.rest.DTOresponse;

public interface QuestionService {

	ResponseEntity<DTOresponse> createQuestion(String questionId,String description, String creationDate, String lastModified, String timeFrame, int version, String focus);
	ResponseEntity<DTOresponse> getQuestions();
	ResponseEntity<DTOresponse> deleteQuestion(String questionId);
	ResponseEntity<DTOresponse> deleteAllQuestion();
}
