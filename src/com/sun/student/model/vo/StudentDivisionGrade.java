package com.sun.student.model.vo;

public class StudentDivisionGrade {
	private int classTypeNo;//이수구분 번호
	private int classCreditSum;//이수구분 별 취득학점
	private int prerequisiteEss;//전공필수
	private int prerequisiteSel;//전공선택
	private int electiveEss;//교양필수
	private int electiveSel;//교양선택
	private int industry;//산학
	private int free;//자유
	
	public StudentDivisionGrade(int classTypeNo, int classCreditSum) {
		super();
		this.classTypeNo = classTypeNo;
		this.classCreditSum = classCreditSum;
	}

	public StudentDivisionGrade(int prerequisiteEss, int prerequisiteSel, int electiveEss, int electiveSel,
			int industry, int free) {
		super();
		this.prerequisiteEss = prerequisiteEss;
		this.prerequisiteSel = prerequisiteSel;
		this.electiveEss = electiveEss;
		this.electiveSel = electiveSel;
		this.industry = industry;
		this.free = free;
	}

	public StudentDivisionGrade(int classCreditSum) {
		super();
		this.classCreditSum = classCreditSum;
	}

	public int getClassTypeNo() {
		return classTypeNo;
	}

	public void setClassTypeNo(int classTypeNo) {
		this.classTypeNo = classTypeNo;
	}

	public int getClassCreditSum() {
		return classCreditSum;
	}

	public void setClassCreditSum(int classCreditSum) {
		this.classCreditSum = classCreditSum;
	}

	public int getPrerequisiteEss() {
		return prerequisiteEss;
	}

	public void setPrerequisiteEss(int prerequisiteEss) {
		this.prerequisiteEss = prerequisiteEss;
	}

	public int getPrerequisiteSel() {
		return prerequisiteSel;
	}

	public void setPrerequisiteSel(int prerequisiteSel) {
		this.prerequisiteSel = prerequisiteSel;
	}

	public int getElectiveEss() {
		return electiveEss;
	}

	public void setElectiveEss(int electiveEss) {
		this.electiveEss = electiveEss;
	}

	public int getElectiveSel() {
		return electiveSel;
	}

	public void setElectiveSel(int electiveSel) {
		this.electiveSel = electiveSel;
	}

	public int getIndustry() {
		return industry;
	}

	public void setIndustry(int industry) {
		this.industry = industry;
	}

	public int getFree() {
		return free;
	}

	public void setFree(int free) {
		this.free = free;
	}

	@Override
	public String toString() {
		return "StudentDivisionGrade [classTypeNo=" + classTypeNo + ", classCreditSum=" + classCreditSum
				+ ", prerequisiteEss=" + prerequisiteEss + ", prerequisiteSel=" + prerequisiteSel + ", electiveEss="
				+ electiveEss + ", electiveSel=" + electiveSel + ", industry=" + industry + ", free=" + free + "]";
	}
	
	
}
