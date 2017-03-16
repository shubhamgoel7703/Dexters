package com.accenture.dab.EmpDAB;

public class EmpDABFactory {
	
	private static EmpDABFactory instance =null;
	 
	   private EmpDABFactory() {
	      // Exists only to defeat instantiation.
	   }

	public static EmpDABFactory getInstance() {
	      if(instance == null) {
	    	//  synchronized(instance)
	    	  {
	    		  if(instance==null)
	    		  instance = new EmpDABFactory();
	    		  }
	      }
	      return instance;
	   }
	
	EmpDAB iEmpDAB = null;
	
	public EmpDAB ObjCreator()
	{
		// if connection exists
		iEmpDAB = EmpDAB.getInstance();
		
		// else
		//iEmpDAB = MockEmpDAB.getInstance();
		
		return iEmpDAB;
	}
}
