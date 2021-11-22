package com.sun.student.model.vo;

public class StudentSemeterGrade {

	private int sId;//학번
	private int gradeNo;//학기별 성적 순번
	private int year;//년도 
	private int semester;//학기 
	private int appliCredit;//신청학점
	private int earnCredit;//취득학점
	private double avgCredit;//학점평균
	private double percent;//백분율
	private int rank;//전공석차
	
	

	public StudentSemeterGrade(int year, int semester, int appliCredit, double avgCredit, double percent) {
		super();
		this.year = year;
		this.semester = semester;
		this.appliCredit = appliCredit;
		this.earnCredit = earnCredit;
		this.avgCredit = avgCredit;
		this.percent = percent;
	}


	public StudentSemeterGrade(int sId, int year, int semester) {
		super();
		this.sId = sId;
		this.year = year;
		this.semester = semester;
	}


	public StudentSemeterGrade(int rank) {
		super();
		this.rank = rank;
	}


	public int getsId() {
		return sId;
	}



	public void setsId(int sId) {
		this.sId = sId;
	}



	public int getGradeNo() {
		return gradeNo;
	}



	public void setGradeNo(int gradeNo) {
		this.gradeNo = gradeNo;
	}



	public int getYear() {
		return year;
	}



	public void setYear(int year) {
		this.year = year;
	}



	public int getSemester() {
		return semester;
	}



	public void setSemester(int semester) {
		this.semester = semester;
	}



	public int getAppliCredit() {
		return appliCredit;
	}



	public void setAppliCredit(int appliCredit) {
		this.appliCredit = appliCredit;
	}



	public int getEarnCredit() {
		return earnCredit;
	}



	public void setEarnCredit(int earnCredit) {
		this.earnCredit = earnCredit;
	}



	public double getAvgCredit() {
		return avgCredit;
	}



	public void setAvgCredit(double avgCredit) {
		this.avgCredit = avgCredit;
	}



	public double getPercent() {
		return percent;
	}



	public void setPercent(double percent) {
		this.percent = percent;
	}


	public int getRank() {
		return rank;
	}


	public void setRank(int rank) {
		this.rank = rank;
	}

}
