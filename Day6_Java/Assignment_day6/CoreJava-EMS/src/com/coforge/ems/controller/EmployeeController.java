package com.coforge.ems.controller;

import com.coforge.ems.model.Employee;
import com.coforge.ems.service.EmployeeService;
import com.coforge.ems.util.ApplicationProperties;

public class EmployeeController {

    private EmployeeService service = new EmployeeService();

    public String createEmployee(Employee employee) {

        String result = "";

        try {
            int n = service.createEmployee(employee);

            if (n == 1) {
                result = ApplicationProperties.insertSuccess;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	e.printStackTrace();
            result = ApplicationProperties.DBfail;
        }

        return result;
    }

    public String updateEmployeeId(int id, int newId) {

        String result = "";

        try {
            int n = service.updateEmployeeId(id, newId);

            if (n == 1) {
                result = ApplicationProperties.updateSuccess;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	e.printStackTrace();
            result = ApplicationProperties.DBfail;
        }

        return result;
    }

    public String updateEmployeeName(int id, String newName) {

        String result = "";

        try {
            int n = service.updateEmployeeName(id, newName);

            if (n == 1) {
                result = ApplicationProperties.updateSuccess;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	e.printStackTrace();
            result = ApplicationProperties.DBfail;
        }

        return result;
    }

    public String updateEmployeeSalary(int id, int newSalary) {

        String result = "";

        try {
            int n = service.updateEmployeeSalary(id, newSalary);

            if (n == 1) {
                result = ApplicationProperties.updateSuccess;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	e.printStackTrace();
            result = ApplicationProperties.DBfail;
        }

        return result;
    }

    public String updateEmployeeDepartment(int id, int newDept) {

        String result = "";

        try {
            int n = service.updateEmployeeDepartment(id, newDept);

            if (n == 1) {
                result = ApplicationProperties.updateSuccess;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	e.printStackTrace();
            result = ApplicationProperties.DBfail;
        }

        return result;
    }

    public String deleteEmployee(int id) {

        String result = "";

        try {
            int n = service.deleteEmployee(id);

            if (n == 1) {
                result = ApplicationProperties.deleteSuccess;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	e.printStackTrace();
            result = ApplicationProperties.DBfail;
        }

        return result;
    }

    public String showEmployee(int id) {

        String result = "";

        try {
            result = service.showEmployee(id).toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	e.printStackTrace();
            result = ApplicationProperties.DBfail;
        }

        return result;
    }

    public String showAllEmployees() {

        String result = "";

        try {
            result = service.showAllEmployees().toString();
        } catch (Exception e) {
            // TODO Auto-generated catch block
        	e.printStackTrace();
            result = ApplicationProperties.DBfail;
        }

        return result;
    }
}