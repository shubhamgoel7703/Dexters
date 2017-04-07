package com.accenture.dab;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.accenture.bean.EmployeeBean;
import com.accenture.dab.EmpDAB.EmpDAB;
import com.accenture.pab.EmpPAB.EmpPAB;
import com.accenture.pab.LookUpPAB.LookUpPAB;

public class StartUpClass {

	public static void main(String[] args) throws SQLException {
		// TODO Auto-generated method stub

		// EmpDAB Object created
		System.out.println("hello");
	//	LookUpPAB lookUpPAB = LookUpPAB.getInstance();
		System.out.println("1");
	//	lookUpPAB.insertIntoLookUp();
		System.out.println("2");
		char c =115;
		int s = c;
		System.out.println(c);
		/*EmpDAB empdab = EmpDAB.getInstance();
		
		empdab.deleteTableRow();
		empdab.updateTableRow();*/
		
	/*	List<EmployeeBean> list = new ArrayList<EmployeeBean>();
		list = empdab.getLookUpData();
		  
		System.out.println("comig"); System.out.println(list.get(0));
		 
		
		
		
		/// insert in employee database ///
		
		EmployeeBean emp = new EmployeeBean();
		emp.setProject(1);
		emp.setName("Shubham");
		emp.setGcp(true);
		emp.setPersonnalNo("11190184");
		emp.setLevel(10);
		emp.setResourceType(2);
		emp.setCurrentLocation(2);
		// emp.setLockStartDate(sqlDate);
		// emp.setBillableDate(sqlDate);
		// emp.setRollOffDate(sqlDate);
		// emp.setJoinDate(sqlDate);
		emp.setTeam(2);
		emp.setGender(1);
		emp.setSupervisor("1234");
		emp.setVisaType(2);

		emp.setRateType(2);
		emp.setEnterpriseId("12345");
		emp.setContactDetails("123456");
		// emp.setDob(sqlDate);
		emp.setHomeTown(1);
		empdab.insertIntoTable(emp);*/
		
		
	}


}
