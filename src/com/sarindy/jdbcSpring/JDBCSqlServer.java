package com.sarindy.jdbcSpring;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JDBCSqlServer implements IDatabase {

	private String userName;
	private String pwd;
	private String dbUri;
	private String driverName;

	public void setDriverName(String driverName) {
		this.driverName = driverName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	public void setDbUri(String dbUri) {
		this.dbUri = dbUri;
	}

	@Override
	public Connection GetDataBaseObj() {
		try {
			Class.forName(this.driverName);
			try {
				Connection conn = DriverManager.getConnection(this.dbUri,
						this.userName, this.pwd);
				if (conn != null) {
					return conn;
				}
			} catch (SQLException sqlEx) {
				System.out.println(sqlEx);
			}
		} catch (ClassNotFoundException cnfEx) {
			System.out.println(cnfEx);
		}
		return null;

	}

	@Override
	public void CloseDatabase() {
		try {
			this.GetDataBaseObj().close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
