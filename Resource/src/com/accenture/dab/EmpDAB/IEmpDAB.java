package com.accenture.dab.EmpDAB;

import java.util.List;

import com.accenture.bean.EmployeeBean;

public interface IEmpDAB 
{
	/**
	 * 
	 * @param emp
	 * @return
	 */
	public int insertIntoEmployee(EmployeeBean emp);
	public List<EmployeeBean> getEmployeeBeanList();
	public EmployeeBean getEmpBean(String empId);
	public int deleteEmployeeBean();
	public int updateEmployeeBean();	
	
}
