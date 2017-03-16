package com.accenture.bean;

import java.util.Date;

public class EmployeeBean {
	
private int project,level,resourceType,currentLocation,team,gender,visaType,rateType,homeTown;
@Override
public String toString() {
	return "EmployeeBean [project=" + project + ", level=" + level + ", resourceType=" + resourceType
			+ ", currentLocation=" + currentLocation + ", team=" + team + ", gender=" + gender + ", visaType="
			+ visaType + ", rateType=" + rateType + ", homeTown=" + homeTown + ", name=" + name + ", personnalNo="
			+ personnalNo + ", supervisor=" + supervisor + ", enterpriseId=" + enterpriseId + ", contactDetails="
			+ contactDetails + ", lockStartDate=" + lockStartDate + ", billableDate=" + billableDate + ", RollOffDate="
			+ RollOffDate + ", joinDate=" + joinDate + ", dob=" + dob + ", gcp=" + gcp + "]";
}

private String name,personnalNo,supervisor,enterpriseId,contactDetails;
private Date lockStartDate,billableDate,RollOffDate,joinDate,dob;
private boolean gcp;


public int getProject() {
	return project;
}
public void setProject(int project) {
	this.project = project;
}
public int getLevel() {
	return level;
}
public void setLevel(int level) {
	this.level = level;
}
public int getResourceType() {
	return resourceType;
}
public void setResourceType(int resourceType) {
	this.resourceType = resourceType;
}
public int getCurrentLocation() {
	return currentLocation;
}
public void setCurrentLocation(int currentLocation) {
	this.currentLocation = currentLocation;
}
public int getTeam() {
	return team;
}
public void setTeam(int team) {
	this.team = team;
}
public int getGender() {
	return gender;
}
public void setGender(int gender) {
	this.gender = gender;
}
public int getVisaType() {
	return visaType;
}
public void setVisaType(int visaType) {
	this.visaType = visaType;
}
public int getRateType() {
	return rateType;
}
public void setRateType(int rateType) {
	this.rateType = rateType;
}
public int getHomeTown() {
	return homeTown;
}
public void setHomeTown(int homeTown) {
	this.homeTown = homeTown;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPersonnalNo() {
	return personnalNo;
}
public void setPersonnalNo(String personnalNo) {
	this.personnalNo = personnalNo;
}
public String getSupervisor() {
	return supervisor;
}
public void setSupervisor(String supervisor) {
	this.supervisor = supervisor;
}
public String getEnterpriseId() {
	return enterpriseId;
}
public void setEnterpriseId(String enterpriseId) {
	this.enterpriseId = enterpriseId;
}
public String getContactDetails() {
	return contactDetails;
}
public void setContactDetails(String contactDetails) {
	this.contactDetails = contactDetails;
}
public Date getLockStartDate() {
	return lockStartDate;
}
public void setLockStartDate(Date lockStartDate) {
	this.lockStartDate = lockStartDate;
}
public Date getBillableDate() {
	return billableDate;
}
public void setBillableDate(Date billableDate) {
	this.billableDate = billableDate;
}
public Date getRollOffDate() {
	return RollOffDate;
}
public void setRollOffDate(Date rollOffDate) {
	RollOffDate = rollOffDate;
}
public Date getJoinDate() {
	return joinDate;
}
public void setJoinDate(Date joinDate) {
	this.joinDate = joinDate;
}
public Date getDob() {
	return dob;
}
public void setDob(Date dob) {
	this.dob = dob;
}
public boolean isGcp() {
	return gcp;
}
public void setGcp(boolean gcp) {
	this.gcp = gcp;
}


}
