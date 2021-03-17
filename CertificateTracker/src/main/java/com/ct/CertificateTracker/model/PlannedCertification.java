package com.ct.CertificateTracker.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("PlannedCertifications")
public class PlannedCertification {	
	
	
	private String Stream;
	private String examName;
	private String expectedDate;
	private List<ExamTest> testMarks=new ArrayList<>();
	private String _id;
	private String empId;
	private String empName;
	private String voucherStatus;
	private String regDate;
	private String voucherCode;
	private String voucherReqDate;
	private String voucherAssignedDate;
	private String examDate;
	private String result;
	private Integer score;
	private String comments;
	
	public String getStream() {
		return Stream;
	}
	public void setStream(String Stream) {
		this.Stream = Stream;
	}
	public String getExamName() {
		return examName;
	}
	public void setExamName(String examName) {
		this.examName = examName;
	}
	public String getExpectedDate() {
		return expectedDate;
	}
	public void setExpectedDate(String expectedDate) {
		this.expectedDate = expectedDate;
	}
	
	
	
	
	public List<ExamTest> getTestMarks() {
		return testMarks;
	}
	public void setTestMarks(List<ExamTest> testMarks) {
		this.testMarks = testMarks;
	}
	/**
	 * @return the _id
	 */
	public String get_id() {
		return _id;
	}
	/**
	 * @param _id the _id to set
	 */
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getEmpID() {
		return empId;
	}
	public void setEmpID(String empID) {
		this.empId = empID;
	}
	public String getEmpName() {
		return empName;
	}
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	/**
	 * @return the voucherStatus
	 */
	public String getVoucherStatus() {
		return voucherStatus;
	}
	/**
	 * @param voucherStatus the voucherStatus to set
	 */
	public void setVoucherStatus(String voucherStatus) {
		this.voucherStatus = voucherStatus;
	}
	/**
	 * @return the regDate
	 */
	public String getRegDate() {
		return regDate;
	}
	/**
	 * @param regDate the regDate to set
	 */
	public void setRegDate(String regDate) {
		this.regDate = regDate;
	}
	/**
	 * @return the voucherCode
	 */
	public String getVoucherCode() {
		return voucherCode;
	}
	/**
	 * @param voucherCode the voucherCode to set
	 */
	public void setVoucherCode(String voucherCode) {
		this.voucherCode = voucherCode;
	}
	/**
	 * @return the voucherReqDate
	 */
	public String getVoucherReqDate() {
		return voucherReqDate;
	}
	/**
	 * @param voucherReqDate the voucherReqDate to set
	 */
	public void setVoucherReqDate(String voucherReqDate) {
		this.voucherReqDate = voucherReqDate;
	}
	/**
	 * @return the voucherAssignedDate
	 */
	public String getVoucherAssignedDate() {
		return voucherAssignedDate;
	}
	/**
	 * @param voucherAssignedDate the voucherAssignedDate to set
	 */
	public void setVoucherAssignedDate(String voucherAssignedDate) {
		this.voucherAssignedDate = voucherAssignedDate;
	}
	/**
	 * @return the examDate
	 */
	public String getExamDate() {
		return examDate;
	}
	/**
	 * @param examDate the examDate to set
	 */
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}
	/**
	 * @param result the result to set
	 */
	public void setResult(String result) {
		this.result = result;
	}
	/**
	 * @return the score
	 */
	public Integer getScore() {
		return score;
	}
	/**
	 * @param score the score to set
	 */
	public void setScore(Integer score) {
		this.score = score;
	}
	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	/**
	 * @param comments the comments to set
	 */
	public void setComments(String comments) {
		this.comments = comments;
	}
	public PlannedCertification(String Stream, String examName,
			String expectedDate, List<ExamTest> testMarks, String _id,
			String empId, String empName, String voucherStatus, String regDate,
			String voucherCode, String voucherReqDate,
			String voucherAssignedDate, String examDate, String result,
			Integer score, String comments) {
		super();
		this.Stream = Stream;
		this.examName = examName;
		this.expectedDate = expectedDate;
		this.testMarks = testMarks;
		this._id = _id;
		this.empId = empId;
		this.empName = empName;
		this.voucherStatus = voucherStatus;
		this.regDate = regDate;
		this.voucherCode = voucherCode;
		this.voucherReqDate = voucherReqDate;
		this.voucherAssignedDate = voucherAssignedDate;
		this.examDate = examDate;
		this.result = result;
		this.score = score;
		this.comments = comments;
	}
	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "PlannedCertification [stream=" + Stream + ", examName="
				+ examName + ", expectedDate=" + expectedDate + ", testMarks="
				+ testMarks + ", _id=" + _id + ", empId=" + empId
				+ ", empName=" + empName + ", voucherStatus=" + voucherStatus
				+ ", regDate=" + regDate + ", voucherCode=" + voucherCode
				+ ", voucherReqDate=" + voucherReqDate
				+ ", voucherAssignedDate=" + voucherAssignedDate
				+ ", examDate=" + examDate + ", result=" + result + ", score="
				+ score + ", comments=" + comments + "]";
	}
	
	public String getEmpId() {
		return empId;
	}
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	
	
	}
