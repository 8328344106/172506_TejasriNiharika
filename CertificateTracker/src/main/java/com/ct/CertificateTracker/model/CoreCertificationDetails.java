package com.ct.CertificateTracker.model;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("CertitficationDetails")
public class CoreCertificationDetails {
	private String _id;
	private String certificationCategory;
	private String certificationName;
	private String activeStatus;
	private String coreCeritification;
	private String level;
	private String voucherAvailable;
	
	
	public String get_id() {
		return _id;
	}
	public void set_id(String _id) {
		this._id = _id;
	}
	public String getCertificationCategory() {
		return certificationCategory;
	}
	public void setCertificationCategory(String certificationCategory) {
		this.certificationCategory = certificationCategory;
	}
	public String getCertificationName() {
		return certificationName;
	}
	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}
	public String getActiveStatus() {
		return activeStatus;
	}
	public void setActiveStatus(String activeStatus) {
		this.activeStatus = activeStatus;
	}
	public String getCoreCeritification() {
		return coreCeritification;
	}
	public void setCoreCeritification(String coreCeritification) {
		this.coreCeritification = coreCeritification;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	public String getVoucherAvailable() {
		return voucherAvailable;
	}
	public void setVoucherAvailable(String voucherAvailable) {
		this.voucherAvailable = voucherAvailable;
	}
	public CoreCertificationDetails(String _id,String certificationCategory, String certificationName, String activeStatus,
			String coreCeritification, String level, String voucherAvailable) {
		super();
		this._id=_id;
		this.certificationCategory = certificationCategory;
		this.certificationName = certificationName;
		this.activeStatus = activeStatus;
		this.coreCeritification = coreCeritification;
		this.level = level;
		this.voucherAvailable = voucherAvailable;
	}
	@Override
	public String toString() {
		return "CoreCertificationDetails [certificationCategory=" + certificationCategory + ", certificationName="
				+ certificationName + ", activeStatus=" + activeStatus + ", coreCeritification=" + coreCeritification
				+ ", level=" + level + ", voucherAvailable=" + voucherAvailable + "]";
	}
	
	

}
