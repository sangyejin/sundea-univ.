package com.sun.professors.model.dto;

import java.util.ArrayList;

import com.sun.student.model.vo.PageInfo;
import com.sun.student.model.vo.StudentConsulting;

public class ConsultingPageInfoDto {
	private PageInfo pi;
	private ArrayList<StudentConsulting> sc;
	
	public ConsultingPageInfoDto() {
		// TODO Auto-generated constructor stub
	}

	public ConsultingPageInfoDto(PageInfo pi, ArrayList<StudentConsulting> sc) {
		super();
		this.pi = pi;
		this.sc = sc;
	}

	public PageInfo getPi() {
		return pi;
	}

	public void setPi(PageInfo pi) {
		this.pi = pi;
	}

	public ArrayList<StudentConsulting> getSc() {
		return sc;
	}

	public void setSc(ArrayList<StudentConsulting> sc) {
		this.sc = sc;
	}
	
}
