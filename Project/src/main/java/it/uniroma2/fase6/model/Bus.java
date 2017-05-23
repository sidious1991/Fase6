package it.uniroma2.fase6.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Bus {
	@Id
	//tag che identifica un oggetto sul bus
	private String tag;

	//tipo di oggetto che ha un array su 3 , "fase", "read/write","json[]{array di json}
	private List <String> content;
	//tipo di oggetto per la query al bus
	private String typeObject;
	//indirizzo di origine della post
	private String originAddress;
	//indirizzo di ricezione
	private String resolveAddress;
	//id per la tabella per identificare l'oggetto sul tag
	private String id;

	//forse va tolta
	@DBRef
	//riferimento al db di un oggetto generico
	private List<Object> objectJson;

	public Bus() {
	}

	public Bus(String tag, List<String> content, String typeObject,
			String originAddress, String resolveAddress, String id) {
		super();
		this.tag = tag;
		this.content = content;
		this.typeObject = typeObject;
		this.originAddress = originAddress;
		this.resolveAddress = resolveAddress;
		this.id = id;
	}

	public Bus(String tag, List<String> content, String typeObject,
			String originAddress, String resolveAddress, String id,
			List<Object> objectJson) {
		super();
		this.tag = tag;
		this.content = content;
		this.typeObject = typeObject;
		this.originAddress = originAddress;
		this.resolveAddress = resolveAddress;
		this.id = id;
		this.objectJson = objectJson;
	}


	//public String sendMsg(String tag , List<String> content){
	//	try{
	//		BusMessage busmsg = new BusMessage(BusMessage.OPERATION_READ, tag, content);
	//	}catch{}
	//	
	//	return null;
	//}

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



}
