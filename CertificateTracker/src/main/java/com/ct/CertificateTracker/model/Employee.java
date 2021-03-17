package com.ct.CertificateTracker.model;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("Employee")
public class Employee 
{
	@Field("Employee no")
	private String empId;
	
	@Field("Name")
	private String empName;
	
	@Field("Local Grade")
	private String localGrade;
	
	@Field("Grade")
	private String grade;
	
	@Field("Mode")
	private String mode;
	
	@Field("Fresher/Lateral")
	private String fresherOrlateral;
	
	@Field("CLOUD DOJ")
	private String cloudDoj;
	
	@Field("Joining Date")
	private String joiningDate;
	
	@Field("Office")
	private String office;	
	
	@Field("Location")
	private String location;
	
	@Field("Seat")
	private String seat;
	
	@Field("Bench Start Date")
	private String benchStartDate;
	
	@Field("Aging Days")
	private String agingDays;
	
	@Field("Aging Status")
	private String agingStatus;
	
	@Field("Status Since")
	private String statusSince ;
	
	@Field("Age of Status")
	private String ageofStatus;
	
	@Field("Level 1")
	private String level1;
	

	
	@Field("Level 3-Engagement Role")
	private String level3EngagementRole;
	
	@Field("Email")
	private String email;
	
	@Field("Global Practice")
	private String globalPractice;
	
	@Field("Resigned LWD")
	private String resignedLwd;
	
	@Field("Loaned Out")
	private String loanedOut;
	
	@Field("Current Week Status")
	private String currentWeekStatus;
	

	@Field("Staffing Availability")
	private String staffingAvailable;
	
	@Field("Final Staffing Availability")
	private String finalStaffingAvailable;
	
	@Field("Billability")
	private String billability;
	
	@Field("Comments")
	private String comments;
	
	@Field("Final Status")
	private String finalStatus;
	
	@Field("Proposed/Pended to")
	private String proposedOrPendedTo;
	
	@Field("Projected Start Date")
	private String projectedStartDate;
	

	@Field("Projected End Date")
	private String projectedEndDate;
	
	@Field("Current Account")
	private String currentAccount;
	
	@Field("Primary Skill")
	private String primarySkill;
	
	@Field("Project Code")
	private String projectCode;
	
	@Field("Project Name")
	private String projectName;
	
	@Field("Start Date")
	private String startDate;
	
	@Field("END date")
	private String endDate;
	
	@Field("Fresher_Type")
	private String fresherType;
	
	@Field("Batch")
	private String batch;
	
	@Field("Promoted on")
	private String promotedOn;
	
	@Field("Status")
	private String status;
	
	@Field("CODE ISSUE")
	private String codeIssue;
	
	@Field("SECTOR/AREA/Market Unit")
	private String sectorAreaMarketUnit;
	
	@Field("Skill_1 Dashboarding")
	private String skill1Dasboarding;
	
	@Field("Training Start Date")
	private String trainingStartDate;
	
	@Field("Training end date")
	private String trainingEndDate ;
	
	@Field("TRAINING STREAM")
	private String trainingStream;
	
	@Field("Shadow project")
	private String shadowProject ;
	

	
	@Field("Shadow Start")
	private String shadowStart ;
	
	@Field("Shadow End")
	private String shadowEnd;
	
	@Field("Projected billing")
	private String projectedBillling ;
	
	@Field("Actual billing Date")
	private String actualBillingDate;
	
