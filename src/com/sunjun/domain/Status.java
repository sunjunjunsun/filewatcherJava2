package com.sunjun.domain;

public class Status {

	private String serialNumber;
	private String location;
	private String pin;
	private String errCode;
	
	private String repairStatus;
	private String imageFilename;
	private String algorithm;
	private String subType;
	
	
	
	public String getAlgorithm() {
		return algorithm;
	}
	public void setAlgorithm(String algorithm) {
		this.algorithm = algorithm;
	}
	public String getSubType() {
		return subType;
	}
	public void setSubType(String subType) {
		this.subType = subType;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getPin() {
		return pin;
	}
	public void setPin(String pin) {
		this.pin = pin;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getErrCode() {
		return errCode;
	}
	public void setErrCode(String errCode) {
		this.errCode = errCode;
	}
	
	public String getRepairStatus() {
		return repairStatus;
	}
	public void setRepairStatus(String repairStatus) {
		this.repairStatus = repairStatus;
	}
	public String getImageFilename() {
		return imageFilename;
	}
	public void setImageFilename(String imageFilename) {
		this.imageFilename = imageFilename;
	}
	@Override
	public String toString() {
		return "Status [serialNumber=" + serialNumber + ", location=" + location + ", pin=" + pin + ", errCode="
				+ errCode + ", repairStatus=" + repairStatus + ", imageFilename=" + imageFilename + ", algorithm="
				+ algorithm + ", subType=" + subType + "]";
	}

	
	
	
	
	
	
	
	
	
}
