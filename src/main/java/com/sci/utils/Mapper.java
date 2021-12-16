package com.sci.utils;

import com.sci.models.Department;

import java.sql.ResultSet;
import java.sql.SQLException;

public class Mapper {
    public static Department resultSetToDepartment(ResultSet resultSet) throws SQLException {
        Department department = new Department();
        department.setDepartmentId(resultSet.getInt("department_id"));
        department.setDepartmentName(resultSet.getString("department_name"));
        department.setLocationId(resultSet.getInt("location_id"));
        department.setManagerId(resultSet.getInt("manager_id"));
        return department;
    }
}
