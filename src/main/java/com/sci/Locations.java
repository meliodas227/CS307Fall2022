package com.sci;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sci.models.Location;
import com.sci.services.DatabaseClient;

public class Locations {
    static Scanner input;
    static DatabaseClient db;
    public static void main(String[] args) throws SQLException{
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
                    handleInsertLocation();
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
        System.out.print("enter location id: ");
        int locationId = input.nextInt();
        System.out.print("enter city: ");
        String city = input.next();
        System.out.print("enter country id: ");
        String countryId = input.next();
        System.out.print("enter postal code: ");
        int postalCode = input.nextInt();
        System.out.print("enter state province: ");
        String stateProvince = input.next();
        System.out.print("enter street address: ");
        String streetAddress = input.next();
        Location location = new Location();
        location.setCity(city);
        location.setCountryId(countryId);
        location.setLocationId(locationId);
        location.setPostalCode(postalCode);
        location.setStateProvince(stateProvince);
        location.setStreetAddress(streetAddress);
        db.updateById(location);
    }
    private static void handleDeleteById() throws SQLException{
        System.out.print("enter location id: ");
        int locationId = input.nextInt();
        db.deleteLocationById(locationId);
    }
    private static void handleInsertLocation() throws SQLException{
        System.out.print("enter location id: ");
        int locationId = input.nextInt();
        System.out.print("enter city: ");
        String city = input.next();
        System.out.print("enter country id: ");
        String countryId = input.next();
        System.out.print("enter postal code: ");
        int postalCode = input.nextInt();
        System.out.print("enter state province: ");
        String stateProvince = input.next();
        System.out.print("enter street address: ");
        String streetAddress = input.next();
        Location location = new Location();
        location.setCity(city);
        location.setCountryId(countryId);
        location.setLocationId(locationId);
        location.setPostalCode(postalCode);
        location.setStateProvince(stateProvince);
        location.setStreetAddress(streetAddress);
        db.insert(location);
    }
    private static void handleSelectById() throws SQLException{
        System.out.print("enter location id: ");
        int locationId = input.nextInt();
        System.out.println(db.getlocationById(locationId));
    }
    private static void handleSelectAll() throws SQLException{
        List<Location> locationList = db.getAllLocations();
        for(Location location: locationList){
            System.out.println(location);
        }
    }
}
