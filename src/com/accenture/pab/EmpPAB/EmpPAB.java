package com.accenture.pab.EmpPAB;

import java.sql.SQLException;
import java.util.List;

import com.accenture.bean.EmployeeBean;
import com.accenture.dab.EmpDAB.EmpDABFactory;

public class EmpPAB {

	private static EmpPAB instance = null;
	private static EmpDABFactory empDABFactory = null;

	private EmpPAB() {
		// Exists only to defeat instantiation.
	}

	public static EmpPAB getInstance() {
		if (instance == null) {
			// synchronized(instance)
			{
				if (instance == null)
					instance = new EmpPAB();
			}
		}
		return instance;
	}

	public int insertIntoEmp(EmployeeBean empbean) throws SQLException {
		// empDAB = EmpDAB.getInstance();

		return empDABFactory.objCreator().insertIntoEmployee(empbean);
	}

	public List<EmployeeBean> getEmployeeBeanList() throws SQLException {
		// empDAB = EmpDAB.getInstance();

		return empDABFactory.objCreator().getEmployeeBeanList();
	}

	public EmployeeBean getEmployeeBean(String EmpId) throws SQLException {
		// empDAB = EmpDAB.getInstance();

		return empDABFactory.objCreator().getEmpBean(EmpId);
	}

	public int stateUpdateEmployeeBean(EmployeeBean empBean) throws SQLException {
		// empDAB = EmpDAB.getInstance();

		return empDABFactory.objCreator().stateUpdateEmployeeBean(empBean);
	}

	public int updateEmployeeBean(EmployeeBean empBean) throws SQLException {
		// empDAB = EmpDAB.getInstance();

		return empDABFactory.objCreator().updateEmployeeBean(empBean);
	}

}
