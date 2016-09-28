package com.sarindy.jdbcSpring;

import java.sql.Connection;

public class DataBaseConnectionManager {
	
	private IDatabase iDatabase;

	public IDatabase getiDatabase() {
		return iDatabase;
	}

	public void setiDatabase(IDatabase iDatabase) {
		this.iDatabase = iDatabase;
	}
	
	public Connection GetDBConnection(){
		return this.iDatabase.GetDataBaseObj();
		
	}
	
	

}
