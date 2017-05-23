package it.uniroma2.fase6.model.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DTOTestBusJar extends DTO {

	@JsonInclude(Include.NON_NULL)

	String id;
	@JsonInclude(Include.NON_NULL)

	String contentJson;
	@JsonInclude(Include.NON_NULL)

	String fase;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getContentJson() {
		return contentJson;
	}
	public void setContentJson(String contentJson) {
		this.contentJson = contentJson;
	}
	public String getFase() {
		return fase;
	}
	public void setFase(String fase) {
		this.fase = fase;
	}
	
	

}
