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
    public JobService(Connection connection) throws SQLException{
        selectJob = connection.prepareStatement(Constant.SELECT_JOBS);
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
    
}
