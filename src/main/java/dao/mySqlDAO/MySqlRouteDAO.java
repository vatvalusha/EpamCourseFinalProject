package dao.mySqlDAO;

import dao.factory.DBConnection;
import dao.interfaceDAO.RouteDAO;
import entity.Route;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by valeriyartemenko on 03.04.17.
 */
public class MySqlRouteDAO implements RouteDAO {
    DBConnection dbConnection;
    Connection connection;
    MySqlTypeDAO mySqlTypeDAO = new MySqlTypeDAO();
    public static final String sqlAllRoute = "SELECT * FROM route";
    public static final String sqlAddNewRoute = "INSERT INTO route(id_transport, name_route_ru, name_route_en) VALUE (?,?,?)";
    public static final String sqlDeleteRoute = "DELETE FROM route WHERE id = ?";

    public MySqlRouteDAO(){
        dbConnection = new DBConnection();
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public List<Route> getAllRoutes() throws SQLException {
        List<Route> routes = new ArrayList<>();
        connection = dbConnection.getConnection();
        try(Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlAllRoute)){
            while (resultSet.next()){
                routes.add(map(resultSet));
            }
        }finally {
                connection.close();
        }
        return routes;
    }

    /**
     * @param routeId
     * @return
     * @throws SQLException
     */
    @Override
    public Route getRoute(int routeId) throws SQLException {
        List<Route> routes = getAllRoutes();
        for(Route route : routes)
            if(routeId == route.getRouteId())
                return route;
        return null;
    }

    /**
     * @param route
     * @throws SQLException
     */
    @Override
    public void addNewRoute(Route route) throws SQLException {
        connection = dbConnection.getConnection();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlAddNewRoute)){
            preparedStatement.setInt(3,route.getTypeTransport().getID_TYPE());
            preparedStatement.setString(1,route.getName_route_ru());
            preparedStatement.setString(2,route.getName_route_en());
            preparedStatement.executeUpdate();
        }finally {
            connection.close();
        }

    }

    /**
     * @param routeId
     * @throws SQLException
     */
    @Override
    public void removeRoute(int routeId) throws SQLException {
        Route route = getRoute(routeId);
        connection = dbConnection.getConnection();
        if(route == null)
            return;
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteRoute)){
            preparedStatement.setInt(1,route.getRouteId());
            preparedStatement.executeUpdate();
        }finally {
            connection.close();
        }

    }

    private Route map(ResultSet resultSet) throws SQLException {
        return new Route(resultSet.getInt(1),
                        resultSet.getString(2),
                        resultSet.getString(3),
                        mySqlTypeDAO.getConcreteType(resultSet.getInt(4)));
    }
}
