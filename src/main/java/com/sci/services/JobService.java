package com.sci.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sci.models.Job;
import com.sci.utils.Constant;

public class JobService implements AutoCloseable{
    private final PreparedStatement selectJob;
    private final PreparedStatement selectJobById;
    private final PreparedStatement updateJobById;
    private final PreparedStatement deleteJobById;
    private final PreparedStatement insertJob;
    public JobService(Connection connection) throws SQLException{
        selectJob = connection.prepareStatement(Constant.SELECT_JOBS);
        selectJobById = connection.prepareStatement(Constant.SELECT_JOB_BY_ID);
        updateJobById = connection.prepareStatement(Constant.UPDATE_JOB_BY_ID);
        deleteJobById = connection.prepareStatement(Constant.DELETE_JOB_BY_ID);
        insertJob = connection.prepareStatement(Constant.INSERT_JOB);
    }
    @Override
    public void close() throws Exception {
        selectJob.close();            
    }
    public List<Job> getAll() {
        List<Job> res = new ArrayList<>();
    
        try {
    
          ResultSet resultSet = selectJob.executeQuery();
    
          while (resultSet.next()) {
    
            Job job = new Job();
            job.setJobId(resultSet.getString("job_id"));
            job.setJobTitle(resultSet.getString("job_title"));
            job.setMaxSalary(resultSet.getInt("max_salary"));
            job.setMinSalary(resultSet.getInt("min_salary"));
            res.add(job);
    
          }
    
        } catch (SQLException e) {
          System.err.println("DB error: " + e.getMessage());
        }
    
        return res;
      }
    
      public void updateById(Job job) throws SQLException{
        updateJobById.clearParameters();
        updateJobById.setString(1, job.getJobTitle());
        updateJobById.setInt(2, job.getMinSalary());
        updateJobById.setInt(3, job.getMaxSalary());
        updateJobById.setString(4, job.getJobId());
        updateJobById.executeQuery();
      } 
      public Job getById(String JobId) throws SQLException{
        Job job = null;
        try {
          selectJobById.clearParameters();
          selectJobById.setString(1, JobId);
          ResultSet resultSet = selectJobById.executeQuery();
          if(resultSet.next()){
            job = new Job();
            job.setJobId(JobId);
            job.setJobTitle(resultSet.getString("job_title"));
            job.setMaxSalary(resultSet.getInt("max_salary"));
            job.setMinSalary(resultSet.getInt("min_salary"));
          }
        } catch (Exception e) {
          System.err.println("DB error: "+e.getMessage());
        }
        return job;
      }
      public void deleteById(String JobId) throws SQLException{
        deleteJobById.clearParameters();
        deleteJobById.setString(1, JobId);
        deleteJobById.executeQuery();
      }
      public void insert(Job job) throws SQLException {
        insertJob.clearParameters();
        insertJob.setString(1, job.getJobId());
        insertJob.setInt(2, job.getMinSalary());
        insertJob.setInt(3, job.getMaxSalary());
        insertJob.setString(4, job.getJobTitle());
      }
}
