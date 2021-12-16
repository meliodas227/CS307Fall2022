package com.sci;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

import com.sci.models.Country;
import com.sci.services.DatabaseClient;

public class countries {
    static Scanner input;
    static DatabaseClient db;
    public static void main(String[] args) throws SQLException {
        input = new Scanner(System.in);
        db = new DatabaseClient();
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
    private static void handleUpdateById() throws SQLException{
        System.out.print("enter country id: ");
        String countryId = input.next();
        System.out.print("enter country name: ");
        String countryName = input.next();
        System.out.print("enter region id: ");
        int regionId = input.nextInt();
        Country country = new Country();
        country.setCountryId(countryId);
        country.setCountryName(countryName);
        country.setRegionId(regionId);
        db.updateById(country);
    }
    private static void handleDeleteById() throws SQLException{
        System.out.print("enter country id: ");
        String countryId = input.next();
        db.deleteCountryById(countryId);
    }
    private static void handleInsert() throws SQLException{
        System.out.print("enter country id: ");
        String countryId = input.next();
        System.out.println("enter country name: ");
        String countryName = input.next();
        System.out.print("enter region id: ");
        int regionId = input.nextInt();
        Country country = new Country();
        country.setCountryId(countryId);
        country.setCountryName(countryName);
        country.setRegionId(regionId);
        db.insert(country);
    }
    private static void handleSelectById() throws SQLException{
        System.out.print("enter country id: ");
        String countryId = input.next();
        System.out.println(db.getCountryById(countryId));
    }
    private static void handleSelectAll() throws SQLException{
        List<Country> countryList = db.getAllCountries();
        for(Country country : countryList){
            System.out.println(country);
        }
    }
}
