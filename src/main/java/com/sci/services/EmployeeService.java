package com.sci.services;

import com.sci.models.Employee;
import com.sci.utils.Constant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeService implements AutoCloseable {

  private final PreparedStatement selectEmployees;

  public EmployeeService(Connection connection) throws SQLException {
    selectEmployees = connection.prepareStatement(Constant.SELECT_EMPLOYEES);
  }

  @Override
  public void close() throws SQLException {
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
        employee.setCommetionPct(resultSet.getInt("commission_pct"));
        employee.setEmail(resultSet.getString("email"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setHireDate(resultSet.getString("hire_date"));
        employee.setJobId(resultSet.getString("job_id"));
        employee.setManagerId(resultSet.getInt("manager_id"));
        employee.setPhoneNumber(resultSet.getString("phone_number"));
        employee.setSalary(resultSet.getInt("salary"));

        res.add(employee);

      }

    } catch (SQLException e) {
      System.err.println("DB error: " + e.getMessage());
    }

    return res;
  }
}
