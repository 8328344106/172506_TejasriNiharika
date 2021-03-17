package com.ct.CertificateTracker.model;

import java.util.ArrayList;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("InternalTestDetails")
public class InternalTest {
	
	@Id
	private String certificationName;
	private String certificationCategory;
	private ArrayList<ExamTest> tests=new ArrayList<ExamTest>();
	
	public InternalTest(String certificationCategory, String certificationName, ArrayList<ExamTest> tests) {
		super();
		this.certificationCategory = certificationCategory;
		this.certificationName = certificationName;
		this.tests = tests;
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

	public ArrayList<ExamTest> getTests() {
		return tests;
	}

	public void setTests(ArrayList<ExamTest> tests) {
		this.tests = tests;
	}

	@Override
	public String toString() {
		return "InternalTest [certificationCategory=" + certificationCategory + ", certificationName="
				+ certificationName + ", tests=" + tests + "]";
	}
	
	

}
