package it.uniroma2.fase6.model;

import org.springframework.data.annotation.Id;

public class SendingOutComesFase6 {
	@Id
	String fileId;
	String report;

	public SendingOutComesFase6() {
		super();
	}
	public SendingOutComesFase6(String fileId, String report) {
		this.fileId = fileId;
		this.report = report;
	}
	public String getFileId() {
		return fileId;
	}
	public void setFileId(String fileId) {
		this.fileId = fileId;
	}
	public String getReport() {
		return report;
	}
	public void setReport(String report) {
		this.report = report;
	}

}
