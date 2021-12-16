package com.sci.models;


public class JobHistory {
    private int employeeId;
    private String startDate, endDate;
    private String jobId;
    private int departmentId;
    public int getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(int employeeId) {
        this.employeeId = employeeId;
    }
    public String getStartDate() {
        return startDate;
    }
    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }
    public String getEndDate() {
        return endDate;
    }
    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
    public String getJobId() {
        return jobId;
    }
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    public int getDepartmentId() {
        return departmentId;
    }
    public void setDepartmentId(int departmentId) {
        this.departmentId = departmentId;
    }
    @Override
    public String toString() {
        return "JobHistory [departmentId=" + departmentId + ", employeeId=" + employeeId + ", endDate=" + endDate
                + ", jobId=" + jobId + ", startDate=" + startDate + "]";
    }
    
}
