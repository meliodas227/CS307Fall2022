package com.sci.models;

public class Job {
    private String jobId;
    private String jobTitle;
    private int minSalary, maxSalary;
    public String getJobId() {
        return jobId;
    }
    public void setJobId(String jobId) {
        this.jobId = jobId;
    }
    public String getJobTitle() {
        return jobTitle;
    }
    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }
    public int getMinSalary() {
        return minSalary;
    }
    public void setMinSalary(int minSalary) {
        this.minSalary = minSalary;
    }
    public int getMaxSalary() {
        return maxSalary;
    }
    public void setMaxSalary(int maxSalary) {
        this.maxSalary = maxSalary;
    }
    @Override
    public String toString() {
        return "Job [jobId=" + jobId + ", jobTitle=" + jobTitle + ", maxSalary=" + maxSalary + ", minSalary="
                + minSalary + "]";
    }
    
}
