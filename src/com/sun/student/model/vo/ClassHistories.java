package com.sun.student.model.vo;

public class ClassHistories {
	private int classYear;
	private int classSemester;
	private String className;
	private int credit;
	private String typeName;
	private String pName;
	
	public ClassHistories() {
		super();
	}

	public ClassHistories(int classYear, int classSemester, String className, int credit, String typeName,
			String pName) {
		super();
		this.classYear = classYear;
		this.classSemester = classSemester;
		this.className = className;
		this.credit = credit;
		this.typeName = typeName;
		this.pName = pName;
	}

	public int getClassYear() {
		return classYear;
	}

	public void setClassYear(int classYear) {
		this.classYear = classYear;
	}

	public int getClassSemester() {
		return classSemester;
	}

	public void setClassSemester(int classSemester) {
		this.classSemester = classSemester;
	}

	public String getClassName() {
		return className;
	}

	public void setClassName(String className) {
		this.className = className;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}
	
	

}
