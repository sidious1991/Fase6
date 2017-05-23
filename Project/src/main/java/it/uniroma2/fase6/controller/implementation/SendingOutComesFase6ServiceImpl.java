package it.uniroma2.fase6.controller.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.uniroma2.fase6.controller.SendingOutComesFase6Service;
import it.uniroma2.fase6.model.SendingOutComesFase6;
import it.uniroma2.fase6.model.rest.DTOresponse;
import it.uniroma2.fase6.repositories.SendingOutComesFase6Repository;

@Service("SendingOutComesFase6Service")
public class SendingOutComesFase6ServiceImpl implements SendingOutComesFase6Service {

	@Autowired
	SendingOutComesFase6Repository sendingOutComesFase6repository;
	
	@Override
	public ResponseEntity<DTOresponse> createSendingOutComeFase6(String fileId,
			String report) {
		// TODO Auto-generated method stub
		SendingOutComesFase6 sending = new SendingOutComesFase6(fileId, report);
		sendingOutComesFase6repository.save(sending);
		DTOresponse dtoresponse = new DTOresponse();		
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse,HttpStatus.OK);
			
		return response;
	}

	@Override
	public ResponseEntity<DTOresponse> getSendingOutComeFase6() {
		// TODO Auto-generated method stub
		List<SendingOutComesFase6> sendings = sendingOutComesFase6repository.findAll();
		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setSendingOutcomesFase6(sendings);

		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(
				dtoresponse, HttpStatus.OK);

		return response;
	}

	@Override
	public ResponseEntity<DTOresponse> deleteAllSendingOutComeFase6() {
		// TODO Auto-generated method stub
		sendingOutComesFase6repository.delete(sendingOutComesFase6repository.findAll());
		return null;
	}
	

}
