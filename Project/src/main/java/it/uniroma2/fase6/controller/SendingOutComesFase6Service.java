package it.uniroma2.fase6.controller;

import org.springframework.http.ResponseEntity;

import it.uniroma2.fase6.model.rest.DTOresponse;

public interface SendingOutComesFase6Service {
	ResponseEntity<DTOresponse> createSendingOutComeFase6 (String fileId, String report);
	ResponseEntity<DTOresponse> getSendingOutComeFase6 ();
	ResponseEntity<DTOresponse> deleteAllSendingOutComeFase6 ();
}
