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
    public RegionService(Connection connection) throws SQLException{
        selectRegion = connection.prepareStatement(Constant.SELECT_REGIONS);
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
}
