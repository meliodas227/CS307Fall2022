package com.sci.utils;

public interface Constant {

  String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
  String USERNAME = "system";
  String PASSWORD = "system";

  String SELECT_EMPLOYEES = "select * from hr.employees";
  String SELECT_DEPARTMENTS = "select * from hr.departments";
}
