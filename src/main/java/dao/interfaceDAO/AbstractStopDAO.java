package dao.interfaceDAO;

import dao.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by valeriyartemenko on 02.04.17.
 */
public abstract class AbstractStopDAO implements StopDAO {
    public abstract void removeStopFromRoute(int stopId, int routeId) throws SQLException;
    public abstract void assignStopOnRoute(int stopId, int routeId) throws SQLException;

    @Override
    public void makeOperationInStopWithRoute(int idStop, int idRoute, String sql, Connection connection) throws SQLException {
        connection = new DBConnection().getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
            preparedStatement.setInt(1, idStop);
            preparedStatement.setInt(2, idRoute);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally {
            connection.close();
        }
    }
}
