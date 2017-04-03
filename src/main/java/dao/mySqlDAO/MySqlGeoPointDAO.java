package dao.mySqlDAO;

import dao.DBConnection;
import dao.interfaceDAO.GeoPointDAO;
import entity.GeoPoint;
import entity.Stop;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by valeriyartemenko on 29.03.17.
 */
public class MySqlGeoPointDAO implements GeoPointDAO {

    DBConnection dbConnection;
    Connection connection;

    public MySqlGeoPointDAO(){
        dbConnection = new DBConnection();
    }

    public static final String sqlAllPoint = "SELECT * FROM geo_point";

//    public static final String aqlConcretePoints = "SELECT * FROM geo_point WHERE id = ?";


    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<GeoPoint> getAllPoints() throws SQLException {
        connection = dbConnection.getConnection();
        List<GeoPoint> geoPoints = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlAllPoint)) {
            while (resultSet.next()) {
                geoPoints.add(new GeoPoint(resultSet.getInt(1),
                                            resultSet.getDouble(2),
                                            resultSet.getDouble(3)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.close();
        }
        return geoPoints;
    }

    /**
     *
     * @param id
     * @return
     * @throws SQLException
     */
    @Override
    public GeoPoint getGeoPointById(int id) throws SQLException {
        List<GeoPoint> geoPoints = getAllPoints();
        for(GeoPoint g : geoPoints){
            if(id == g.getIdPoint())
                return g;
        }
        return  null;
    }

}
