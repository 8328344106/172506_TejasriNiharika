package com.ct.CertificateTracker.model;

public class ExamTest {
	
	private String testNames;
	private int passPercentage;
	private String testLinks;
	private int employeeScore;
	
	
	
	public ExamTest(String testNames, int passPercentage, String testLinks, int employeeScore) {
		super();
		this.testNames = testNames;
		this.passPercentage = passPercentage;
		this.testLinks = testLinks;
		this.employeeScore = employeeScore;
	}

	public int getEmployeeScore() {
		return employeeScore;
	}

	public void setEmployeeScore(int employeeScore) {
		this.employeeScore = employeeScore;
	}

	public String getTestNames() {
		return testNames;
	}

	public void setTestNames(String testNames) {
		this.testNames = testNames;
	}

	public int getPassPercentage() {
		return passPercentage;
	}

	public void setPassPercentage(int passPercentage) {
		this.passPercentage = passPercentage;
	}

	public String getTestLinks() {
		return testLinks;
	}

	public void setTestLinks(String testLinks) {
		this.testLinks = testLinks;
	}

	@Override
	public String toString() {
		return "ExamTest [testNames=" + testNames + ", passPercentage=" + passPercentage + ", testLinks=" + testLinks
				+ ", employeeScore=" + employeeScore + "]";
	}

	
	
	

}
