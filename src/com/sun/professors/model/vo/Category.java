package com.sun.professors.model.vo;

public class Category {
	private String categoryNo;
	private String categoryName;

	public Category() {
		// TODO Auto-generated constructor stub
	}
	
	public Category(String categoryNo, String categoryName) {
		super();
		this.categoryNo = categoryNo;
		this.categoryName = categoryName;
	}
	public String getCategoryNo() {
		return categoryNo;
	}

	public void setCategoryNo(String categoryNo) {
		this.categoryNo = categoryNo;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}


}
