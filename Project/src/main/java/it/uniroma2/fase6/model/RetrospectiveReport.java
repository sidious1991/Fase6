package it.uniroma2.fase6.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class RetrospectiveReport {

	@Id
	private String retrospectiveReportId;

	private String conclusion;
	private String lastModified;
	private List<Integer> ids;
	private List<String> priorityList;
	private List<String> descriptionList;
	
	public RetrospectiveReport() {
		this.ids=new ArrayList<Integer>();
		this.descriptionList=new ArrayList<String>();
		this.priorityList=new ArrayList<String>();	
	}
	

	public RetrospectiveReport(String retrospectiveReportId, String conclusion, String lastModified, List<Integer> ids,
			List<String> priorityList, List<String> descriptionList) {
		super();
		this.retrospectiveReportId = retrospectiveReportId;
		this.conclusion = conclusion;
		this.lastModified = lastModified;
		this.ids = ids;
		this.priorityList = priorityList;
		this.descriptionList = descriptionList;
	}


	public boolean addRow(String description, String priority){
		if(description==null)
			return false;
		this.priorityList.add(priority);
		this.descriptionList.add(description);
		if(this.ids.size()==0)
			this.ids.add(0);
		else this.ids.add(this.ids.size());
		return true;
	}
	public String getRetrospectiveReportId() {
		return retrospectiveReportId;
	}
	public void setRetrospectiveReportId(String retrospectiveReportId) {
		this.retrospectiveReportId = retrospectiveReportId;
	}
	public List<String> getPriorityList() {
		return priorityList;
	}
	public void setPriorityList(List<String> priorityList) {
		this.priorityList = priorityList;
	}
	public List<Integer> getIds() {
		return ids;
	}
	public void setIds(List<Integer> ids) {
		this.ids = ids;
	}
	public List<String> getDescriptionList() {
		return descriptionList;
	}
	public void setDescriptionList(List<String> description) {
		this.descriptionList = description;
	}
	public String getConclusion() {
		return conclusion;
	}
	public void setConclusion(String conclusion) {
		this.conclusion = conclusion;
	}
	public String getLastModified() {
		return lastModified;
	}
	public void setLastModified(String lastModified) {
		this.lastModified = lastModified;
	}
//	public static void main(String[] args) {
//		RetrospectiveReport ret= new RetrospectiveReport();
//		ret.addRow("prova", "alta");
//		ret.addRow("prova", "bassa");
//		ret.addRow("prova", "media");
//		System.out.println(ret.getIds().size());
//		for(int i :ret.getIds()){
//			System.out.println(ret.getIds().get(i)+","+ret.getPriorityList().get(i) +","+ ret.getDescription().get(i) );
//		}
//	}
}
