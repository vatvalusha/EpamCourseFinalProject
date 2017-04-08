package dao.interfaceDAO;

import entity.Stop;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by valeriyartemenko on 25.03.17.
 */
public interface StopDAO {

    List<Stop> getAllStops() throws SQLException;

    Stop getStop(int stopId) throws SQLException;

    void updateStop(Stop stop, int idStop) throws SQLException;

    void addNewStop(Stop stop) throws SQLException;

    void makeOperationInStopWithRoute(int idStop, int idRoute, String sql, Connection connection) throws SQLException;

    void removeStopFromRoute(int idStop, int idRoute) throws SQLException;

    void assignStopOnRoute(int stopId, int routeId) throws SQLException;

    List<Stop> getRoutStops(int idRoute) throws SQLException;

    void removeStop(int idStop) throws SQLException;
}
