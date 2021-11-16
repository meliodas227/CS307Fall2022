package com.sci.services;

import com.sci.models.Employee;
import com.sci.utils.Constant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DatabaseClient {

  private Connection connection;
  private PreparedStatement selectEmployees;

  public DatabaseClient() throws SQLException {
    connection = DriverManager.getConnection(Constant.DB_URL, Constant.USERNAME, Constant.PASSWORD);

    selectEmployees = connection.prepareStatement(Constant.SELECT_EMPLOYEES);
  }

  public void close() throws SQLException {
    connection.close();
    selectEmployees.close();
  }

  public List<Employee> getAll() {
    List<Employee> res = new ArrayList<>();

    try {

      ResultSet resultSet = selectEmployees.executeQuery();

      while (resultSet.next()) {

        Employee employee = new Employee();

        employee.setId(resultSet.getInt("employee_id"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setDepartmentId(resultSet.getInt("department_id"));

        res.add(employee);

      }

    } catch (SQLException e) {
      System.err.println("DB error: " + e.getMessage());
    }

    return res;
  }

}
