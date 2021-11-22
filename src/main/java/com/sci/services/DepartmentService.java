package com.sci.services;

import com.sci.models.Department;
import com.sci.utils.Constant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DepartmentService implements AutoCloseable {

  private final PreparedStatement selectDepartments;

  public DepartmentService(Connection connection) throws SQLException {
    selectDepartments = connection.prepareStatement(Constant.SELECT_DEPARTMENTS);
  }

  @Override
  public void close() throws SQLException {
    selectDepartments.close();
    ;
  }

  public List<Department> getAll() {
    List<Department> res = new ArrayList<>();

    try {

      ResultSet resultSet = selectDepartments.executeQuery();

      while (resultSet.next()) {

        Department department = new Department();

        department.setDepartmentId(resultSet.getInt("department_id"));
        department.setDepartmentName(resultSet.getString("department_name"));
        department.setLocationId(resultSet.getInt("location_id"));
        department.setManagerId(resultSet.getInt("manager_id"));

        res.add(department);

      }

    } catch (SQLException e) {
      System.err.println("DB error: " + e.getMessage());
    }

    return res;
  }
}
