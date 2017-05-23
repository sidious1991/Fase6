package it.uniroma2.fase6.model.rest;

import java.util.List;

import org.springframework.data.mongodb.core.mapping.DBRef;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DTOBus extends DTO {
	private static final long serialVersionUID = 1L;
	
	@JsonInclude(Include.NON_NULL)
	private String tag;
	
	@JsonInclude(Include.NON_NULL)
	//tipo di oggetto che ha un array su 3 , "fase", "read/write","json[]{array di json}
	private List <String> content;
	@JsonInclude(Include.NON_NULL)
	//tipo di oggetto per la query al bus
	private String typeObject;
	@JsonInclude(Include.NON_NULL)
	//indirizzo di origine della post
	private String originAddress;
	@JsonInclude(Include.NON_NULL)
	//indirizzo di ricezione
	private String resolveAddress;
	@JsonInclude(Include.NON_NULL)
	//id per la tabella per identificare l'oggetto sul tag
	private String id;

	@JsonInclude(Include.NON_NULL)
	//riferimento al db di un oggetto generico
	private List<Object> objectJson;

	public String getTag() {
		return tag;
	}

	public void setTag(String tag) {
		this.tag = tag;
	}

	public List<String> getContent() {
		return content;
	}

	public void setContent(List<String> content) {
		this.content = content;
	}

	public String getTypeObject() {
		return typeObject;
	}

	public void setTypeObject(String typeObject) {
		this.typeObject = typeObject;
	}

	public String getOriginAddress() {
		return originAddress;
	}

	public void setOriginAddress(String originAddress) {
		this.originAddress = originAddress;
	}

	public String getResolveAddress() {
		return resolveAddress;
	}

	public void setResolveAddress(String resolveAddress) {
		this.resolveAddress = resolveAddress;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public List<Object> getObjectJson() {
		return objectJson;
	}

	public void setObjectJson(List<Object> objectJson) {
		this.objectJson = objectJson;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	
	

}
