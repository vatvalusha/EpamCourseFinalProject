package dao.mySqlDAO;

import dao.factory.DBConnection;
import dao.interfaceDAO.TransportDAO;
import entity.Transport;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by valeriyartemenko on 27.03.17.
 */
public class MySqlTransportDAO implements TransportDAO {
    DBConnection dbConnection = new DBConnection();
    Connection connection = dbConnection.getConnection();
    MySqlTypeDAO mySqlTypeDAO = new MySqlTypeDAO();
    public static final String sqlGetTransport = "Select * FROM transport";
    public static final String sqlAddNewTransport = "INSERT INTO  transport(route_id,number_bus,capacity,modelRu,modelEn,id_type)VALUE (?,?,?,?,?,?)";
    public static final String sqlDeleteTransportOnId = "DELETE FROM transport WHERE id = ?";
    public static final String sqlFindWhereRouteIdNull = "SELECT * FROM transport WHERE route_id is null";
    public static final String sqlFindTransportByRouteId = "SELECT * FROM transport WHERE route_id = ?";
    private static final String sqlUpdateRouteByIdTransport = "UPDATE transport set route_id = ? WHERE id = ?";
    private static final String sqlRemoveTransportFromRoute = "UPDATE transport set route_id = null WHERE id = ?";


    /**
     * @param transportId
     * @return
     */
    @Override
    public Transport getTransport(int transportId) {
        List<Transport> transports = getAllTransports();
        for (Transport transport : transports) {
            if (transportId == transport.getID_TRANSPORT())
                return transport;
        }
        return null;

    }

    /**
     * @return
     */
    @Override
    public List<Transport> getAllTransports() {
        connection = dbConnection.getConnection();
        List<Transport> transport = new ArrayList<>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlGetTransport);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                transport.add(map(resultSet));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
//        LOG.info("list of Units was formed");
        return transport;
    }

    /**
     * @param routeId
     * @return
     * @throws SQLException
     */
    @Override
    public List<Transport> getRouteTransports(int routeId) throws SQLException {
        if (routeId == 0) return getZeroTransportUnits();
        connection = dbConnection.getConnection();
        List<Transport> transports = new ArrayList<Transport>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlFindTransportByRouteId)) {
            preparedStatement.setInt(1, routeId);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                transports.add(map(resultSet));
            }
        } catch (SQLException ex) {
//            LOG.warn("was caused an exception during query executing");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
//        LOG.info("list of units from route " + routeId + " was formed");
        return transports;
    }

    /**
     * @param transport
     * @throws SQLException
     */
    @Override
    public void addNewTransport(Transport transport) throws SQLException {
        connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlAddNewTransport)) {
            preparedStatement.setInt(1, transport.getIdRoute());
            preparedStatement.setInt(2, transport.getNumberTransport());
            preparedStatement.setInt(3, transport.getCapacity());
            preparedStatement.setString(4, transport.getMODEL_NAME_RU());
            preparedStatement.setString(5, transport.getMODEL_NAME_EN());
            preparedStatement.setInt(6, transport.getTypeTransport().getID_TYPE());
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public void addTransportOnRoute(int transportId, int routeId) throws SQLException {
        connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlUpdateRouteByIdTransport)) {
            preparedStatement.setInt(1, routeId);
            preparedStatement.setInt(2, transportId);
            int result = preparedStatement.executeUpdate();
//            LOG.info("unit " + transportId + " was assigned to route" + routeId + " with result " + result);
        } catch (SQLException ex) {
//            LOG.warn("was caused an exception during query executing");
            ex.printStackTrace();

        } finally {
            connection.close();
        }

    }

    /**
     * @return
     * @throws SQLException
     */
    private List<Transport> getZeroTransportUnits() throws SQLException {
        connection = dbConnection.getConnection();
        List<Transport> transports = new ArrayList<Transport>();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlFindWhereRouteIdNull);
             ResultSet resultSet = preparedStatement.executeQuery()) {
            while (resultSet.next()) {
                transports.add(map(resultSet));
            }
        } catch (SQLException ex) {
//            LOG.warn("was caused an exception during query executing");
            ex.printStackTrace();
        } finally {
            connection.close();
        }
//        LOG.info("list of units from route zero was formed");
        return transports;
    }

    /**
     * @param transportId
     */
    @Override
    public void removeTransport(int transportId) {
        Transport transport = new Transport(transportId);
        if (transport == null)
            return;
        connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlDeleteTransportOnId)) {
            preparedStatement.setInt(1, transport.getID_TRANSPORT());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeFromRouteTransport(int transportId) throws SQLException {
        connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlRemoveTransportFromRoute)) {
            preparedStatement.setInt(1, transportId);
            preparedStatement.executeUpdate();
            int result = preparedStatement.executeUpdate();
//            LOG.info("unit " + transportId + " was assigned to route null with result " + result);
        } catch (SQLException ex) {
//            LOG.warn("was caused an exception during query executing");
            ex.printStackTrace();

        } finally {
            connection.close();
        }

    }

    /**
     * @param resultSet
     * @return
     * @throws SQLException method witch create new Object for transport
     */
    private Transport map(ResultSet resultSet) throws SQLException {
        return new Transport(resultSet.getInt(1), resultSet.getInt(3), resultSet.getInt(4),
                resultSet.getString(5), resultSet.getString(6),
                mySqlTypeDAO.getConcreteType(resultSet.getInt(7)), resultSet.getInt(2));
    }
}
