package com.sci;

import com.sci.models.*;

import com.sci.services.DatabaseClient;

import java.sql.SQLException;
import java.util.List;

public class App {

  public static void main(String[] args) throws SQLException {

    try (DatabaseClient databaseClient = new DatabaseClient()) {
      List<Employee> employeeList = databaseClient.getAllEmployees();
      List<Department> departmentList = databaseClient.getAllDepartments();
      List<JobGrade> jobgradeList = databaseClient.getAllJobgrades();
      List<Location> locationList = databaseClient.getAllLocations();
      List<Country> countryList = databaseClient.getAllCountries();
      List<Job> jobList = databaseClient.gettAllJobs();
      List<JobHistory> jobHistoryList = databaseClient.getAllJobHistorys();
      List<Region> regionList = databaseClient.getAllRegions();

      System.out.println("Number of employees: " + employeeList.size());
      for (Employee employee : employeeList) {
        System.out.println(employee);
      }

      System.out.println("***********************");

      System.out.println("Number of departments: " + departmentList.size());
      for (Department department : departmentList) {
        System.out.println(department);
      }
      System.out.println("***********************");

      System.out.println("Number of jobGrades: "+jobgradeList.size());
      for(JobGrade  jobgrades : jobgradeList){
        System.out.println(jobgrades);
      }
      System.out.println("***********************");

      System.out.println("Number of Locations: "+ locationList.size());
      for(Location locations : locationList){
        System.out.println(locations);
      }
      System.out.println("***********************");
      System.out.println("number of countries: "+countryList.size());
      for(Country country : countryList){
        System.out.println(country);
      }

      System.out.println("***********************");
      System.out.println("number of jobs: "+jobList.size());
      for(Job job : jobList){
        System.out.println(job);
      }
      System.out.println("***********************");
      System.out.println("number of jobHistory: "+jobHistoryList.size());
      for(JobHistory jobHistory : jobHistoryList){
        System.out.println(jobHistory);
      }
      System.out.println("***********************");
      System.out.println("number of region: "+regionList.size());

      for(Region region : regionList){
        System.out.println(region);
      }
    }
  }
}
