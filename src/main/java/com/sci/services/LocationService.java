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
    private final PreparedStatement selectById;
    private final PreparedStatement deleteById;
    private final PreparedStatement updateById;
    private final PreparedStatement insert;

    public LocationService(Connection connection) throws SQLException{
        selectLocations = connection.prepareStatement(Constant.SELECT_LOCATIONS);
        selectById = connection.prepareStatement(Constant.SELECT_LOCATION_BY_ID);
        updateById = connection.prepareStatement(Constant.UPDATE_LOCATION_BY_ID);
        deleteById = connection.prepareStatement(Constant.DELETE_LOCATION_BY_ID);
        insert = connection.prepareStatement(Constant.INSERT_LOCATION);
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

      public void updateById(Location location) throws SQLException{
        updateById.clearParameters();
        updateById.setString(1, location.getStreetAddress());
        updateById.setInt(2, location.getPostalCode());
        updateById.setString(3, location.getCity());
        updateById.setString(4, location.getStateProvince());
        updateById.setString(5, location.getCountryId());
        updateById.setInt(6, location.getLocationId());
        updateById.executeQuery();
      }

      public void insert(Location location) throws SQLException{
        insert.clearParameters();
        insert.setInt(1, location.getLocationId());
        insert.setString(2, location.getStreetAddress());
        insert.setInt(3, location.getPostalCode());
        insert.setString(4, location.getCity());
        insert.setString(5, location.getStateProvince());
        insert.setString(6, location.getCountryId());
        insert.executeQuery();
      }

      public void deleteById(int locationId) throws SQLException{
        deleteById.clearParameters();
        deleteById.setInt(1, locationId);
        deleteById.executeQuery();
      }
      public Location getById(int id) throws SQLException{
        
        Location location = null;
        try {
          selectById.clearParameters();
          selectById.setInt(1, id);
          ResultSet resultSet = selectById.executeQuery();
          while(resultSet.next()){
            location = new Location();
            location.setCity(resultSet.getString("city"));
            location.setCountryId(resultSet.getString("country_id"));
            location.setLocationId(resultSet.getInt("location_id"));
            location.setPostalCode(resultSet.getInt("postal_code"));
            location.setStateProvince(resultSet.getString("state_province"));
            location.setStreetAddress(resultSet.getString("street_address"));
          }
        } catch (Exception e) {
          System.err.println("DB error: "+e.getMessage());
        }
        
        
        return location;
      }
}
