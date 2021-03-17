package com.ct.CertificateTracker.model;

public class EmployeeDetailsCertificationDetails {

	private String _id;
	private String empId;
	private String empName;
	private  String cerCategory;
	private String cerName;
	private String cerDate;
	private String expDate;
	private String cerMonth;
	private Double examScore;
	private String voucherCode;
	private String localGrade;
	private String location;
	private String globalPractice;
	private String fileName;
	private byte[] file;
	public EmployeeDetailsCertificationDetails(String _id,String empId, String empName, String cerCategory, String cerName,
			String cerDate, String expDate, String cerMonth, Double examScore, String voucherCode, String localGrade,
			String location, String globalPractice, String fileName, byte[] file) {
		super();
		this._id=_id;
		this.empId = empId;
		this.empName = empName;
		this.cerCategory = cerCategory;
		this.cerName = cerName;
		this.cerDate = cerDate;
		this.expDate = expDate;
		this.cerMonth = cerMonth;
		this.examScore = examScore;
		this.voucherCode = voucherCode;
		this.localGrade = localGrade;
		this.location = location;
		this.globalPractice = globalPractice;
		this.setFileName(fileName);
		this.setFile(file);
	}
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
	public String getCerCategory() {
		return cerCategory;
	}
	public void setCerCategory(String cerCategory) {
		this.cerCategory = cerCategory;
	}
	public String getCerName() {
		return cerName;
	}
	public void setCerName(String cerName) {
		this.cerName = cerName;
	}
	public String getCerDate() {
		return cerDate;
	}
	public void setCerDate(String cerDate) {
		this.cerDate = cerDate;
	}
	public String getExpDate() {
		return expDate;
	}
	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}
	public String getCerMonth() {
		return cerMonth;
	}
	public void setCerMonth(String cerMonth) {
		this.cerMonth = cerMonth;
	}
	public Double getExamScore() {
		return examScore;
	}
	public void setExamScore(Double examScore) {
		this.examScore = examScore;
	}
	public String getVoucherCode() {
		return voucherCode;
	}
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	public String getLocalGrade() {
		return localGrade;
	}
	public void setLocalGrade(String localGrade) {
		this.localGrade = localGrade;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getGlobalPractice() {
		return globalPractice;
	}
	public void setGlobalPractice(String globalPractice) {
		this.globalPractice = globalPractice;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}

	
	
	
	
}
