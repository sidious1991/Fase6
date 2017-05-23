package it.uniroma2.fase6.model;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class ValidateData {
	@Id
	private String dataId;

	private List<String> data;
	private String businessWorkflowInstanceId;
	@DBRef
	private Strategy strategyRef;
	@DBRef
	private Metric metricRef;

	

	public ValidateData(String dataId, List<String> data,
			String businessWorkflowInstanceId, Strategy strategyRef,
			Metric metricRef) {
		super();
		this.dataId = dataId;
		this.data = data;
		this.businessWorkflowInstanceId = businessWorkflowInstanceId;
		this.strategyRef = strategyRef;
		this.metricRef = metricRef;
	}

	

	public String getBusinessWorkflowInstanceId() {
		return businessWorkflowInstanceId;
	}



	public void setBusinessWorkflowInstanceId(String businessWorkflowInstanceId) {
		this.businessWorkflowInstanceId = businessWorkflowInstanceId;
	}



	public Metric getMetricRef() {
		return metricRef;
	}

	public void setMetricRef(Metric metricRef) {
		this.metricRef = metricRef;
	}

	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public List<String> getData() {
		return data;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	public Strategy getStrategyRef() {
		return strategyRef;
	}

	public void setStrategyRef(Strategy strategyRef) {
		this.strategyRef = strategyRef;
	}

}
