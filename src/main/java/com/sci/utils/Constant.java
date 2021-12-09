package com.sci.utils;

public interface Constant {

  String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
  String USERNAME = "system";
  String PASSWORD = "system";

  String SELECT_EMPLOYEES = "select * from hr.employees";
  String SELECT_EMPLOYEES_BY_ID = "select * from hr.employees where department_id = ?";
  String INSERT_EMPLOYEE = "insert INTO HR.employees  VALUES ( ? , ? , ? , ?)";
  String UPDATE_EMPLOYEE_BY_ID ="update hr.employees set first_name =? , last_name =? ,email=? ,phone_number = ? , hire_date = ? , job_id = ? , salary = ? ,commession_pct = ? , manager_id = ? where department_id = ?";
  String DELETE_EMPLOYEE_BY_ID = "delete from HR.employees where department_id = ?";
  String SELECT_DEPARTMENTS = "select * from hr.departments";
  String SELECT_DEPARTMENT_BY_ID = "select * from hr.departments where department_id = ?";
  String INSERT_DEPARTMENT = "insert INTO HR.departments  VALUES ( ? , ? , ? , ?)";
  String DELETE_DEPARTMENT_BY_ID = "delete from HR.departments where department_id = ?" ;
  String UPDATE_DEPARTMENT_BY_ID = "update HR.departments set " + "department_name = ? , location_id = ? , manager_id = ? where department_id = ?";
  String SELECT_JOB_GRADES = "select * from hr.job_grades";
  String SELECT_LOCATIONS = "select * from hr.locations";
  String SELECT_COUNTRIES = "select * from hr.countries";
  String SELECT_JOBS = "select * from hr.jobs";
  String SELECT_JOB_HISTORY = "select * from hr.job_history";
  String SELECT_REGIONS = "select * from hr.regions";
}
