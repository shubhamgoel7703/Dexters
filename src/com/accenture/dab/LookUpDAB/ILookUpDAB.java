package com.accenture.dab.LookUpDAB;

import java.sql.SQLException;

import com.accenture.bean.LookUpBean;

public interface ILookUpDAB {

	public int insertIntoLookUp(String tableName, String text) throws SQLException;

	public int updateLookUpBean(String tableName, LookUpBean lookBean) throws SQLException;

	public boolean deleteLookUpBean(String tableName, int id) throws SQLException;

	public LookUpBean retriveFromLookUp(String tableName) throws SQLException;

}