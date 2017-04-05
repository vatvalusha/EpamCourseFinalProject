package dao.mySqlDAO;

import dao.factory.DBConnection;
import dao.interfaceDAO.AbstractStopDAO;
import dao.interfaceDAO.StopDAO;
import entity.Stop;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by valeriyartemenko on 25.03.17.
 */
public class MySqlStopDAO extends AbstractStopDAO implements StopDAO {
    DBConnection dbConnection;
    Connection connection;
    MySqlGeoPointDAO pointDAO = new MySqlGeoPointDAO();


    public MySqlStopDAO() {
        dbConnection = new DBConnection();
    }

    public static final String sqlStopList = "SELECT * FROM stops";
    public static final String sqlFindAllStopsOnRouteByID= "SELECT * FROM stops st JOIN route_with_stop rs ON st.id = rs.id_stop WHERE id_route = ? order by id_stop";
    public static final String sqlAddStop = "INSERT INTO STOPS(name_stop_ru, name_stop_en,id_geoPoint)values(?,?,?)";
    public static final String sqlDeleteStop = "DELETE  FROM stops where id = ? ";
    public static final String sqlUpdate = "UPDATE stops set name_stop_en = ?, name_stop_ru = ? WHERE id = ?";

    /**
     *
     * @return
     * @throws SQLException
     */
    @Override
    public List<Stop> getAllStops() throws SQLException {
        List<Stop> stops = new ArrayList<>();
        connection = dbConnection.getConnection();

        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlStopList)) {
            while (resultSet.next()) {
                stops.add(new Stop(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        pointDAO.getGeoPointById(resultSet.getInt(4))));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.close();
        }
        return stops;
    }

    /**
     *
     * @param stopId
     * @return
     * @throws SQLException
     */
    @Override
    public Stop getStop(int stopId) throws SQLException {
            List<Stop> stops = getAllStops();
            for(Stop stop : stops){
                if(stopId == stop.getId_stop())
                    return stop;
            }
            return null;
    }


    /**
     *
     * @param stop
     * @throws SQLException
     */
    @Override
    public void addNewStop(Stop stop) throws SQLException {
        connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlAddStop)) {
            preparedStatement.setString(1, stop.getNameRu());
            preparedStatement.setString(2, stop.getNameEn());
            preparedStatement.setInt(3, stop.getGeoPoint().getIdPoint());
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    /**
     * @param idRoute
     * @return
     * @throws SQLException
     */
    @Override
    public List<Stop> getRoutStops(int idRoute) throws SQLException {
        connection = dbConnection.getConnection();
        ResultSet resultSet;
        List<Stop> stops = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlFindAllStopsOnRouteByID)) {
            preparedStatement.setInt(1,idRoute);
            resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                stops.add(map(resultSet));
            }
        } catch (SQLException ex) {
//            LOG.warn("was caused an exception during query executing");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
//        LOG.info("list of stops was formed");
        return stops;
    }


    /**
     * @param stop
     * @param idStop
     * @throws SQLException
     */
    @Override
    public void updateStop(Stop stop, int idStop) throws SQLException {
        Stop stopOld = getStop(idStop);
        if(stopOld == null)
            return;
        connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdate)) {
            preparedStatement.setString(1, stop.getNameEn());
            preparedStatement.setString(2, stop.getNameRu());
            preparedStatement.setInt(3, stopOld.getId_stop());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param idStop
     * @throws SQLException
     */
    @Override
    public void removeStop(int idStop) throws SQLException {
        Stop stop = getStop(idStop);
        if(stop == null)
            return;
        connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteStop)) {
            preparedStatement.setInt(1, stop.getId_stop());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    private Stop map(ResultSet resultSet) throws SQLException {
        return new Stop(resultSet.getInt(1), resultSet.getString(2), resultSet.getString(3), pointDAO.getGeoPointById(resultSet.getInt(4)));
    }

    /**
     * @param stopId
     * @param routeId
     * @throws SQLException
     */
    @Override
    public void removeStopFromRoute(int stopId, int routeId) throws SQLException {
        final String sqlDeleteStopWithRoute = "DELETE FROM route_with_stop where id_stop = ? and id_route = ? ";
        connection = dbConnection.getConnection();
        this.makeOperationInStopWithRoute(stopId,routeId, sqlDeleteStopWithRoute, connection);
    }

    /**
     * @param stopId
     * @param routeId
     * @throws SQLException
     */
    @Override
    public void assignStopOnRoute(int stopId, int routeId) throws SQLException {
        final String sqlAddRouteWithStop ="INSERT INTO route_with_stop(id_stop, id_route) VALUE(?,?)";
        connection = dbConnection.getConnection();
        this.makeOperationInStopWithRoute(stopId,routeId,sqlAddRouteWithStop,connection);

    }
}
