package com.sun.student.model.vo;

import java.sql.Date;

public class StudentConsulting {
	private int csNo;//식별번호
	private String sId;//학번
	private String csContent;//상담내용
	private Date csDate;//상담날짜
	private String csTime;//상담시간
	private String csWay;//상담방식
	private String csType;//상담구분
	
	public StudentConsulting() {
		// TODO Auto-generated constructor stub
	}

	public StudentConsulting(int csNo, String csContent, Date csDate, String csTime, String csWay,
			String csType) {
		super();
		this.csNo = csNo;
		this.sId = sId;
		this.csContent = csContent;
		this.csDate = csDate;
		this.csTime = csTime;
		this.csWay = csWay;
		this.csType = csType;
	}

	public int getCsNo() {
		return csNo;
	}

	public void setCsNo(int csNo) {
		this.csNo = csNo;
	}

	public String getsId() {
		return sId;
	}

	public void setsId(String sId) {
		this.sId = sId;
	}

	public String getCsContent() {
		return csContent;
	}

	public void setCsContent(String csContent) {
		this.csContent = csContent;
	}

	public Date getCsDate() {
		return csDate;
	}

	public void setCsDate(Date csDate) {
		this.csDate = csDate;
	}

	public String getCsTime() {
		return csTime;
	}

	public void setCsTime(String csTime) {
		this.csTime = csTime;
	}

	public String getCsWay() {
		return csWay;
	}

	public void setCsWay(String csWay) {
		this.csWay = csWay;
	}

	public String getCsType() {
		return csType;
	}

	public void setCsType(String csType) {
		this.csType = csType;
	}
}
