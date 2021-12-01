package com.sci.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sci.models.Countries;
import com.sci.utils.Constant;

public class CountriesService implements AutoCloseable{
    private final PreparedStatement selectCounry;
    public CountriesService(Connection connection) throws SQLException{
        selectCounry = connection.prepareStatement(Constant.SELECT_COUNTRIES);
    }
    @Override
    public void close() throws Exception {
        selectCounry.close();
    }
    public List<Countries> getAll() {
        List<Countries> res = new ArrayList<>();
    
        try {
    
          ResultSet resultSet = selectCounry.executeQuery();
    
          while (resultSet.next()) {
    
            Countries country = new Countries();
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
}