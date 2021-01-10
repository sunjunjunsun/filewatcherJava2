package com.sunjun.domain;

import java.io.Serializable;
import java.util.Date;

public class Border implements Serializable{

	private Long id; //
	private Date testTime;  // 
	private String serialNumber; // 
	private String testerName;  //   V810-8088S2
	private String testStatus;  //
	private String boardType;    // 
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getTestTime() {
		return testTime;
	}
	public void setTestTime(Date testTime) {
		this.testTime = testTime;
	}
	public String getSerialNumber() {
		return serialNumber;
	}
	public void setSerialNumber(String serialNumber) {
		this.serialNumber = serialNumber;
	}
	public String getTesterName() {
		return testerName;
	}
	public void setTesterName(String testerName) {
		this.testerName = testerName;
	}
	public String getTestStatus() {
		return testStatus;
	}
	public void setTestStatus(String testStatus) {
		this.testStatus = testStatus;
	}
	public String getBoardType() {
		return boardType;
	}
	public void setBoardType(String boardType) {
		this.boardType = boardType;
	}
	@Override
	public String toString() {
		return "Border [id=" + id + ", testTime=" + testTime + ", serialNumber=" + serialNumber + ", testerName="
				+ testerName + ", testStatus=" + testStatus + ", boardType=" + boardType + "]";
	}
	
	
	
	
	
	
}
