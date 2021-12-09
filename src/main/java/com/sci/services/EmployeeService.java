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
  private final PreparedStatement updateEmployeeById;


  public EmployeeService(Connection connection) throws SQLException {
    selectEmployees = connection.prepareStatement(Constant.SELECT_EMPLOYEES);
    updateEmployeeById = connection.prepareStatement(Constant.UPDATE_EMPLOYEE_BY_ID);
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
        employee.setId(resultSet.getInt("department_id"));
        employee.setCommetionPct(resultSet.getDouble("commission_pct"));
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
  public void updateById(Employee emp) throws SQLException{
    updateEmployeeById.clearParameters();
    updateEmployeeById.setString(1, emp.getFirstName());
    updateEmployeeById.setString(2, emp.getLastName());
    updateEmployeeById.setString(3, emp.getEmail());
    updateEmployeeById.setString(4, emp.getPhoneNumber());
    updateEmployeeById.setString(5, emp.getHireDate());
    updateEmployeeById.setString(6, emp.getJobId());
    updateEmployeeById.setInt(7, emp.getSalary());
    updateEmployeeById.setDouble(8, emp.getCommetionPct());
    updateEmployeeById.setInt(9, emp.getManagerId());
    updateEmployeeById.setInt(10, emp.getId());
    updateEmployeeById.executeQuery();
  }

public Employee getById(int id) {
  Employee emp = null;  
  
  return null;
}
}
