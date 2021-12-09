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
    public JobHistoryService(Connection connection) throws SQLException{
        selectJobHistory = connection.prepareStatement(Constant.SELECT_JOB_HISTORY);
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
}
