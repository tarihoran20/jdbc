package daos;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import com.mysql.jdbc.*;
//import com.mysql.cj.xdevapi.PreparableStatement;

import models.Region;

public class RegionDAO {
    private Connection connection;

    public RegionDAO(Connection connection){
        this.connection = connection;
    }

    public List<Region> getAll(){
        //Region region = new Region();
        List<Region> regions = new ArrayList<>();
        String query = "SELECT * FROM REGIONS";
        try{
            ResultSet resultSet = connection
                        .prepareStatement(query)
                        .executeQuery();

            while (resultSet.next()) {
                Region region = new Region();
                region.setRegionId(resultSet.getInt(1));
                region.setRegionName(resultSet.getString(2));
                regions.add(region);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return regions;

    }

    public boolean insert (Region region){
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO REGIONS (region_id, region_name) VALUES(?, ?)");
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.setString(2, region.getRegionName());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;

    }

    public boolean delete(Region region) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM REGIONS WHERE region_id = ?");
            preparedStatement.setInt(1, region.getRegionId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    public boolean update(Region region) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE REGIONS SET region_name = ? WHERE region_id = ? ");
            preparedStatement.setString(1, region.getRegionName());
            preparedStatement.setInt(2, region.getRegionId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    
    
}
