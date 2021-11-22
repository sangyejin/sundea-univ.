package com.sun.classHistory.model.service;

import static com.sun.common.JDBCTemplate.*;

import java.sql.Connection;
import java.util.ArrayList;

import com.sun.classHistory.model.dao.ClassHistoryDao;
import com.sun.classHistory.model.vo.ClassHistory;

public class ClassHistoryService {

	public ArrayList<ClassHistory> selectchList(String cId) {
		Connection conn = getConnection();
		ArrayList<ClassHistory> chList = new ClassHistoryDao().selectchList(conn,cId);
		close(conn);
		return chList;
	}

	public int updateCh(ArrayList<ClassHistory> chList,String classNo) {
		Connection conn = getConnection();
		ArrayList<Integer> rList=new ArrayList<Integer>();
		int result=1;
		if(! chList.isEmpty()) {
			for(int i=0; i<chList.size();i++) {
				int rtemp=0;
				rtemp=new ClassHistoryDao().updateCh(conn,chList.get(i),classNo);
				rList.add(rtemp);

			}
		}
		if(!rList.isEmpty()) {
			for(int r: rList) {
				if(r<1) {
					result=-1;
				}
			}
		}
		
		if(result>0) {
			commit(conn);
			
		}
		else {
			rollback(conn);
		}
		
		close(conn);
		return result;
	}

	

}
