package com.accenture.pab.LookUpPAB;

import java.sql.SQLException;

import com.accenture.bean.LookUpBean;
import com.accenture.dab.LookUpDAB.LookUpDABFactory;

public class LookUpPAB {

	private static LookUpPAB instance = null;
	private static LookUpDABFactory lookUpDabFactory = null;

	private LookUpPAB() {
		// Exists only to defeat instantiation.
	}

	public static LookUpPAB getInstance() {
		if (instance == null) {
			// synchronized(instance)
			{
				if (instance == null)
					instance = new LookUpPAB();
			}
		}
		return instance;
	}

	public int insertIntoLookUp(String tablename, String text) throws SQLException {
		// LookUpDABFactory lookUpDABFactory = LookUpDABFactory.getInstance();

		return lookUpDabFactory.objCreator().insertIntoLookUp(tablename, text);
	}

	public LookUpBean retrieveLookUp(String tablename) throws SQLException {
		// LookUpDABFactory lookUpDABFactory = LookUpDABFactory.getInstance();

		return lookUpDabFactory.objCreator().retriveFromLookUp(tablename);
	}

	public boolean deleteLookUp(String tablename, int id) throws SQLException {
		// LookUpDABFactory lookUpDABFactory = LookUpDABFactory.getInstance();

		return lookUpDabFactory.objCreator().deleteLookUpBean(tablename, id);
	}
}
