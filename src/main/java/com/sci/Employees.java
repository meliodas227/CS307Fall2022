package com.sci;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import com.sci.models.Employee;
import com.sci.services.DatabaseClient;

public class Employees {
    static Scanner in;
    static DatabaseClient db; 
    public static void main(String[] args) throws SQLException {
        in = new Scanner(System.in);
        db = new DatabaseClient();
        int operation ;
        System.out.println("enter 1:select_all , 2:select_by_id , 3:insert , 4:delete , 5:update , 0:exit");
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
            System.out.println("enter 1:select_all , 2:select_by_id , 3:insert , 4:delete , 5:update , 0:exit");
        }
    }

    private static void handleUpdateById() throws SQLException {
        System.out.print("enter id: ");
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
        System.out.print("enter department id: ");
        int departmentId = in.nextInt();
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
        emp.setDepartmentId(departmentId);
        db.updateById(emp);
    }

    private static void handleDeleteById() throws SQLException {
        System.out.print("enter department id: ");
        int id = in.nextInt();
        db.deleteEmployeeById(id);
    }

    private static void handleInsert() throws SQLException {
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
        System.out.println("enter department id: ");
        int departmentId= in.nextInt();
        Employee emp = new Employee();
        emp.setId(id);
        emp.setDepartmentId(departmentId);
        emp.setCommetionPct(commessionPct);
        emp.setEmail(email);
        emp.setFirstName(firstName);
        emp.setHireDate(hireDate);
        emp.setJobId(jobId);
        emp.setLastName(lastName);
        emp.setManagerId(managerId);
        emp.setPhoneNumber(phoneNumber);
        emp.setSalary(salary);
        db.insertEmployee(emp);
    }

    private static void handleSelectById() {
        System.out.print("enter employee id: ");
        int id = in.nextInt();
        System.out.println(db.getEmployeeById(id));
    }

    private static void handleSelectAll() {
        List<Employee> employeeList = db.getAllEmployees();
        for(Employee employee : employeeList){
            System.out.println(employee);
        }
    }
}
