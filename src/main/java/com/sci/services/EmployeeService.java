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
  private final PreparedStatement selectEmployeeById;
  private final PreparedStatement deleteEmployeeById;
  private final PreparedStatement insertEmployee;


  public EmployeeService(Connection connection) throws SQLException {
    selectEmployees = connection.prepareStatement(Constant.SELECT_EMPLOYEES);
    updateEmployeeById = connection.prepareStatement(Constant.UPDATE_EMPLOYEE_BY_ID);
    selectEmployeeById = connection.prepareStatement(Constant.SELECT_EMPLOYEES_BY_ID);
    deleteEmployeeById = connection.prepareStatement(Constant.DELETE_EMPLOYEE_BY_ID);
    insertEmployee = connection.prepareStatement(Constant.INSERT_EMPLOYEE);
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
    updateEmployeeById.setInt(11, emp.getDepartmentId());
    updateEmployeeById.executeQuery();
  }

public Employee getById(int id) {
  Employee employee = null;  
  try {

    selectEmployeeById.clearParameters();
    selectEmployeeById.setInt(1, id);

    ResultSet resultSet = selectEmployeeById.executeQuery();

    if (resultSet.next()) {

        employee = new Employee();

        employee.setId(resultSet.getInt("employee_id"));
        employee.setLastName(resultSet.getString("last_name"));
        employee.setDepartmentId(resultSet.getInt("department_id"));
        employee.setCommetionPct(resultSet.getDouble("commission_pct"));
        employee.setEmail(resultSet.getString("email"));
        employee.setFirstName(resultSet.getString("first_name"));
        employee.setHireDate(resultSet.getString("hire_date"));
        employee.setJobId(resultSet.getString("job_id"));
        employee.setManagerId(resultSet.getInt("manager_id"));
        employee.setPhoneNumber(resultSet.getString("phone_number"));
        employee.setSalary(resultSet.getInt("salary"));
    }

  } catch (SQLException e) {
      System.err.println("DB error: " + e.getMessage());
  }


  return employee;
  }

  public void deleteById(int id) throws SQLException {
    deleteEmployeeById.clearParameters();
    deleteEmployeeById.setInt(1, id);
    deleteEmployeeById.executeQuery();
  }

  public void insert(Employee emp) throws SQLException{
    insertEmployee.clearParameters();
    insertEmployee.setInt(1, emp.getId());
    insertEmployee.setString(2, emp.getFirstName());
    insertEmployee.setString(3, emp.getLastName());
    insertEmployee.setString(4, emp.getEmail());
    insertEmployee.setString(5, emp.getPhoneNumber());
    insertEmployee.setString(6, emp.getHireDate());
    insertEmployee.setString(7, emp.getJobId());
    insertEmployee.setInt(8, emp.getSalary());
    insertEmployee.setDouble(9, emp.getCommetionPct());
    insertEmployee.setInt(10, emp.getManagerId());
    insertEmployee.setInt(11, emp.getDepartmentId());
    insertEmployee.executeQuery();
  }
}
