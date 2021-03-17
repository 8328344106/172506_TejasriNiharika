package com.ct.CertificateTracker.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("Trainings")
public class Trainings 
{
	private String trainingId;
	private String trainingName;
	private String stream;
	private String startDate;
	private String endDate;
	private String startTime;
	private String endTime;
	private String trainerName;
	private String city;
	private String location;
	private String _id;
	private String status;
	private int capacity;
	private int interestsReceived;
	private int confirmedOrApproved;
	private int seatsRemaining;

	
	public Trainings() {
		super();
		// TODO Auto-generated constructor stub
	}
	public String getTrainingId() {
		return trainingId;
	}
	public void setTrainingId(String trainingId) {
		this.trainingId = trainingId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getTrainingName() {
		return trainingName;
	}
	public void setTrainingName(String trainingName) {
		this.trainingName = trainingName;
	}
	public String getStream() {
		return stream;
	}
	public void setStream(String stream) {
		this.stream = stream;
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
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	public String getTrainerName() {
		return trainerName;
	}
	public void setTrainerName(String trainerName) {
		this.trainerName = trainerName;
	}
	public String getCity() {
		return city;
	}
	public int getCapacity() {
		return capacity;
	}
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}
	public int getInterestsReceived() {
		return interestsReceived;
	}
	public void setInterestsReceived(int interestsReceived) {
		this.interestsReceived = interestsReceived;
	}
	public int getConfirmedOrApproved() {
		return confirmedOrApproved;
	}
	public void setConfirmedOrApproved(int confirmedOrApproved) {
		this.confirmedOrApproved = confirmedOrApproved;
	}
	public int getSeatsRemaining() {
		return seatsRemaining;
	}
	public void setSeatsRemaining(int seatsRemaining) {
		this.seatsRemaining = seatsRemaining;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
}
