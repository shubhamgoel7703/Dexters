package com.accenture.dab.LookUpDAB;

import com.accenture.dab.EmpDAB.EmpDAB;
import com.accenture.dab.EmpDAB.EmpDABFactory;
import com.accenture.dab.EmpDAB.IEmpDAB;

public class LookUpDABFactory {
	
	private static LookUpDABFactory instance =null;
	 
	   private LookUpDABFactory() {
	      // Exists only to defeat instantiation.
	   }

	public static LookUpDABFactory getInstance() {
	      if(instance == null) {
	    	 // synchronized(instance)
	    	  	{
	    		  if(instance==null)
	    		  instance = new LookUpDABFactory();
	    	  	}
	      }
	      return instance;
	   }
	
	LookUpDAB iLookUpDAB = null;
	
	public LookUpDAB ObjCreator()
	{
		// if connection exists
		iLookUpDAB = LookUpDAB.getInstance();
		
		// else
		//iEmpDAB = MockEmpDAB.getInstance();
		
		return iLookUpDAB;
	}

}
