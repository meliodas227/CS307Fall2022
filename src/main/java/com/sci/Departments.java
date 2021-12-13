package com.sci;

import com.sci.models.Department;
import com.sci.services.DatabaseClient;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Departments {
    static Scanner input;
    static DatabaseClient db;
    public static void main(String[] args) throws SQLException {
        input = new Scanner(System.in);
        db = new DatabaseClient();
//        0 = exit
//        1 = select all
//        2 = select by id and get values
//        3 = insert and get values
//        4 = delete by Id and get values
//        5 = update by id and get values
        int operation ;
        System.out.println("enter 1:select_all , 2:select_by_id , 3:insert , 4:delete , 5:update , 0:exit");
        while((operation = input.nextInt()) != 0){
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
        System.out.print("enter department id: ");
        int departmentId = input.nextInt();
        System.out.print("enter department name: ");
        String departmentName = input.next();
        System.out.print("enter manager id: ");
        int managerId = input.nextInt();
        System.out.print("enter location id: ");
        int locationId = input.nextInt();
        Department department = new Department();
        department.setDepartmentId(departmentId);
        department.setDepartmentName(departmentName);
        department.setManagerId(managerId);
        department.setLocationId(locationId);
        db.updateById(department);
    }

    private static void handleDeleteById() throws SQLException {
        System.out.print("enter department id: ");
        int id = input.nextInt();
        db.deleteDepartmentById(id);
    }

    private static void handleInsert() throws SQLException {
        System.out.print("enter department id: ");
        int departmentId = input.nextInt();
        System.out.print("enter department name: ");
        String departmentName = input.next();
        System.out.print("enter manager id: ");
        int managerId = input.nextInt();
        System.out.print("enter location id: ");
        int locationId = input.nextInt();
        Department department = new Department();
        department.setDepartmentId(departmentId);
        department.setDepartmentName(departmentName);
        department.setManagerId(managerId);
        department.setLocationId(locationId);
        db.insertDepartment(department);

    }

    private static void handleSelectById() {
        System.out.print("enter department id: ");
        int id = input.nextInt();
        System.out.println(db.getDepartmentById(id));
    }

    private static void handleSelectAll() {
        List<Department> departmentsList = db.getAllDepartments();
        for(Department department : departmentsList){
            System.out.println(department);
        }
    }
}
