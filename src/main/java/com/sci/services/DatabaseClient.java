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
    private final JobGradeService jobGradesService;
    private final LocationService locationService;
    private final CountriesService countriesService;
    private final JobHistoryService jobHistoryService;
    private final JobService jobService;
    private final RegionService regionService;

    public DatabaseClient() throws SQLException {
        connection = DriverManager.getConnection(Constant.DB_URL, Constant.USERNAME, Constant.PASSWORD);
        employeeService = new EmployeeService(connection);
        departmentService = new DepartmentService(connection);
        jobGradesService = new JobGradeService(connection);
        locationService = new LocationService(connection);
        countriesService = new CountriesService(connection);
        jobHistoryService = new JobHistoryService(connection);
        jobService = new JobService(connection);
        regionService = new RegionService(connection);
    }

    @Override
    public void close() throws SQLException {
        connection.close();
        employeeService.close();
        departmentService.close();
    }

    public List<Employee> getAllEmployees() {
        return employeeService.getAll();
    }

    public List<Department> getAllDepartments() {
        return departmentService.getAll();
    }
    public List<JobGrade> getAllJobgrades() {
        return jobGradesService.getAll();
    }

    public List<Location> getAllLocations() {
        return locationService.getAll();
    }
    public List<Country> getAllCountries(){
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
    
    //by id
    public Department getDepartmentById(int id) {
        return departmentService.getById(id);
    }

    public void insertDepartment(Department department) throws SQLException {
      departmentService.insert(department);
    }

    public void deleteDepartmentById(int id) throws SQLException {
        departmentService.deleteById(id);
    }

    public void updateById(Department department) throws SQLException {
        departmentService.updateById(department);
    }

    public void updateById(Employee emp) throws SQLException {
        employeeService.updateById(emp);
    }
    public Employee getEmployeeById(int id){
        return employeeService.getById(id);
    }
}
