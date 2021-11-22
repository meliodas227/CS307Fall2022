package com.sci;

import com.sci.models.Department;
import com.sci.models.Employee;
import com.sci.services.DatabaseClient;
import java.sql.SQLException;
import java.util.List;

public class App {

  public static void main(String[] args) throws SQLException {

    try (DatabaseClient databaseClient = new DatabaseClient()) {
      List<Employee> employeeList = databaseClient.getAllEmployees();
      List<Department> departmentList = databaseClient.getAllDepartments();

      System.out.println("Number of employees: " + employeeList.size());
      for (Employee employee : employeeList) {
        System.out.println(employee);
      }

      System.out.println("***********************");

      System.out.println("Number of departments: " + departmentList.size());
      for (Department department : departmentList) {
        System.out.println(department);
      }
    }
  }
}
