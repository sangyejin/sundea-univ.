package com.sun.admin.model.dao;

import java.util.Properties;

import com.sun.common.CommonDao;
import com.sun.student.model.vo.Student;

public class AdminDao {
	
	public AdminDao() {
		String fileName = Student.class.getResource("/sql/admin/admin-query.properties").getPath();
		Properties prop= new CommonDao().propLoad(fileName);
		//
	}
	
	
}
