package com.coforge.day5.jdbc;

import java.sql.Connection;  //interface
import java.sql.DriverManager;   //class
import java.sql.PreparedStatement;  //interface

public class JdbcDeleteTest {

	public static void main(String[] args) throws Exception {
		// step 1 : Load Driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
		// step 2 : Connect with DB
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/db", "root", "Sql#2026");
		
		// step 3 : Creating Statement
		String sql = "delete from tbl_employee where eid = ?";  //creating query template using PreparedStatement.
		PreparedStatement statement = connection.prepareStatement(sql);
		
		// step 4 : Executing query
		statement.setInt(1, 102);
		
		int n = statement.executeUpdate(); //method for insert update delete
		if(n==1) {
			System.out.println("Employee Details saved.");
		} else {
			System.out.println("Employee Details not saved.");
		}
		
		// step 5 : Close connection
		statement.close();
		connection.close();
	}
	
}
