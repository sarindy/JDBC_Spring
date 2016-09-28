package com.sarindy.jdbcSpring;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class DemoApps {

	public static void main(String[] args) throws SQLException {

		@SuppressWarnings("resource")
		ApplicationContext context = new ClassPathXmlApplicationContext(
				"jdbcSpringConfig.xml");
		DataBaseConnectionManager dbObj = (DataBaseConnectionManager) context
				.getBean("dataBaseConnectionBean");

		Connection myConn = dbObj.GetDBConnection();

		PreparedStatement prepareStatement = null;
		String selectSQL = "select first_name,last_name from tbl_customer";

		prepareStatement = myConn.prepareStatement(selectSQL);
		// prepareStatement.setInt(1, custAcctid);//1 is the index of the
		// parameter and custAcctid is the parameter
		ResultSet rs = prepareStatement.executeQuery();

		while (rs.next()) {
			System.out.println(rs.getString("FIRST_NAME") + " "
					+ rs.getString("LAST_NAME"));

		}
		
		rs.close();
		dbObj.CloseDataBase();
	}
}
