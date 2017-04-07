package com.accenture.dab.EmpDAB;

import java.sql.SQLException;
import java.util.List;

import com.accenture.bean.EmployeeBean;

public interface IEmpDAB {
	/**
	 * 
	 * @param emp
	 * @return
	 */
	public int insertIntoEmployee(EmployeeBean emp) throws SQLException;

	public List<EmployeeBean> getEmployeeBeanList() throws SQLException;

	public EmployeeBean getEmpBean(String empId) throws SQLException;

	public int stateUpdateEmployeeBean(EmployeeBean employeebean) throws SQLException;

	public int updateEmployeeBean(EmployeeBean employeebean) throws SQLException;

}
