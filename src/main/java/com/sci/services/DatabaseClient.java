package com.sci.services;

import com.sci.models.Department;
import com.sci.models.Employee;
import com.sci.utils.Constant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DatabaseClient implements AutoCloseable {

  private final Connection connection;
  private final EmployeeService employeeService;
  private final DepartmentService departmentService;

  public DatabaseClient() throws SQLException {
    connection = DriverManager.getConnection(Constant.DB_URL, Constant.USERNAME, Constant.PASSWORD);
    employeeService = new EmployeeService(connection);
    departmentService = new DepartmentService(connection);

  }

  @Override
  public void close() throws SQLException {
    connection.close();
  }

  public List<Employee> getAllEmployees() {
    return employeeService.getAll();
  }

  public List<Department> getAllDepartments() {
    return departmentService.getAll();
  }

}
