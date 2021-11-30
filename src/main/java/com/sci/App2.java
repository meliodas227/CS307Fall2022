package com.sci;

import com.sci.models.Department;
import com.sci.services.DatabaseClient;
import java.util.Scanner;

public class App2 {

  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);

    System.out.print("Enter the department id: ");
    int departmentId = in.nextInt();

    try (DatabaseClient databaseClient = new DatabaseClient()) {

      Department department = databaseClient.getDepartmentById(departmentId);

      System.out.println(department);

    } catch (Exception ex) {
      System.out.println("Error" + ex.getMessage());
    }
  }

}
