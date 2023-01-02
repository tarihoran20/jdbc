package daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;
import java.util.ArrayList;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Division;
import models.Region;

public class DivisionDAO {

    private Connection connection;

    public DivisionDAO(Connection connection){
        this.connection = connection;
    }

    // public List<Division> getAll(){
    //     //Region region = new Region();
    //     List<Division> divisions = new ArrayList<>();
    //     String query = "SELECT * FROM DIVISIONS";
    //     try{
    //         ResultSet resultSet = connection
    //                     .prepareStatement(query)
    //                     .executeQuery();

    //         while (resultSet.next()) {
    //             Division division = new Division();
    //             division.setDivisionId(resultSet.getInt(1));
    //             division.setDivisionName(resultSet.getString(2));
    //             division.setRegionId(resultSet.getInt(3));
    //             divisions.add(division);
    //         }
    //     } catch (SQLException e) {
    //         e.printStackTrace();
    //     }
    //     return divisions;

    // }
    public List<Division> getAll(){
        //Region region = new Region();
        List<Division> divisions = new ArrayList<>();
        String query = "SELECT d.division_id, d.division_name, r.region_name FROM divisions d JOIN regions r on d.region_id = r.region_id";
        try{
            ResultSet resultSet = connection
                        .prepareStatement(query)
                        .executeQuery();

            while (resultSet.next()) {
                Division division = new Division();
                Region region = new Region();
                division.setDivisionId(resultSet.getInt(1));
                division.setDivisionName(resultSet.getString(2));
                division.setRegionName(resultSet.getString(3));
                divisions.add(division);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return divisions;

    }

    public boolean insert (Division division){
        try {

            PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO DIVISIONS (division_id, division_name, region_id) VALUES(?, ?, ?)");
            preparedStatement.setInt(1, division.getDivisionId());
            preparedStatement.setString(2, division.getDivisionName());
            preparedStatement.setInt(3, division.getRegionId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean delete(Division division) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM DIVISIONS WHERE division_id = ?");
            preparedStatement.setInt(1, division.getDivisionId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }

    public boolean update(Division division) {
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("UPDATE DIVISIONS SET division_name = ?, region_id = ? WHERE division_id = ? ");
            preparedStatement.setString(1, division.getDivisionName());
            preparedStatement.setInt(2, division.getRegionId());
            preparedStatement.setInt(3, division.getDivisionId());
            preparedStatement.execute();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return false;
    }
    
}
