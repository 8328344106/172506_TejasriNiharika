package com.ct.CertificateTracker.model;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("VoucherMaster")
public class voucher {
    
	private String _id;
	private String voucherCode;
	private String examName;
	@Field("Stream")
	private String Stream;
	private String procurementDate;
	private String expiryDate;
	private String status;
	
	@Field("assign_to_EMP_ iD")
	private String empId;
	
	@Field("assign_to_Emp_name")
	private String empName;
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
	 * @return the examName
	 */
	public String getExamName() {
		return examName;
	}
	/**
	 * @param examName the examName to set
	 */
	public void setExamName(String examName) {
		this.examName = examName;
	}
	/**
	 * @return the stream
	 */
	public String getStream() {
		return Stream;
	}
	/**
	 * @param stream the stream to set
	 */
	public void setStream(String stream) {
		Stream = stream;
	}
	/**
	 * @return the procurementDate
	 */
	public String getProcurementDate() {
		return procurementDate;
	}
	/**
	 * @param procurementDate the procurementDate to set
	 */
	public void setProcurementDate(String procurementDate) {
		this.procurementDate = procurementDate;
	}
	/**
	 * @return the expiryDate
	 */
	public String getExpiryDate() {
		return expiryDate;
	}
	/**
	 * @param expiryDate the expiryDate to set
	 */
	public void setExpiryDate(String expiryDate) {
		this.expiryDate = expiryDate;
	}
	/**
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}
	/**
	 * @param status the status to set
	 */
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the empId
	 */
	public String getEmpId() {
		return empId;
	}
	/**
	 * @param empId the empId to set
	 */
	public void setEmpId(String empId) {
		this.empId = empId;
	}
	/**
	 * @return the empName
	 */
	public String getEmpName() {
		return empName;
	}
	/**
	 * @param empName the empName to set
	 */
	public void setEmpName(String empName) {
		this.empName = empName;
	}
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public voucher(String _id, String voucherCode, String examName, String Stream, String procurementDate,
			String expiryDate, String status, String empId, String empName) {
		super();
		this._id = _id;
		this.voucherCode = voucherCode;
		this.examName = examName;
		this.Stream = Stream;
		this.procurementDate = procurementDate;
		this.expiryDate = expiryDate;
		this.status = status;
		this.empId = empId;
		this.empName = empName;
	}
	public voucher() {
		super();
		// TODO Auto-generated constructor stub
	}
	
}
	