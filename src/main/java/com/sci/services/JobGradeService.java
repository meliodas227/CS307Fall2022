package com.sci.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sci.models.JobGrade;
import com.sci.utils.Constant;

public class JobGradeService implements AutoCloseable{
    private final PreparedStatement selectJobGrades;

    public JobGradeService(Connection connection) throws SQLException {
        selectJobGrades = connection.prepareStatement(Constant.SELECT_JOB_GRADES);
    }
  
    @Override
    public void close() throws SQLException {
      selectJobGrades.close();
    }
    public List<JobGrade> getAll() {
        List<JobGrade> res = new ArrayList<>();
    
        try {
    
          ResultSet resultSet = selectJobGrades.executeQuery();
    
          while (resultSet.next()) {
    
            JobGrade jobGrade = new JobGrade();
    
            jobGrade.setGradeLevel(resultSet.getString("grade_level"));
            jobGrade.setHighstSalary(resultSet.getInt("highest_sal"));
            jobGrade.setLowestSalary(resultSet.getInt("lowest_sal"));
    
            res.add(jobGrade);
    
          }
    
        } catch (SQLException e) {
          System.err.println("DB error: " + e.getMessage());
        }
    
        return res;
      }
    
}
