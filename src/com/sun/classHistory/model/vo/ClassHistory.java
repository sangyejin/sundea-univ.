package com.sun.classHistory.model.vo;

public class ClassHistory {
	private String sId;
	private String sName;
	private float cgPoint;
	private String cateName;
	
	public ClassHistory() {
		// TODO Auto-generated constructor stub
	}



	public ClassHistory(String sId, String sName, float cgPoint, String cateName) {
		super();
		this.sId = sId;
		this.sName = sName;
		this.cgPoint = cgPoint;
		this.cateName = cateName;
	}



	public ClassHistory(String sId, float cgPoint) {
		super();
		this.sId = sId;
		this.cgPoint = cgPoint;
	}



	public String getsId() {
		return sId;
	}



	public void setsId(String sId) {
		this.sId = sId;
	}



	public String getsName() {
		return sName;
	}

	public void setsName(String sName) {
		this.sName = sName;
	}

	

	public float getCgPoint() {
		return cgPoint;
	}

	public void setCgPoint(float cgPoint) {
		this.cgPoint = cgPoint;
	}

	public String getCateName() {
		return cateName;
	}

	public void setCateName(String cateName) {
		this.cateName = cateName;
	}

}
