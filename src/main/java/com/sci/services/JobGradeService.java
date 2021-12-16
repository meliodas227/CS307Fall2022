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
    private final PreparedStatement selectJobGradesByGradeLevel;
    private final PreparedStatement updateJobGradesByGradeLevel;
    private final PreparedStatement deleteJobGradeByGradeLevel;
    private final PreparedStatement insertJobGrade;
    public JobGradeService(Connection connection) throws SQLException {
        selectJobGrades = connection.prepareStatement(Constant.SELECT_JOB_GRADES);
        selectJobGradesByGradeLevel = connection.prepareStatement(Constant.SELECT_JOB_GRADES_BY_GRADE_LEVEL);
        updateJobGradesByGradeLevel = connection.prepareStatement(Constant.UPDATE_JOB_GRADE_BY_GRADE_LEVEL);
        deleteJobGradeByGradeLevel = connection.prepareStatement(Constant.DELETE_JOB_GRADE_BY_GRADE_LEVEL);
        insertJobGrade = connection.prepareStatement(Constant.INSERT_JOB_GRADE);

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

    public void updateByJobGrade(JobGrade jobGrade) throws SQLException {
      updateJobGradesByGradeLevel.clearParameters();
      updateJobGradesByGradeLevel.setInt(1, jobGrade.getLowestSalary());
      updateJobGradesByGradeLevel.setInt(2, jobGrade.getHighstSalary());
      updateJobGradesByGradeLevel.setString(3, jobGrade.getGradeLevel());
      updateJobGradesByGradeLevel.executeQuery();
    }
    public void deleteByGradeLevel(String gradeLevel) throws SQLException{
      deleteJobGradeByGradeLevel.clearParameters();
      deleteJobGradeByGradeLevel.setString(1, gradeLevel);
      deleteJobGradeByGradeLevel.executeQuery();
    }
    public void insert (JobGrade jobGrade) throws SQLException{
      insertJobGrade.clearParameters();
      insertJobGrade.setString(1, jobGrade.getGradeLevel());
      insertJobGrade.setInt(2, jobGrade.getLowestSalary());
      insertJobGrade.setInt(3, jobGrade.getHighstSalary());
      insertJobGrade.executeQuery();
    }
    public JobGrade getByGradeLevel(String gradeLevel){
        JobGrade jobGrade = null;
        try {
          selectJobGradesByGradeLevel.clearParameters();
          selectJobGradesByGradeLevel.setString(1, gradeLevel);
          ResultSet resultSet = selectJobGradesByGradeLevel.executeQuery();
          if(resultSet.next()){
            jobGrade = new JobGrade();
            jobGrade.setGradeLevel(resultSet.getString("grade_level"));
            jobGrade.setHighstSalary(resultSet.getInt("highest_sal"));
            jobGrade.setLowestSalary(resultSet.getInt("lowest_sal"));
          }
        } catch (Exception e) {
          System.err.println("DB error: " + e.getMessage());
        }
        return jobGrade;
    }
}
