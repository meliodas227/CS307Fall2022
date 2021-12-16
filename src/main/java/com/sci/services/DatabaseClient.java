package com.sci.services;

import com.sci.Locations;
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

    public void deleteEmployeeById(int id) throws SQLException {
        employeeService.deleteById(id);
    }

    public void insertEmployee(Employee emp) throws SQLException{
        employeeService.insert(emp);
    }
    public void updateByJobGrade(JobGrade jobGrade) throws SQLException{
        jobGradesService.updateByJobGrade(jobGrade);
    }
    public void deleteByGradeLevel(String GradeLevel) throws SQLException{
        jobGradesService.deleteByGradeLevel(GradeLevel);
    }
    public void insert (JobGrade jobGrade) throws SQLException{
        jobGradesService.insert(jobGrade);
    }
    public JobGrade getByGradeLevel(String gradeLevel) throws SQLException{
        return jobGradesService.getByGradeLevel(gradeLevel);
    }
    public void updateById(JobHistory jobHistory) throws SQLException{
        jobHistoryService.updateById(jobHistory);
    }
    public void deleteById(int Id) throws SQLException{
        jobHistoryService.deleteById(Id);
    }
    public void insert(JobHistory jobHistory) throws SQLException {
        jobHistoryService.insert(jobHistory);
    }
    public JobHistory getById(int id) throws SQLException{
        return jobHistoryService.getById(id);
    }
    public void updateById(Job job) throws SQLException{
        jobService.updateById(job);
    }
    public void deleteById(String JobId) throws SQLException{
        jobService.deleteById(JobId);
    }
    public void insert(Job job) throws SQLException{
        jobService.insert(job);
    }
    public Job getById(String jobId) throws SQLException{
        return jobService.getById(jobId);
    }
    public void updateById(Country country) throws SQLException{
        countriesService.updateById(country);
    }
    public void deleteCountryById(String countryId)throws SQLException{
        countriesService.deleteById(countryId);
    }
    public void insert(Country country) throws SQLException{
        countriesService.insert(country);
    }
    public Country getCountryById(String countryId) throws SQLException{
        return countriesService.getById(countryId);
    }
    public void updateById(Region region) throws SQLException{
        regionService.updateById(region);
    }
    public void deleteRegionById(int ID) throws SQLException{
        regionService.deleteById(ID);
    }
    public void insert(Region region) throws SQLException{
        regionService.insert(region);
    }
    public Region getRegionById(int ID) throws SQLException{
        return regionService.getById(ID);
    }
    public void updateById(Location location) throws SQLException{
        locationService.updateById(location);
    }
    public void deleteLocationById(int Id) throws SQLException{
        locationService.deleteById(Id);
    }
    public void insert(Location location) throws SQLException{
        locationService.insert(location);
    } public Location getlocationById(int Id) throws SQLException{
        return locationService.getById(Id);
    }
}
