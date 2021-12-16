package com.sci.utils;

public interface Constant {

  String DB_URL = "jdbc:oracle:thin:@localhost:1521:xe";
  String USERNAME = "system";
  String PASSWORD = "system";

  String SELECT_EMPLOYEES = "select * from hr.employees";
  String SELECT_EMPLOYEES_BY_ID = "select * from hr.employees where employee_id = ?";
  String INSERT_EMPLOYEE = "insert INTO HR.employees  VALUES ( ? , ? , ? , ? , ? , ? , ? , ? , ? , ? , ? )";
  String UPDATE_EMPLOYEE_BY_ID ="update hr.employees set first_name =? , last_name =? ,email=? ,phone_number = ? , hire_date = ? , job_id = ? , salary = ? ,commession_pct = ? , manager_id = ?,employee_id=? where department_id = ?";
  String DELETE_EMPLOYEE_BY_ID = "delete from HR.employees where department_id = ?";
  
  String SELECT_DEPARTMENTS = "select * from hr.departments";
  String SELECT_DEPARTMENT_BY_ID = "select * from hr.departments where department_id = ?";
  String INSERT_DEPARTMENT = "insert INTO HR.departments  VALUES ( ? , ? , ? , ?)";
  String DELETE_DEPARTMENT_BY_ID = "delete from HR.departments where department_id = ?" ;
  String UPDATE_DEPARTMENT_BY_ID = "update HR.departments set " + "department_name = ? , location_id = ? , manager_id = ? where department_id = ?";
  
  String SELECT_JOB_GRADES = "select * from hr.job_grades";
  String SELECT_JOB_GRADES_BY_GRADE_LEVEL = "select * from hr.job_grades where grade_level = ?";
  String INSERT_JOB_GRADE = "insert into hr.job_grades VALUES (?,?,?)";
  String DELETE_JOB_GRADE_BY_GRADE_LEVEL = "delete from Hr.job_grades where grade_level = ?";
  String UPDATE_JOB_GRADE_BY_GRADE_LEVEL = "update hr.job_grades set lowest_sal = ? , highest_sal = ? where grade_level = ?";  
  
  String SELECT_LOCATIONS = "select * from hr.locations";
  String SELECT_LOCATION_BY_ID = "SELECT * from hr.locations where location_id = ?";
  String INSERT_LOCATION = "insert into hr.locations values(? , ?,?,?,?,?)";
  String DELETE_LOCATION_BY_ID = "delete from hr.locations where location_id = ?";
  String UPDATE_LOCATION_BY_ID = "update hr.locations set street_address = ? , postal_code= ?, city=?, state_province=?,country_id=? where location_id=?"; 

  String SELECT_COUNTRIES = "select * from hr.countries";
  String SELECT_COUNTRY_BY_ID = "select * from hr.countries where country_id = ?";
  String INSERT_COUNTRY = "insert into hr.countries values(?,?,?)";
  String DELETE_COUNTRY_BY_ID = "delete from hr.countries where country_id = ?";
  String UPDATE_COUNTRY_BY_ID = "update hr.countries set country_name = ?, region_id = ? where country_id =?";

  String SELECT_JOBS = "select * from hr.jobs";
  String SELECT_JOB_BY_ID = "select * from hr.jobs where job_id=?";
  String INSERT_JOB = "insert into hr.jobs values(?,?,?,?)";
  String DELETE_JOB_BY_ID = "delete from hr.jobs where job_id=?";
  String UPDATE_JOB_BY_ID = "update hr.jobs set job_title=? , min_salary=?, max_salary=? where job_id=?";
  
  String SELECT_JOB_HISTORY = "select * from hr.job_history";
  String SELECT_JOB_HISTORY_BY_iD = "select * from hr.job_history where employee_id = ?";
  String INSERT_JOB_HISTORY = "insert into hr.job_history VALUES (? , ? , ? , ? , ?)";
  String DELETE_JOB_HISTORY_BY_ID = "delete from hr.job_history where employee_id = ?";
  String UPDATE_JOB_HISTORY_BY_ID = "update hr.job_history set start_date=?,end_date=?,job_id=?,department_id=? where empoyee_id=?";

  String SELECT_REGIONS = "select * from hr.regions";
  String SELECT_REGION_BY_ID = "select * from hr.regions where region_id=?";
  String INSERT_REGION = "insert into hr.regions values (?,?)";
  String DELETE_REGION_BY_ID = "delete from hr.regions where region_id = ?";
  String UPDATE_REGION_BY_ID = "update hr.regions set region_name =? where region_id =?";
}
