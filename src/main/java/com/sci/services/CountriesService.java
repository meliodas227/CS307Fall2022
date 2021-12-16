package com.sci.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sci.models.Country;
import com.sci.utils.Constant;

public class CountriesService implements AutoCloseable{
    private final PreparedStatement selectCounry;
    private final PreparedStatement selectCountryById;
    private final PreparedStatement deleteCountryById;
    private final PreparedStatement updateCountryById;
    private final PreparedStatement insertCountry;
    public CountriesService(Connection connection) throws SQLException{
        selectCounry = connection.prepareStatement(Constant.SELECT_COUNTRIES);
        selectCountryById = connection.prepareStatement(Constant.SELECT_COUNTRY_BY_ID);
        deleteCountryById = connection.prepareStatement(Constant.DELETE_COUNTRY_BY_ID);
        updateCountryById = connection.prepareStatement(Constant.UPDATE_COUNTRY_BY_ID);
        insertCountry = connection.prepareStatement(Constant.INSERT_COUNTRY);
    }
    @Override
    public void close() throws Exception {
        selectCounry.close();
    }
    public List<Country> getAll() {
        List<Country> res = new ArrayList<>();
    
        try {
    
          ResultSet resultSet = selectCounry.executeQuery();
    
          while (resultSet.next()) {
    
            Country country = new Country();
            country.setCountryId(resultSet.getString("country_id"));
            country.setCountryName(resultSet.getString("country_name"));
            country.setRegionId(resultSet.getInt("region_id"));
            
            res.add(country);
    
          }
    
        } catch (SQLException e) {
          System.err.println("DB error: " + e.getMessage());
        }
    
        return res;
      }

      public void updateById(Country country) throws SQLException{
        updateCountryById.clearParameters();
        updateCountryById.setString(1, country.getCountryName());
        updateCountryById.setInt(2, country.getRegionId());
        updateCountryById.setString(3, country.getCountryId());
        updateCountryById.executeQuery();
      }
      public Country getById(String countryId) throws SQLException{
        Country country = null;
        try {
          selectCountryById.clearParameters();
          selectCountryById.setString(1, countryId);
          ResultSet resultSet = selectCountryById.executeQuery();
          if(resultSet.next()){
            country = new Country();
            country.setCountryId(countryId);
            country.setCountryName(resultSet.getString("country_name"));
            country.setRegionId(resultSet.getInt("region_id"));
          }
        } catch (Exception e) {
          System.err.println("DB error: " + e.getMessage());
        }
        return country;
      }
      public void deleteById(String countryId) throws SQLException{
        deleteCountryById.clearParameters();
        deleteCountryById.setString(1, countryId);
        deleteCountryById.executeQuery();
      }
      public void insert(Country country) throws SQLException{
        insertCountry.clearParameters();
        insertCountry.setString(1, country.getCountryId());
        insertCountry.setString(2, country.getCountryName());
        insertCountry.setInt(3, country.getRegionId());
        insertCountry.executeQuery();
      }
}