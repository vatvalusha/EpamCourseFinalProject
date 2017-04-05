package dao.factory;

import dao.interfaceDAO.*;
import dao.mySqlDAO.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Created by valeriyartemenko on 25.03.17.
 */
public class DBConnection extends DAOFactory {

    // JDBC driver name and database URL
    static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";

    static final String DB_URL = "jdbc:mysql://localhost:3306/epam3";

    static final String USER = "root";

    static final String PASS = "";

    public Connection getConnection(){
        Connection connection = null;
        try {
            Class.forName(JDBC_DRIVER);
            connection = DriverManager.getConnection(DB_URL,USER,PASS);
//            System.out.println("Connected OK");
        } catch (ClassNotFoundException | SQLException e) {
            System.out.println("Not Connection");
            e.printStackTrace();
        }

        return connection;
    }

    @Override
    public TransportDAO getTransportUnitsDao() {
        return new MySqlTransportDAO();
    }

    @Override
    public RouteDAO getRouteDao() {
        return new MySqlRouteDAO();
    }

    @Override
    public StopDAO getStopsDao() {
        return new MySqlStopDAO();
    }

    @Override
    public GeoPointDAO geoPointDAO() {
        return new MySqlGeoPointDAO();
    }

    @Override
    public TypeTransportDAO getTypeTransportDAO() {
        return new MySqlTypeDAO();
    }

}
