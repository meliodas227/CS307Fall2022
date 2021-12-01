package com.sci.services;

import com.sci.models.*;

import com.sci.utils.Constant;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

public class DatabaseClient implements AutoCloseable {

  private final Connection connection;
  private final EmployeeService employeeService;
  private final DepartmentService departmentService;
  private final JobGradesService jobGradesService;
  private final LocationService locationService;
  private final CountriesService countriesService;
  private final JobHistoryService jobHistoryService;
  private final JobService jobService;
  private final RegionService regionService;

  public DatabaseClient() throws SQLException {
    connection = DriverManager.getConnection(Constant.DB_URL, Constant.USERNAME, Constant.PASSWORD);
    employeeService = new EmployeeService(connection);
    departmentService = new DepartmentService(connection);
    jobGradesService = new JobGradesService(connection);
    locationService = new LocationService(connection);
    countriesService = new CountriesService(connection);
    jobHistoryService = new JobHistoryService(connection);
    jobService = new JobService(connection);
    regionService = new RegionService(connection);
  }

  @Override
  public void close() throws SQLException {
    connection.close();
  }

  public List<Employee> getAllEmployees() {
    return employeeService.getAll();
  }

  public List<Department> getAllDepartments() {
    return departmentService.getAll();
  }
  public List<Jobgrades> getAllJobgrades() {
    return jobGradesService.getAll();
  }
  public List<Location> getAllLocations() {
    return locationService.getAll();
  }
  public List<Countries> getAllCountries(){
    return countriesService.getAll();
  }
  public List<JobHistory> getAllJobHistorys(){
    return jobHistoryService.getAll();
  }
  public List<Job> gettAllJobs(){
    return jobService.getAll();
  }
  public List<Region> getAllRegions(){
    return regionService.getAll();
  }

}
