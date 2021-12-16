package com.sci;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sci.models.Region;
import com.sci.services.DatabaseClient;

public class Regions {
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
    private static void handleUpdateById() throws SQLException{
        System.out.print("enter region id: ");
        int ID = input.nextInt();
        System.out.print("enter region name: ");
        String regionName = input.next();
        Region region = new Region();
        region.setRegionId(ID);
        region.setRegionName(regionName);
        db.updateById(region);  
    }
    private static void handleDeleteById() throws SQLException{
        System.out.print("enter region id: ");
        int ID = input.nextInt();
        db.deleteRegionById(ID);
    }
    private static void handleInsert() throws SQLException{
        System.out.print("enter region id: ");
        int ID = input.nextInt();
        System.out.print("enter region name: ");
        String regionName = input.next();
        Region region = new Region();
        region.setRegionId(ID);
        region.setRegionName(regionName);
        db.insert(region);  
    }
    private static void handleSelectById() throws SQLException{
        System.out.print("enter region id: ");
        int ID = input.nextInt();
        System.out.println(db.getRegionById(ID));
    }
    private static void handleSelectAll() throws SQLException{
        List<Region> regionList = db.getAllRegions();
        for(Region region : regionList){
            System.out.println(region);
        }
    }
}
