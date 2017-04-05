package dao.factory;

import dao.interfaceDAO.*;

import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by valeriyartemenko on 05.04.17.
 */
public abstract class DAOFactory {

    public enum ConnTypes {
        BDConnection,
        ConnPoolMySql
    }

    public static DAOFactory getDaoFactory(ConnTypes connType) {
        switch (connType) {
            case BDConnection:
                return new DBConnection();
            case ConnPoolMySql:
//                return new ConnPoolMySqlDaoFactory();
            default:
                return null;
        }
    }

    public abstract Connection getConnection() throws SQLException;

    public abstract TransportDAO getTransportUnitsDao();

    public abstract RouteDAO getRouteDao();

    public abstract StopDAO getStopsDao();

    public abstract GeoPointDAO geoPointDAO();

    public abstract TypeTransportDAO getTypeTransportDAO();

//    public abstract UserDao getUserDao();
}
