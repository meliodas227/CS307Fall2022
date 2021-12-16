package com.sci.services;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.sci.models.Region;
import com.sci.utils.Constant;


public class RegionService implements AutoCloseable{
    public final PreparedStatement selectRegion;
    public final PreparedStatement selectRegionById;
    public final PreparedStatement updateRegionById;
    public final PreparedStatement deleteRegionById;
    public final PreparedStatement insertRegion;
    public RegionService(Connection connection) throws SQLException{
        selectRegion = connection.prepareStatement(Constant.SELECT_REGIONS);
        selectRegionById = connection.prepareStatement(Constant.SELECT_REGION_BY_ID);
        updateRegionById = connection.prepareStatement(Constant.UPDATE_REGION_BY_ID);
        deleteRegionById = connection.prepareStatement(Constant.DELETE_REGION_BY_ID);
        insertRegion = connection.prepareStatement(Constant.INSERT_REGION);
    }
    @Override
    public void close() throws Exception {
        selectRegion.close();
    }
    public List<Region> getAll() {
        List<Region> res = new ArrayList<>();
    
        try {
    
          ResultSet resultSet = selectRegion.executeQuery();
    
          while (resultSet.next()) {
    
            Region region = new Region();
            region.setRegionId(resultSet.getInt("region_id"));
            region.setRegionName(resultSet.getString("region_name"));

            res.add(region);
            
          }
    
        } catch (SQLException e) {
          System.err.println("DB error: " + e.getMessage());
        }
    
        return res;
      }

      public void updateById(Region region) throws SQLException{
        updateRegionById.clearParameters();
        updateRegionById.setString(1, region.getRegionName());
        updateRegionById.setInt(2, region.getRegionId());
        updateRegionById.executeQuery();
      }
      public void deleteById(int ID) throws SQLException{
        deleteRegionById.clearParameters();
        deleteRegionById.setInt(1, ID);
        deleteRegionById.executeQuery();
      }
      public void insert(Region regoin) throws SQLException{
        insertRegion.clearParameters();
        insertRegion.setInt(1, regoin.getRegionId());
        insertRegion.setString(2, regoin.getRegionName());
        insertRegion.executeQuery();
      }
      public Region getById(int ID) throws SQLException{
        Region region = null;
        try {
          selectRegionById.clearParameters();
          selectRegionById.setInt(1, ID);  
          ResultSet resultSet = selectRegionById.executeQuery();
          if(resultSet.next()){
            region=new Region();
            region.setRegionId(ID);
            region.setRegionName(resultSet.getString("region_name"));
          }
        } catch (Exception e) {
          System.err.println("DB error: "+e.getMessage());
        }
        
        return region;
      }
}
