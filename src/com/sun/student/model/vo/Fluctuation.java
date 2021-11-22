package com.sun.student.model.vo;

import java.sql.Date;

import com.sun.user.model.vo.User;

public class Fluctuation extends User{
	
	private int flNo; //식별번호 non-nullable
	private String sId; //학번 non-nullable
	private String flChange; //변동사항
	private String flReason; //변동사유
	private int flYear; //연도
	private int flSemester; //학기
	private Date flDate; //변동일자 - 시스데이트 디폴트
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "[ 식별번호 : " + flNo + ", 학번 : " + sId + ", 변동사항 : " + flChange + ", 변동사유 : " + flReason 
				+ ", 연도 : " + flYear + ", 학기 : " + flSemester + ", 변동일자 : " + flDate + "]";
	}

	
	public Fluctuation() {
		super();
	}


	public Fluctuation(int flNo, String sId, String flChange, String flReason, int flYear, int flSemester,
			Date flDate) {
		super();
		this.flNo = flNo;
		this.sId = sId;
		this.flChange = flChange;
		this.flReason = flReason;
		this.flYear = flYear;
		this.flSemester = flSemester;
		this.flDate = flDate;
	}


	public int getFlNo() {
		return flNo;
	}


	public void setFlNo(int flNo) {
		this.flNo = flNo;
	}


	public String getsId() {
		return sId;
	}


	public void setsId(String sId) {
		this.sId = sId;
	}


	public String getFlChange() {
		return flChange;
	}


	public void setFlChange(String flChange) {
		this.flChange = flChange;
	}


	public String getFlReason() {
		return flReason;
	}


	public void setFlReason(String flReason) {
		this.flReason = flReason;
	}


	public int getFlYear() {
		return flYear;
	}


	public void setFlYear(int flYear) {
		this.flYear = flYear;
	}


	public int getFlSemester() {
		return flSemester;
	}


	public void setFlSemester(int flSemester) {
		this.flSemester = flSemester;
	}


	public Date getFlDate() {
		return flDate;
	}


	public void setFlDate(Date flDate) {
		this.flDate = flDate;
	}
	
	
	
	
	
	
	
	
}