package com.sci.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sci.models.JobHistory;
import com.sci.utils.Constant;

public class JobHistoryService implements AutoCloseable{
    public final PreparedStatement selectJobHistory;
    public final PreparedStatement selectJobHistoryById;
    public final PreparedStatement UpdateJobHistoryById;
    public final PreparedStatement deleteJobHistoryById;
    public final PreparedStatement insertJobHistory;
    public JobHistoryService(Connection connection) throws SQLException{
        selectJobHistory = connection.prepareStatement(Constant.SELECT_JOB_HISTORY);
        selectJobHistoryById = connection.prepareStatement(Constant.SELECT_JOB_HISTORY_BY_iD);
        UpdateJobHistoryById = connection.prepareStatement(Constant.UPDATE_JOB_HISTORY_BY_ID);
        deleteJobHistoryById = connection.prepareStatement(Constant.DELETE_JOB_HISTORY_BY_ID);
        insertJobHistory = connection.prepareStatement(Constant.INSERT_JOB_HISTORY);
    }
    @Override
    public void close() throws Exception {
        selectJobHistory.close();        
    }
    public List<JobHistory> getAll() {
        List<JobHistory> res = new ArrayList<>();
    
        try {
    
          ResultSet resultSet = selectJobHistory.executeQuery();
    
          while (resultSet.next()) {
    
            JobHistory jobHistory = new JobHistory();
            jobHistory.setJobId(resultSet.getString("job_id"));
            jobHistory.setDepartmentId(resultSet.getInt("department_id"));
            jobHistory.setEmployeeId(resultSet.getInt("employee_id"));
            jobHistory.setStartDate(resultSet.getString("start_date"));
            jobHistory.setEndDate(resultSet.getString("end_date"));
            res.add(jobHistory);
    
          }
    
        } catch (SQLException e) {
          System.err.println("DB error: " + e.getMessage());
        }
    
        return res;
      }

      public void updateById(JobHistory jobHistory) throws SQLException{
          UpdateJobHistoryById.clearParameters();
          UpdateJobHistoryById.setString(1, jobHistory.getStartDate());
          UpdateJobHistoryById.setString(2, jobHistory.getEndDate());
          UpdateJobHistoryById.setString(3, jobHistory.getJobId());
          UpdateJobHistoryById.setInt(4, jobHistory.getDepartmentId());
          UpdateJobHistoryById.setInt(5, jobHistory.getEmployeeId());
          UpdateJobHistoryById.executeQuery();
      }

      public void deleteById(int id) throws SQLException {
        deleteJobHistoryById.clearParameters();
        deleteJobHistoryById.setInt(1, id);
        deleteJobHistoryById.executeQuery();
      } 

      public void insert(JobHistory jobHistory) throws SQLException{
        insertJobHistory.clearParameters();
        insertJobHistory.setInt(1, jobHistory.getEmployeeId());
        insertJobHistory.setString(2, jobHistory.getStartDate());
        insertJobHistory.setString(3, jobHistory.getEndDate());
        insertJobHistory.setString(4, jobHistory.getJobId());
        insertJobHistory.setInt(5, jobHistory.getDepartmentId());
        insertJobHistory.executeQuery();
      }

      public JobHistory getById(int id) throws SQLException{
        JobHistory jobHistory = null;
        try {
          selectJobHistoryById.clearParameters();
          selectJobHistoryById.setInt(1, id);
          ResultSet resultSet = selectJobHistoryById.executeQuery();
          if(resultSet.next()){
            jobHistory = new JobHistory();
            jobHistory.setDepartmentId(resultSet.getInt("department_id"));
            jobHistory.setEmployeeId(resultSet.getInt("employee_id"));
            jobHistory.setEndDate(resultSet.getString("end_date"));
            jobHistory.setJobId(resultSet.getString("job_id"));
            jobHistory.setStartDate(resultSet.getString("start_date"));
          }
        } catch (Exception e) {
          System.err.println("DB error: " + e.getMessage());
        }
        return jobHistory;
      }
}
