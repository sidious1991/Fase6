package it.uniroma2.fase6.model.rest;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

public class DTOValidateData extends DTO {

	private static final long serialVersionUID = 1L;

	@JsonInclude(Include.NON_NULL)
	private String dataId;
	@JsonInclude(Include.NON_NULL)
	private List<String> data;
	@JsonInclude(Include.NON_NULL)
	private String businessWorkflowInstanceId;
	@JsonInclude(Include.NON_NULL)
	private String strategyRef;
	@JsonInclude(Include.NON_NULL)
	private String metricRef;
	
	public String getDataId() {
		return dataId;
	}

	public void setDataId(String dataId) {
		this.dataId = dataId;
	}

	public List<String> getData() {
		return data;
	}

	public void setValidateData(List<String> data) {
		this.data = data;
	}

	

	public String getBusinessWorkflowInstanceId() {
		return businessWorkflowInstanceId;
	}

	public void setBusinessWorkflowIstanceId(String businessWorkflowInstanceId) {
		this.businessWorkflowInstanceId = businessWorkflowInstanceId;
	}

	public void setData(List<String> data) {
		this.data = data;
	}

	public String getStrategyRef() {
		return strategyRef;
	}

	public void setStrategyRef(String strategyRef) {
		this.strategyRef = strategyRef;
	}

	public String getMetricRef() {
		return metricRef;
	}

	public void setMetricRef(String metricRef) {
		this.metricRef = metricRef;
	}
	
	
	
	
}
