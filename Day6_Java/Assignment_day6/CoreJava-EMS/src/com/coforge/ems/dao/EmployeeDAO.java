package com.coforge.ems.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.coforge.ems.model.Employee;
import com.coforge.ems.util.ApplicationProperties;
import com.coforge.ems.util.DBUtil;

public class EmployeeDAO {

	public int createEmployee(Employee employee) throws ClassNotFoundException, SQLException {

		int n = 0;

		Connection connection = DBUtil.getDBConnection();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.insert);

		statement.setInt(1, employee.getEid());
		statement.setString(2, employee.getEname());
		statement.setInt(3, employee.getEsalary());
		statement.setInt(4, employee.getDno());

		n = statement.executeUpdate();

		return n;
	}

	public int updateEmployeeId(int id, int newId) throws ClassNotFoundException, SQLException {

	    int n = 0;

	    Connection connection = DBUtil.getDBConnection();

	    PreparedStatement statement = connection.prepareStatement(ApplicationProperties.updateID);

	    statement.setInt(1, newId);
	    statement.setInt(2, id);

	    n = statement.executeUpdate();

	    return n;
	}

	public int updateEmployeeName(int id, String newName) throws ClassNotFoundException, SQLException {

		int n = 0;

		Connection connection = DBUtil.getDBConnection();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.updateName);

		statement.setString(1, newName);
		statement.setInt(2, id);

		n = statement.executeUpdate();

		return n;
	}

	public int updateEmployeeSalary(int id, int newSalary) throws ClassNotFoundException, SQLException {

		int n = 0;

		Connection connection = DBUtil.getDBConnection();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.updateSalary);

		statement.setInt(1, newSalary);
		statement.setInt(2, id);

		n = statement.executeUpdate();

		return n;
	}

	public int updateEmployeeDepartment(int id, int newDept) throws ClassNotFoundException, SQLException {

		int n = 0;

		Connection connection = DBUtil.getDBConnection();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.updateDno);

		statement.setInt(1, newDept);
		statement.setInt(2, id);

		n = statement.executeUpdate();

		return n;
	}

	public int deleteEmployee(int id) throws ClassNotFoundException, SQLException {

		int n = 0;

		Connection connection = DBUtil.getDBConnection();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.delete);

		statement.setInt(1, id);

		n = statement.executeUpdate();

		return n;
	}

	public Optional<Employee> showEmployee(int id) throws ClassNotFoundException, SQLException {

		Connection connection = DBUtil.getDBConnection();

		Employee employee = null;

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.findOne);

		statement.setInt(1, id);

		ResultSet result = statement.executeQuery();

		if (result.next()) {

			employee = new Employee();

			employee.setEid(result.getInt("eid"));
			employee.setEname(result.getString("ename"));
			employee.setEsalary(result.getInt("esalary"));
			employee.setDno(result.getInt("dno"));
		}

		return Optional.ofNullable(employee);
	}

	public Optional<List<Employee>> showAllEmployees() throws ClassNotFoundException, SQLException {

		Connection connection = DBUtil.getDBConnection();

		List<Employee> employeeList = new ArrayList<>();

		PreparedStatement statement = connection.prepareStatement(ApplicationProperties.findAll);

		ResultSet result = statement.executeQuery();

		while (result.next()) {

			Employee employee = new Employee();

			employee.setEid(result.getInt("eid"));
			employee.setEname(result.getString("ename"));
			employee.setEsalary(result.getInt("esalary"));
			employee.setDno(result.getInt("dno"));

			employeeList.add(employee);
		}

		return employeeList.isEmpty() ? Optional.empty() : Optional.of(employeeList);
	}
}