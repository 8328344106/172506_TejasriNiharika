package com.ct.CertificateTracker.model;

import org.springframework.data.mongodb.core.mapping.Document;


public class PlannedTraining {
	
	
	private String _id;
	
	
	private String empId;
	private String empName;
	private String trainingId;
	private String trainingName;
	private String trainingStatus;
	private String nominationStatus;
	private String requestDate;
	
	private  String startDate;
	private String endDate;
	
	
	private String location;
	
	
	
	
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	public String getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}
	public String getTrainingStatus() {
		return trainingStatus;
	}
	public void setTrainingStatus(String trainingStatus) {
		this.trainingStatus = trainingStatus;
	}
	public String getNominationStatus() {
		return nominationStatus;
	}
	public void setNominationStatus(String nominationStatus) {
		this.nominationStatus = nominationStatus;
	}
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	
	
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public PlannedTraining(String empId, String empName, String trainingId, String trainingName, String trainingStatus,
			String nominationStatus, String requestDate, String startDate, String endDate, String location) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.trainingId = trainingId;
		this.trainingName = trainingName;
		this.trainingStatus = trainingStatus;
		this.nominationStatus = nominationStatus;
		this.requestDate = requestDate;
		this.startDate = startDate;
		this.endDate = endDate;
		this.location = location;
	}
	@Override
	public String toString() {
		return "PlannedTraining [empId=" + empId + ", empName=" + empName + ", trainingId=" + trainingId
				+ ", trainingName=" + trainingName + ", trainingStatus=" + trainingStatus + ", nominationStatus="
				+ nominationStatus + ", requestDate=" + requestDate + ", startDate=" + startDate + ", endDate="
				+ endDate + ", location=" + location + "]";
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
