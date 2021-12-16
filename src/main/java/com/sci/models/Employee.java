package com.sci.models;

public class Employee {

  private int id;
  private int departmentId;
  private String firstName;
  private String lastName;
  private int managerId;
  private String email;
  private String phoneNumber;
  private String hireDate;
  private String jobId;
  private int salary;
  private double commetionPct;

  public int getDepartmentId() {
    return departmentId;
  }

  public void setDepartmentId(int departmentId) {
    this.departmentId = departmentId;
  }

  public String getFirstName() {
    return firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public int getManagerId() {
    return managerId;
  }

  public void setManagerId(int managerId) {
    this.managerId = managerId;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getHireDate() {
    return hireDate;
  }

  public void setHireDate(String hireDate) {
    this.hireDate = hireDate;
  }

  public String getJobId() {
    return jobId;
  }

  public void setJobId(String jobId) {
    this.jobId = jobId;
  }

  public int getSalary() {
    return salary;
  }

  public void setSalary(int salary) {
    this.salary = salary;
  }

  public double getCommetionPct() {
    return commetionPct;
  }

  public void setCommetionPct(double d) {
    this.commetionPct = d;
  }

  

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getLastName() {
    return lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  @Override
  public String toString() {
    return "Employee [commetionPct=" + commetionPct + ", departmentId=" + departmentId + ", email=" + email
        + ", firstName=" + firstName + ", hireDate=" + hireDate + ", id=" + id + ", jobId=" + jobId + ", lastName="
        + lastName + ", managerId=" + managerId + ", phoneNumber=" + phoneNumber + ", salary=" + salary + "]";
  }

  
}
