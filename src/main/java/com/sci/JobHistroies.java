package com.sci;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sci.models.JobHistory;
import com.sci.services.DatabaseClient;

public class JobHistroies {
    static Scanner input;
    static DatabaseClient db;
    public static void main(String[] args) throws SQLException {
        input=new Scanner(System.in);
        db = new DatabaseClient();
        int operation;
        System.out.println("enter 1:select_all , 2:select_by_id , 3:insert , 4:delete , 5:update , 0:exit");
        while((operation = input.nextInt()) != 0){
            switch (operation){
                case 1:
                    handleSelectAll();
                    break;
                case 2 :
                    handleSelectByDepartmentId();
                    break;
                case 3 :
                    handleInsert();
                    break;
                case 4:
                    handleDeleteByDepartmentId();
                    break;
                case 5:
                    handleUpdateByDepartmentId();
                    break;
            }
        System.out.println("enter 1:select_all , 2:select_by_id , 3:insert , 4:delete , 5:update , 0:exit");
        }
    }
    private static void handleUpdateByDepartmentId() throws SQLException {
        System.out.print("enter start date: ");
        String startDate = input.next();
        System.out.print("enter end date: ");
        String endDate = input.next();
        System.out.print("enter job id: ");
        String jobId = input.next();
        System.out.print("enter department id : ");
        int departmentId = input.nextInt();
        System.out.print("enter ID: ");
        int Id = input.nextInt();
        JobHistory jobHistory = new JobHistory();
        jobHistory.setDepartmentId(departmentId);
        jobHistory.setEmployeeId(Id);
        jobHistory.setEndDate(endDate);
        jobHistory.setJobId(jobId);
        jobHistory.setStartDate(startDate);
        db.updateById(jobHistory);
    }
    private static void handleDeleteByDepartmentId() throws SQLException {
        System.out.print("enter Id: ");
        int id = input.nextInt();
        db.deleteById(id);
    }
    private static void handleInsert() throws SQLException {
        System.out.print("enter start date: ");
        String startDate = input.next();
        System.out.print("enter end date: ");
        String endDate = input.next();
        System.out.print("enter job id: ");
        String jobId = input.next();
        System.out.print("enter department id : ");
        int departmentId = input.nextInt();
        System.out.print("enter ID: ");
        int Id = input.nextInt();
        JobHistory jobHistory = new JobHistory();
        jobHistory.setDepartmentId(departmentId);
        jobHistory.setEmployeeId(Id);
        jobHistory.setEndDate(endDate);
        jobHistory.setJobId(jobId);
        jobHistory.setStartDate(startDate);
        db.insert(jobHistory);
    }
    private static void handleSelectByDepartmentId() throws SQLException {
        System.out.print("enter Id: ");
        int Id = input.nextInt();
        System.out.println(db.getById(Id));
    }
    private static void handleSelectAll() {
        List<JobHistory> jobHistoryList = db.getAllJobHistorys();
        for (JobHistory jobHistory : jobHistoryList){
            System.out.println(jobHistory);
        }
    }
}
