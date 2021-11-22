package com.sun.student.model.vo;

import java.util.Date;

public class Certificate {

	private int cfNo;
	private String sId;
	private String cfName;
	private String cfIssue;
	private Date cfDate;
	private String cfAttachment;
	private String cfId;
	
	public Certificate() {
		super();
	}

	public Certificate(int cfNo, String sId, String cfName, String cfIssue, Date cfDate, String cfAttachment,
			String cfId) {
		super();
		this.cfNo = cfNo;
		this.sId = sId;
		this.cfName = cfName;
		this.cfIssue = cfIssue;
		this.cfDate = cfDate;
		this.cfAttachment = cfAttachment;
		this.cfId = cfId;
	}

	public int getCfNo() {
		return cfNo;
	}

	public void setCfNo(int cfNo) {
		this.cfNo = cfNo;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getCfName() {
		return cfName;
	}

	public void setCfName(String cfName) {
		this.cfName = cfName;
	}

	public String getCfIssue() {
		return cfIssue;
	}

	public void setCfIssue(String cfIssue) {
		this.cfIssue = cfIssue;
	}

	public Date getCfDate() {
		return cfDate;
	}

	public void setCfDate(Date cfDate) {
		this.cfDate = cfDate;
	}

	public String getCfAttachment() {
		return cfAttachment;
	}

	public void setCfAttachment(String cfAttachment) {
		this.cfAttachment = cfAttachment;
	}

	public String getCfId() {
		return cfId;
	}

	public void setCfId(String cfId) {
		this.cfId = cfId;
	}

	
}
