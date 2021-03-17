package com.ct.CertificateTracker.model;

import java.util.Date;
import org.bson.types.Binary;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("FinalCertificates")
public class Certificate {
	
	private String _id;
	
	public String getId() {
		return _id;
	}
	public void setId(String id) {
		this._id = id;
	}
	private String empId;
	private String empName;
	private  String cerCategory;
	private String cerName;
	private String cerDate;
	private String expDate;
	private String cerMonth;
	private Double examScore;
	private String voucherCode;
    private byte[] file;

    private String fileName;

	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
	
	public byte[] getFile() {
		return file;
	}
	public void setFile(byte[] file) {
		this.file = file;
	}
	public Certificate(String _id, String empId, String empName, String cerCategory, String cerName, String cerDate,
			String expDate, String cerMonth, Double examScore, String voucherCode, byte[] file, String fileName) {
		super();
		this._id = _id;
		this.empId = empId;
		this.empName = empName;
		this.cerCategory = cerCategory;
		this.cerName = cerName;
		this.cerDate = cerDate;
		this.expDate = expDate;
		this.cerMonth = cerMonth;
		this.examScore = examScore;
		this.voucherCode = voucherCode;
		this.file = file;
		this.fileName = fileName;
	}
	@Override
	public String toString() {
		return "Certificate [_id=" + _id + ", empId=" + empId + ", empName=" + empName + ", cerCategory=" + cerCategory
				+ ", cerName=" + cerName + ", cerDate=" + cerDate + ", expDate=" + expDate + ", cerMonth=" + cerMonth
				+ ", examScore=" + examScore + ", voucherCode=" + voucherCode + ", file=" + file + ", fileName="
				+ fileName + "]";
	}
	public Certificate() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
