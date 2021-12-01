package com.sci.utils;

public interface Constant {

  String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
  String USERNAME = "system";
  String PASSWORD = "system";

  String SELECT_EMPLOYEES = "select * from hr.employees";
  String SELECT_DEPARTMENTS = "select * from hr.departments";
  String SELECT_JOB_GRADES = "select * from hr.job_grades";
  String SELECT_LOCATIONS = "select * from hr.locations";
  String SELECT_COUNTRIES = "select * from hr.countries";
  String SELECT_JOBS = "select * from hr.jobs";
  String SELECT_JOB_HISTORY = "select * from hr.job_history";
  String SELECT_REGIONS = "select * from hr.regions";
}
