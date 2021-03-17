package com.ct.CertificateTracker.model;

import java.util.List;

public class Tower {
	
	private String towerName;
	public Tower() {
		super();
		// TODO Auto-generated constructor stub
	}
	private List<Employee> emplist;
	private Integer totalEmp;
	private Integer certifiedEmp;
	private Integer coreCertified;
	private Integer nonCoreCertified;
	private double corePercentage;
	private Double percentage;
	
	
	
	
	public Integer getCoreCertified() {
		return coreCertified;
	}
	public void setCoreCertified(Integer coreCertified) {
		this.coreCertified = coreCertified;
	}
	public Integer getNonCoreCertified() {
		return nonCoreCertified;
	}
	public void setNonCoreCertified(Integer nonCoreCertified) {
		this.nonCoreCertified = nonCoreCertified;
	}
	public double getCorePercentage() {
		return corePercentage;
	}
	public void setCorePercentage(double corePercentage) {
		this.corePercentage = corePercentage;
	}
	public String getTowerName() {
		return towerName;
	}
	public void setTowerName(String towerName) {
		this.towerName = towerName;
	}
	public List<Employee> getEmplist() {
		return emplist;
	}
	public void setEmplist(List<Employee> emplist) {
		this.emplist = emplist;
	}
	
	public Integer getTotalEmp() {
		return totalEmp;
	}
	public void setTotalEmp(Integer totalEmp) {
		this.totalEmp = totalEmp;
	}
	public Integer getCertifiedEmp() {
		return certifiedEmp;
	}
	public void setCertifiedEmp(Integer certifiedEmp) {
		this.certifiedEmp = certifiedEmp;
	}
	public Double getPercentage() {
		return percentage;
	}
	public void setPercentage(Double percentage) {
		this.percentage = percentage;
	}
	
	@Override
	public String toString() {
		return "Tower [towerName=" + towerName + ", emplist=" + emplist + ", certifiedEmp=" + certifiedEmp
				+ ", percentage=" + percentage + "]";
	}
	

}
