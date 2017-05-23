package it.uniroma2.fase6.controller.implementation;

import java.io.IOException;
import java.net.MalformedURLException;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import it.uniroma2.fase6.controller.BusService;
import it.uniroma2.fase6.model.rest.DTOresponse;
import it.uniroma2.fase6.repositories.BusRepository;
import it.uniroma2.isssr.integrazione.BusException;
import it.uniroma2.isssr.integrazione.BusMessage;


@Service("BusService")
public class BusServiceImplementation implements BusService {

	@Autowired
	BusRepository busRepository;

	@Override
	public ResponseEntity<DTOresponse> createReport(String payload) throws JSONException {
		String objIdLocalToPhase = "Report6";
		String read=null;
		JSONObject jsonRead = new JSONObject();
		jsonRead.put("objIdLocalToPhase", objIdLocalToPhase);
		jsonRead.put("typeObj", "base64-report6");
		jsonRead.put("instance", "report");
		jsonRead.put("busVersion", "");
		jsonRead.put("tags", "[]");
		jsonRead.put("payload",payload.toString() );
		System.out.println("array" + payload.toString() );

		String busAddress= "http://ermes.sweng.uniroma2.it/Bus3/inboundChannel.html";

		try {
			BusMessage readBus = new BusMessage(BusMessage.OPERATION_CREATE,"phase6",jsonRead.toString());
			read = readBus.send(busAddress);
			System.out.println("Create Message: " + read);
		} catch(MalformedURLException ex) {
			ex.printStackTrace();
		} catch(IOException ioex) {
			ioex.printStackTrace();
		}catch(BusException e){
			e.printStackTrace();
		}
		if(read.contains("ERR4")){
			try {										
				BusMessage updateBus = new BusMessage(BusMessage.OPERATION_UPDATE,"phase6",jsonRead.toString());
				read = updateBus.send(busAddress);
				System.out.println("UPDATE MESSAGE " + read);
			} catch(MalformedURLException ex) {
				ex.printStackTrace();
			} catch(IOException ioex) {
				ioex.printStackTrace();
			}catch(BusException e){
				e.printStackTrace();
			}
		}

		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setMessage(read);
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse, HttpStatus.OK);
		return response;
	}

	@Override
	public ResponseEntity<DTOresponse> getSendingOutcomes() throws JSONException {
		String read = null;
		JSONObject jsonRead = new JSONObject();
		jsonRead.put("objIdLocalToPhase","");
		jsonRead.put("typeObj", "base64-outcomes5");
		jsonRead.put("instance", "");
		jsonRead.put("busVersion", "");
		jsonRead.put("tags", "[]");

		String busAddress= "http://ermes.sweng.uniroma2.it/Bus3/inboundChannel.html";
		
		try {
			BusMessage readBus = new BusMessage(BusMessage.OPERATION_READ,"phase5",jsonRead.toString());
			read = readBus.send(busAddress);
			// System.out.println("Read BUS Message: " + read);
		} catch(MalformedURLException ex) {
			ex.printStackTrace();
		} catch(IOException ioex) {
			ioex.printStackTrace();
		}catch(BusException e){
			e.printStackTrace();
		}

		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setMessage(read);
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse, HttpStatus.OK);
		return response;

	}

	@Override
	public ResponseEntity<DTOresponse> getChartData() throws JSONException {
		String read = null;
		JSONObject jsonRead = new JSONObject();
		jsonRead.put("objIdLocalToPhase","");
		jsonRead.put("typeObj", "base64-Fase5-validatedData");
		jsonRead.put("instance", "");
		jsonRead.put("busVersion", "");
		jsonRead.put("tags", "[]");

		String busAddress= "http://ermes.sweng.uniroma2.it/Bus3/inboundChannel.html";
		try {
			BusMessage readBus = new BusMessage(BusMessage.OPERATION_READ,"phase5",jsonRead.toString());
			read = readBus.send(busAddress);
			System.out.println("Read BUS Message: " + read);
		} catch(MalformedURLException ex) {
			ex.printStackTrace();
		} catch(IOException ioex) {
			ioex.printStackTrace();
		}catch(BusException e){
			e.printStackTrace();
		}

		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setMessage(read);
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse, HttpStatus.OK);
		return response;

	}

	@Override
	public ResponseEntity<DTOresponse> getScheduleChartData() throws JSONException {

		String read = null;
		JSONObject jsonRead = new JSONObject();
		jsonRead.put("objIdLocalToPhase","");
		jsonRead.put("typeObj", "base64-Fase5-scheduleChart");
		jsonRead.put("instance", "");
		jsonRead.put("busVersion", "");
		jsonRead.put("tags", "[]");

		String busAddress= "http://ermes.sweng.uniroma2.it/Bus3/inboundChannel.html";
		try {
			BusMessage readBus = new BusMessage(BusMessage.OPERATION_READ,"phase5",jsonRead.toString());
			read = readBus.send(busAddress);
			System.out.println("Read BUS Message: " + read);
		} catch(MalformedURLException ex) {
			ex.printStackTrace();
		} catch(IOException ioex) {
			ioex.printStackTrace();
		}catch(BusException e){
			e.printStackTrace();
		}

		DTOresponse dtoresponse = new DTOresponse();
		dtoresponse.setMessage(read);
		ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse, HttpStatus.OK);
		return response;

	}
	
	@Override
	  public ResponseEntity<DTOresponse> getUsersFromBus() throws JSONException {
	   String busAddress= "http://ermes.sweng.uniroma2.it/Bus3/inboundChannel.html";
	   String read=null;
	  
	   JSONObject jsonRead = new JSONObject();
	 
	   jsonRead.put("objIdLocalToPhase", "");
	   jsonRead.put("typeObj", "getUsers");
	   jsonRead.put("instance", "");  
	   jsonRead.put("busVersion", "");
	   
	   try {          
	    
	      BusMessage updateBus = new BusMessage(BusMessage.OPERATION_GETUSERS,"users", jsonRead.toString());
	       read = updateBus.send(busAddress);
	     System.out.println("UPDATE MESSAGE " + read);
	    
	   } catch(MalformedURLException ex) {
	            ex.printStackTrace();
	    } catch(IOException ioex) {
	            ioex.printStackTrace();
	    }catch(BusException e){
	     e.printStackTrace();
	    }
	  
	  
	  DTOresponse dtoresponse = new DTOresponse();
	  dtoresponse.setMessage(read);
	  System.out.println("GET USER msg: "+read);
	  ResponseEntity<DTOresponse> response = new ResponseEntity<DTOresponse>(dtoresponse, HttpStatus.OK);
	  return response;
	 
	  }

}
