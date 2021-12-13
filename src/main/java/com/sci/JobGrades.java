package com.sci;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sci.models.JobGrade;
import com.sci.services.DatabaseClient;

public class JobGrades {
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
                    handleSelectByGradeLevel();
                    break;
                case 3 :
                    handleInsert();
                    break;
                case 4:
                    handleDeleteByGradeLevel();
                    break;
                case 5:
                    handleUpdateByGradeLevel();
                    break;
            }
            System.out.println("enter 1:select_all , 2:select_by_id , 3:insert , 4:delete , 5:update , 0:exit");
        }
    }
    private static void handleUpdateByGradeLevel() throws SQLException {
        System.out.print("enter grade level: ");
        String gradeLevel = input.next();
        System.out.print("enter highst salary : ");
        int highstSalary = input.nextInt();
        System.out.print("enter lowest salary: ");
        int lowestSalary = input.nextInt();
        JobGrade jobGrade = new JobGrade();
        jobGrade.setGradeLevel(gradeLevel);
        jobGrade.setHighstSalary(highstSalary);
        jobGrade.setLowestSalary(lowestSalary);
        db.updateByJobGrade(jobGrade);
    }
    private static void handleDeleteByGradeLevel() throws SQLException {
        System.out.print("enter grade level: ");
        String gradeLevel = input.next();
        db.deleteByGradeLevel(gradeLevel);
    }
    private static void handleInsert() throws SQLException {
        System.out.print("enter grade level: ");
        String gradeLevel = input.next();
        System.out.print("enter highest salary: ");
        int highestSalary = input.nextInt();
        System.out.print("enter lowest salary: ");
        int lowestSalary = input.nextInt();
        JobGrade jobGrade = new JobGrade();
        jobGrade.setGradeLevel(gradeLevel);
        jobGrade.setHighstSalary(highestSalary);
        jobGrade.setLowestSalary(lowestSalary);
        db.insert(jobGrade);
    }
    private static void handleSelectByGradeLevel() throws SQLException {
        System.out.print("enter grade level: ");
        String gradeLevel = input.next();
        System.out.println(db.getByGradeLevel(gradeLevel));
    }
    private static void handleSelectAll() {
        List<JobGrade> jobgradeList= db.getAllJobgrades();
        for(JobGrade jobGrade: jobgradeList){
            System.out.println(jobGrade);
        }
    }
}
