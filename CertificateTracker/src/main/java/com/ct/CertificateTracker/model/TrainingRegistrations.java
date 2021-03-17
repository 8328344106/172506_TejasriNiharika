package com.ct.CertificateTracker.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("PlannedTrainings")
public class TrainingRegistrations {
	
	private String _id;
	
	private String empId;
	private String empName;
	private String trainingId;
	private String trainingName;
	private String  requestDate;
	
	private String nominationStatus;
	
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
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	
	public String getRequestDate() {
		return requestDate;
	}
	public void setRequestDate(String requestDate) {
		this.requestDate = requestDate;
	}
	
	public String getNominationStatus() {
		return nominationStatus;
	}
	public void setNominationStatus(String nominationStatus) {
		this.nominationStatus = nominationStatus;
	}
	public TrainingRegistrations(String _id, String empId, String empName, String trainingId, String trainingName,
			String requestDate, String nominationStatus) {
		super();
		this._id = _id;
		this.empId = empId;
		this.empName = empName;
		this.trainingId = trainingId;
		this.trainingName = trainingName;
		this.requestDate = requestDate;
		this.nominationStatus = nominationStatus;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	

}
