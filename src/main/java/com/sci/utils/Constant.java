package com.sci.utils;

public interface Constant {

  String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
  String USERNAME = "system";
  String PASSWORD = "system";

  String SELECT_EMPLOYEES = "select * from hr.employees";
  String SELECT_DEPARTMENTS = "select * from hr.departments";
  String SELECT_DEPARTMENT_BY_ID = "select * from hr.departments where department_id = ?";
  String INSERT_DEPARTMENT = "insert INTO HR.departments  VALUES ( ? , ? , ? , ?)";
  String DELETE_DEPARTMENT_BY_ID = "delete from HR.departments where department_id = ?" ;
  String UPDATE_DEPARTMENT_BY_ID = "update HR.departments set " +
                                    "department_name = ? , location_id = ? , manager_id = ? where department_id = ?";
}
