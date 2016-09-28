package com.sarindy.jdbcSpring;

import java.sql.Connection;

public interface IDatabase {
	
	public Connection GetDataBaseObj();
	
	public void CloseDatabase();
	

}
