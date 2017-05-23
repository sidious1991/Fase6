package it.uniroma2.fase6.model.rest;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;



public class DTOSendingOutComesFase6 extends DTO{

private static final long serialVersionUID = 1L;
	
//	@JsonInclude(Include.NON_NULL)
//	String fileId;
	@JsonInclude(Include.NON_NULL)
	String report;
	
//	public String getFileId() {
//		return fileId;
//	}
//	public void setFileId(String fileId) {
//		this.fileId = fileId;
//	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}
	
	
}
