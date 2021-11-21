package com.sci;

import com.sci.models.Employee;
import com.sci.services.DatabaseClient;
import java.sql.SQLException;
import java.util.List;

public class App {

  public static void main(String[] args) throws SQLException {
    
    // comment

    DatabaseClient databaseClient = new DatabaseClient();

    List<Employee> employeeList = databaseClient.getAll();

    databaseClient.close();

    System.out.println("Number of employees: " + employeeList.size());
    for (Employee employee : employeeList) {
      System.out.println(employee);
    }
  }
}