	@Field("Actual billed on account")
	private String actualBilledOnAccount ;

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", localGrade=" + localGrade + ", grade=" + grade
				+ ", mode=" + mode + ", fresherOrlateral=" + fresherOrlateral + ", cloudDoj=" + cloudDoj
				+ ", joiningDate=" + joiningDate + ", office=" + office + ", location=" + location + ", seat=" + seat
				+ ", benchStartDate=" + benchStartDate + ", agingDays=" + agingDays + ", agingStatus=" + agingStatus
				+ ", statusSince=" + statusSince + ", ageofStatus=" + ageofStatus + ", level1=" + level1
				+ ", level3EngagementRole=" + level3EngagementRole + ", email=" + email + ", globalPractice="
				+ globalPractice + ", resignedLwd=" + resignedLwd + ", loanedOut=" + loanedOut + ", currentWeekStatus="
				+ currentWeekStatus + ", staffingAvailable=" + staffingAvailable + ", finalStaffingAvailable="
				+ finalStaffingAvailable + ", billability=" + billability + ", comments=" + comments + ", finalStatus="
				+ finalStatus + ", proposedOrPendedTo=" + proposedOrPendedTo + ", projectedStartDate="
				+ projectedStartDate + ", projectedEndDate=" + projectedEndDate + ", currentAccount=" + currentAccount
				+ ", primarySkill=" + primarySkill + ", projectCode=" + projectCode + ", projectName=" + projectName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", fresherType=" + fresherType + ", batch="
				+ batch + ", promotedOn=" + promotedOn + ", status=" + status + ", codeIssue=" + codeIssue
				+ ", sectorAreaMarketUnit=" + sectorAreaMarketUnit + ", Skill1Dasboarding=" + skill1Dasboarding
				+ ", trainingStartDate=" + trainingStartDate + ", trainingEndDate=" + trainingEndDate
				+ ", trainingStream=" + trainingStream + ", shadowProject=" + shadowProject + ", shadowStart="
				+ shadowStart + ", shadowEnd=" + shadowEnd + ", projectedBillling=" + projectedBillling
				+ ", actualBillingDate=" + actualBillingDate + ", actualBilledOnAccount=" + actualBilledOnAccount + "]";
	}

	public Employee(String empId, String empName, String localGrade, String grade, String mode, String fresherOrlateral,
			String cloudDoj, String joiningDate, String office, String location, String seat, String benchStartDate,
			String agingDays, String agingStatus, String statusSince, String ageofStatus, String level1,
			String level3EngagementRole, String email, String globalPractice, String resignedLwd, String loanedOut,
			String currentWeekStatus, String staffingAvailable, String finalStaffingAvailable, String billability,
			String comments, String finalStatus, String proposedOrPendedTo, String projectedStartDate,
			String projectedEndDate, String currentAccount, String primarySkill, String projectCode, String projectName,
			String startDate, String endDate, String fresherType, String batch, String promotedOn, String status,
			String codeIssue, String sectorAreaMarketUnit, String skill1Dasboarding, String trainingStartDate,
			String trainingEndDate, String trainingStream, String shadowProject, String shadowStart, String shadowEnd,
			String projectedBillling, String actualBillingDate, String actualBilledOnAccount) {
		super();
		this.empId = empId;
		this.empName = empName;
		this.localGrade = localGrade;
		this.grade = grade;
		this.mode = mode;
		this.fresherOrlateral = fresherOrlateral;
		this.cloudDoj = cloudDoj;
		this.joiningDate = joiningDate;
		this.office = office;
		this.location = location;
		this.seat = seat;
		this.benchStartDate = benchStartDate;
		this.agingDays = agingDays;
		this.agingStatus = agingStatus;
		this.statusSince = statusSince;
		this.ageofStatus = ageofStatus;
		this.level1 = level1;
		this.level3EngagementRole = level3EngagementRole;
		this.email = email;
		this.globalPractice = globalPractice;
		this.resignedLwd = resignedLwd;
		this.loanedOut = loanedOut;
		this.currentWeekStatus = currentWeekStatus;
		this.staffingAvailable = staffingAvailable;
		this.finalStaffingAvailable = finalStaffingAvailable;
		this.billability = billability;
		this.comments = comments;
		this.finalStatus = finalStatus;
		this.proposedOrPendedTo = proposedOrPendedTo;
		this.projectedStartDate = projectedStartDate;
		this.projectedEndDate = projectedEndDate;
		this.currentAccount = currentAccount;
		this.primarySkill = primarySkill;
		this.projectCode = projectCode;
		this.projectName = projectName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.fresherType = fresherType;
		this.batch = batch;
		this.promotedOn = promotedOn;
		this.status = status;
		this.codeIssue = codeIssue;
		this.sectorAreaMarketUnit = sectorAreaMarketUnit;
		this.skill1Dasboarding = skill1Dasboarding;
		this.trainingStartDate = trainingStartDate;
		this.trainingEndDate = trainingEndDate;
		this.trainingStream = trainingStream;
		this.shadowProject = shadowProject;
		this.shadowStart = shadowStart;
		this.shadowEnd = shadowEnd;
		this.projectedBillling = projectedBillling;
		this.actualBillingDate = actualBillingDate;
		this.actualBilledOnAccount = actualBilledOnAccount;
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

	public String getLocalGrade() {
		return localGrade;
	}

	public void setLocalGrade(String localGrade) {
		this.localGrade = localGrade;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getMode() {
		return mode;
	}

	public void setMode(String mode) {
		this.mode = mode;
	}

	public String getFresherOrlateral() {
		return fresherOrlateral;
	}

	public void setFresherOrlateral(String fresherOrlateral) {
		this.fresherOrlateral = fresherOrlateral;
	}

	public String getCloudDoj() {
		return cloudDoj;
	}

	public void setCloudDoj(String cloudDoj) {
		this.cloudDoj = cloudDoj;
	}

	public String getJoiningDate() {
		return joiningDate;
	}

	public void setJoiningDate(String joiningDate) {
		this.joiningDate = joiningDate;
	}

	public String getOffice() {
		return office;
	}

	public void setOffice(String office) {
		this.office = office;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getSeat() {
		return seat;
	}

	public void setSeat(String seat) {
		this.seat = seat;
	}

	public String getBenchStartDate() {
		return benchStartDate;
	}

	public void setBenchStartDate(String benchStartDate) {
		this.benchStartDate = benchStartDate;
	}

	public String getAgingDays() {
		return agingDays;
	}

	public void setAgingDays(String agingDays) {
		this.agingDays = agingDays;
	}

	public String getAgingStatus() {
		return agingStatus;
	}

	public void setAgingStatus(String agingStatus) {
		this.agingStatus = agingStatus;
	}

	public String getStatusSince() {
		return statusSince;
	}

	public void setStatusSince(String statusSince) {
		this.statusSince = statusSince;
	}

	public String getAgeofStatus() {
		return ageofStatus;
	}

	public void setAgeofStatus(String ageofStatus) {
		this.ageofStatus = ageofStatus;
	}

	public String getLevel1() {
		return level1;
	}

	public void setLevel1(String level1) {
		this.level1 = level1;
	}

	public String getLevel3EngagementRole() {
		return level3EngagementRole;
	}

	public void setLevel3EngagementRole(String level3EngagementRole) {
		this.level3EngagementRole = level3EngagementRole;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getGlobalPractice() {
		return globalPractice;
	}

	public void setGlobalPractice(String globalPractice) {
		this.globalPractice = globalPractice;
	}

	public String getResignedLwd() {
		return resignedLwd;
	}

	public void setResignedLwd(String resignedLwd) {
		this.resignedLwd = resignedLwd;
	}

	public String getLoanedOut() {
		return loanedOut;
	}

	public void setLoanedOut(String loanedOut) {
		this.loanedOut = loanedOut;
	}

	public String getCurrentWeekStatus() {
		return currentWeekStatus;
	}

	public void setCurrentWeekStatus(String currentWeekStatus) {
		this.currentWeekStatus = currentWeekStatus;
	}

	public String getStaffingAvailable() {
		return staffingAvailable;
	}

	public void setStaffingAvailable(String staffingAvailable) {
		this.staffingAvailable = staffingAvailable;
	}

	public String getFinalStaffingAvailable() {
		return finalStaffingAvailable;
	}

	public void setFinalStaffingAvailable(String finalStaffingAvailable) {
		this.finalStaffingAvailable = finalStaffingAvailable;
	}

	public String getBillability() {
		return billability;
	}

	public void setBillability(String billability) {
		this.billability = billability;
	}

	public String getComments() {
		return comments;
	}

	public void setComments(String comments) {
		this.comments = comments;
	}

	public String getFinalStatus() {
		return finalStatus;
	}

	public void setFinalStatus(String finalStatus) {
		this.finalStatus = finalStatus;
	}

	public String getProposedOrPendedTo() {
		return proposedOrPendedTo;
	}

	public void setProposedOrPendedTo(String proposedOrPendedTo) {
		this.proposedOrPendedTo = proposedOrPendedTo;
	}

	public String getProjectedStartDate() {
		return projectedStartDate;
	}

	public void setProjectedStartDate(String projectedStartDate) {
		this.projectedStartDate = projectedStartDate;
	}

	public String getProjectedEndDate() {
		return projectedEndDate;
	}

	public void setProjectedEndDate(String projectedEndDate) {
		this.projectedEndDate = projectedEndDate;
	}

	public String getCurrentAccount() {
		return currentAccount;
	}

	public void setCurrentAccount(String currentAccount) {
		this.currentAccount = currentAccount;
	}

	public String getPrimarySkill() {
		return primarySkill;
	}

	public void setPrimarySkill(String primarySkill) {
		this.primarySkill = primarySkill;
	}

	public String getProjectCode() {
		return projectCode;
	}

	public void setProjectCode(String projectCode) {
		this.projectCode = projectCode;
	}

	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
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

	public String getFresherType() {
		return fresherType;
	}

	public void setFresherType(String fresherType) {
		this.fresherType = fresherType;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getPromotedOn() {
		return promotedOn;
	}

	public void setPromotedOn(String promotedOn) {
		this.promotedOn = promotedOn;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getCodeIssue() {
		return codeIssue;
	}

	public void setCodeIssue(String codeIssue) {
		this.codeIssue = codeIssue;
	}

	public String getSectorAreaMarketUnit() {
		return sectorAreaMarketUnit;
	}

	public void setSectorAreaMarketUnit(String sectorAreaMarketUnit) {
		this.sectorAreaMarketUnit = sectorAreaMarketUnit;
	}

	public String getSkill1Dasboarding() {
		return skill1Dasboarding;
	}

	public void setSkill1Dasboarding(String skill1Dasboarding) {
		this.skill1Dasboarding = skill1Dasboarding;
	}

	public String getTrainingStartDate() {
		return trainingStartDate;
	}

	public void setTrainingStartDate(String trainingStartDate) {
		this.trainingStartDate = trainingStartDate;
	}

	public String getTrainingEndDate() {
		return trainingEndDate;
	}

	public void setTrainingEndDate(String trainingEndDate) {
		this.trainingEndDate = trainingEndDate;
	}

	public String getTrainingStream() {
		return trainingStream;
	}

	public void setTrainingStream(String trainingStream) {
		this.trainingStream = trainingStream;
	}

	public String getShadowProject() {
		return shadowProject;
	}

	public void setShadowProject(String shadowProject) {
		this.shadowProject = shadowProject;
	}

	public String getShadowStart() {
		return shadowStart;
	}

	public void setShadowStart(String shadowStart) {
		this.shadowStart = shadowStart;
	}

	public String getShadowEnd() {
		return shadowEnd;
	}

	public void setShadowEnd(String shadowEnd) {
		this.shadowEnd = shadowEnd;
	}

	public String getProjectedBillling() {
		return projectedBillling;
	}

	public void setProjectedBillling(String projectedBillling) {
		this.projectedBillling = projectedBillling;
	}

	public String getActualBillingDate() {
		return actualBillingDate;
	}

	public void setActualBillingDate(String actualBillingDate) {
		this.actualBillingDate = actualBillingDate;
	}

	public String getActualBilledOnAccount() {
		return actualBilledOnAccount;
	}

	public void setActualBilledOnAccount(String actualBilledOnAccount) {
		this.actualBilledOnAccount = actualBilledOnAccount;
	}

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	
}

	