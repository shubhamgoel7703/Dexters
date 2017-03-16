package com.accenture.dab.LookUpDAB;

import java.sql.SQLException;

import com.accenture.bean.EmployeeBean;

public interface ILookUpDAB {
	
	public int insertIntoLookUp(String tableName,String text) throws SQLException;

}