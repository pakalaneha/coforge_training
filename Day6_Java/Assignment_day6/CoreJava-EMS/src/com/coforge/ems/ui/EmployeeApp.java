package com.coforge.ems.ui;

import java.util.Scanner;

import com.coforge.ems.controller.EmployeeController;
import com.coforge.ems.model.Employee;

public class EmployeeApp {

    private static EmployeeController controller = new EmployeeController();

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String confirmation = "";
        String result = "";

        do {

            System.out.println("1. Create 2. Update 3. Delete 4. Find 5. Find All 6. Quit");
            System.out.println("Enter your choice");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:

                    System.out.println("Enter employee ID, Name, Salary, Department No.");

                    Employee employee = new Employee(
                            sc.nextInt(),
                            sc.next(),
                            sc.nextInt(),
                            sc.nextInt());

                    result = controller.createEmployee(employee);
                    System.out.println(result);
                    break;

                case 2:

                    System.out.println("What do you want to update?");
                    System.out.println("1. Employee ID 2. Employee Name 3. Employee Salary 4. Employee Department");

                    int ch = sc.nextInt();

                    System.out.println("Which employee details to be updated [Give Employee ID]");
                    int id = sc.nextInt();

                    switch (ch) {

                        case 1:

                            System.out.print("Enter new Employee ID: ");
                            int newId = sc.nextInt();
                            result = controller.updateEmployeeId(id, newId);
                            break;

                        case 2:

                            System.out.print("Enter new Employee Name: ");
                            sc.nextLine(); // consume newline
                            String name = sc.nextLine();
                            result = controller.updateEmployeeName(id, name);
                            break;

                        case 3:

                            System.out.print("Enter new Salary: ");
                            int salary = sc.nextInt();
                            result = controller.updateEmployeeSalary(id, salary);
                            break;

                        case 4:

                            System.out.print("Enter new Department: ");
                            sc.nextLine();
                            int dept = sc.nextInt();
                            result = controller.updateEmployeeDepartment(id, dept);
                            break;

                        default:

                            System.out.println("Invalid choice");
                    }

                    System.out.println(result);
                    break;

                case 3:

                    System.out.println("Which employee is to be deleted? [Give an employee ID]");

                    int id1 = sc.nextInt();

                    result = controller.deleteEmployee(id1);
                    System.out.println(result);
                    break;

                case 4:

                    System.out.println("Which employee details are required? [Give an employee ID]");

                    int id2 = sc.nextInt();

                    result = controller.showEmployee(id2);
                    System.out.println(result);
                    break;

                case 5:

                    System.out.println("All Employee Details");
                    System.out.println();

                    result = controller.showAllEmployees();
                    System.out.println(result);
                    break;

                case 6:

                    System.exit(0);
                    break;

                default:

                    System.out.println("Invalid choice");
                    break;
            }

            System.out.println("Do you want to continue [Yes | No]");
            confirmation = sc.next();

        } while (confirmation.equalsIgnoreCase("yes"));

        sc.close();
    }
}