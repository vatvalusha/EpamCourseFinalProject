package dao.interfaceDAO;

import entity.Route;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by valeriyartemenko on 25.03.17.
 */
public interface RouteDAO {

    List<Route> getAllRoutes() throws SQLException;

    Route getRoute(int routeId) throws SQLException;

    void addNewRoute(Route route) throws SQLException;

    void removeRoute(int routeId) throws SQLException;
}
