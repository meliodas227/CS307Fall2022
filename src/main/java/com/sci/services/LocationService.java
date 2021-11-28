package com.sci.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;


import com.sci.models.Location;
import com.sci.utils.Constant;

public class LocationService implements AutoCloseable{
    private final PreparedStatement selectLocations;
    public LocationService(Connection connection) throws SQLException{
        selectLocations = connection.prepareStatement(Constant.SELECT_LOCATIONS);
    }
    @Override
    public void close() throws Exception {
        selectLocations.close();
    }
    public List<Location> getAll() {
        List<Location> res = new ArrayList<>();
    
        try {
    
          ResultSet resultSet = selectLocations.executeQuery();
    
          while (resultSet.next()) {
    
            Location location = new Location();
    
            location.setCity(resultSet.getString("city"));
            location.setCountryId(resultSet.getString("country_id"));
            location.setLocationId(resultSet.getInt("Location_id"));
            location.setPostalCode(resultSet.getInt("postal_code"));
            location.setStateProvince(resultSet.getString("state_province"));
            location.setStreetAddress(resultSet.getString("street_address"));

            res.add(location);
    
          }
    
        } catch (SQLException e) {
          System.err.println("DB error: " + e.getMessage());
        }
    
        return res;
      }
}
