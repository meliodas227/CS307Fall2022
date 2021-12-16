package com.sci;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sci.models.Job;
import com.sci.services.DatabaseClient;

public class Jobs {
    static Scanner input;
    static DatabaseClient db;
    public static void main(String[] args) throws SQLException {
        input= new Scanner(System.in);
        db= new DatabaseClient();
        int operation;
        System.out.println("enter 1:select_all , 2:select_by_id , 3:insert , 4:delete , 5:update , 0:exit");
        while((operation = input.nextInt()) != 0){
            switch (operation){
                case 1:
                    handleSelectAll();
                    break;
                case 2 :
                    handleSelectByJobId();
                    break;
                case 3 :
                    handleInsertJob();
                    break;
                case 4:
                    handleDeleteByJobId();
                    break;
                case 5:
                    handleUpdateByJobId();
                    break;
            }
        System.out.println("enter 1:select_all , 2:select_by_id , 3:insert , 4:delete , 5:update , 0:exit");
        }
    }
    private static void handleUpdateByJobId() throws SQLException {
        System.out.print("enter job id: ");
        String jobID = input.next();
        System.out.print("enter max salary: ");
        int maxSalary = input.nextInt();
        System.out.print("enter min salary: ");
        int minSalary = input.nextInt();
        System.out.print("enter job title: ");
        String jobTitle = input.next();
        Job job = new Job();
        job.setJobId(jobID);
        job.setJobTitle(jobTitle);
        job.setMaxSalary(maxSalary);
        job.setMinSalary(minSalary);
        db.updateById(job);  
    }
    private static void handleDeleteByJobId() throws SQLException {
        System.out.print("enter job id: ");
        String jobId = input.next();
        db.deleteById(jobId);
    }
    private static void handleSelectByJobId() throws SQLException{
        System.out.print("enter job id: ");
        String jobId = input.next();
        System.out.println(db.getById(jobId));
    }
    private static void handleInsertJob() throws SQLException{
        System.out.print("enter job id: ");
        String jobID = input.next();
        System.out.print("enter max salary: ");
        int maxSalary = input.nextInt();
        System.out.print("enter min salary: ");
        int minSalary = input.nextInt();
        System.out.print("enter job title: ");
        String jobTitle = input.next();
        Job job = new Job();
        job.setJobId(jobID);
        job.setJobTitle(jobTitle);
        job.setMaxSalary(maxSalary);
        job.setMinSalary(minSalary);
        db.insert(job);  
    }
    private static void handleSelectAll() throws SQLException{
        List<Job> jobList = db.gettAllJobs();
        for(Job job : jobList){
            System.out.println(job);
        }
    }
}
