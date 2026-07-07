package com.coforge.day5.jdbc;

import java.sql.Connection;  //interface
import java.sql.DriverManager;   //class
import java.sql.PreparedStatement;  //interface
import java.sql.ResultSet;

public class JdbcSelectTest {

	public static void main(String[] args) throws Exception {
		// step 1 : Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// step 2 : Connect with DB
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Sql#2026");
		
		// step 3 : Creating Statement
		String sql = "select * from tbl_employee";  //creating query template using PreparedStatement.
		PreparedStatement statement = connection.prepareStatement(sql);
		
		// step 4 : Executing query
		ResultSet result = statement.executeQuery(); // for select query
		while(result.next()) {
			System.out.println(result.getInt("eid") + " " + result.getString("ename") + " " + result.getInt("esalary") + " " + result.getInt("dno"));
		}
		
		// step 5 : Close connection
		result.close();
		statement.close();
		connection.close();
	}
	
}
