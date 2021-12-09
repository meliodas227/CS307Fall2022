package com.sci;

import java.sql.SQLException;
import java.util.Scanner;

import javax.print.event.PrintEvent;

import com.sci.models.Employee;
import com.sci.services.DatabaseClient;

public class Employees {
    static Scanner in;
    static DatabaseClient db; 
    public static void main(String[] args) throws SQLException {
        in = new Scanner(System.in);
        db = new DatabaseClient();
        int operation ;
        while((operation = in.nextInt()) != 0){
            switch (operation){
                case 1:
                    handleSelectAll();
                    break;
                case 2 :
                    handleSelectById();
                    break;
                case 3 :
                    handleInsert();
                    break;
                case 4:
                    handleDeleteById();
                    break;
                case 5:
                    handleUpdateById();
                    break;
            }
        }
    }

    private static void handleUpdateById() throws SQLException {
        System.out.print("enter department id: ");
        int id = in.nextInt();
        System.out.print("enter first name: ");
        String firstName = in.next();
        System.out.print("enter last name: ");
        String lastName = in.next();
        System.out.print("enter manager id: ");
        int managerId = in.nextInt();
        System.out.print("enter salary: ");
        int salary = in.nextInt();
        System.out.print("enter email: ");
        String email = in.next();
        System.out.print("enter phone number: ");
        String phoneNumber = in.next();
        System.out.print("enter hire date: ");
        String hireDate = in.next();
        System.out.print("enter job id: ");
        String jobId = in.next();
        System.out.print("enter job id: ");
        double commessionPct = in.nextDouble();
        Employee emp = new Employee();
        emp.setId(id);
        emp.setCommetionPct(commessionPct);
        emp.setEmail(email);
        emp.setFirstName(firstName);
        emp.setHireDate(hireDate);
        emp.setJobId(jobId);
        emp.setLastName(lastName);
        emp.setManagerId(managerId);
        emp.setPhoneNumber(phoneNumber);
        emp.setSalary(salary);
        db.updateById(emp);
    }

    private static void handleDeleteById() {
    }

    private static void handleInsert() {
    }

    private static void handleSelectById() {
    }

    private static void handleSelectAll() {
    }
}
