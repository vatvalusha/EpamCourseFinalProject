package dao.mySqlDAO;

import dao.DBConnection;
import dao.interfaceDAO.TransportDAO;
import entity.Stop;
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
    public static final String sqlAddNewTransport = "INSERT INTO  transport(number_bus, capacity, modelRu, modelEn,id_type)VALUE (?,?,?,?,?)";
    public static final String sqlDeleteTransportOnId = "DELETE FROM transport WHERE id = ?";


    /**
     * @param transportId
     * @return
     */
    @Override
    public Transport getTransport(int transportId) {
        List<Transport> transports = getAllTransports();
        for(Transport transport : transports){
            if(transportId == transport.getID_TRANSPORT())
                return transport;
        }
        return  null;

    }

    /**
     * @return
     */
    @Override
    public List<Transport> getAllTransports() {
        connection = dbConnection.getConnection();
        List<Transport> transport = new ArrayList<>();
        try(PreparedStatement preparedStatement = connection.prepareStatement(sqlGetTransport);
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

    @Override
    public List<Transport> getRouteTransports(int routeId) {


        return null;
    }

    /**
     * @param transport
     * @throws SQLException
     */
    @Override
    public void addNewTransport(Transport transport) throws SQLException {
        connection = dbConnection.getConnection();
        try (PreparedStatement preparedStatement = connection.prepareStatement(sqlAddNewTransport)) {
            preparedStatement.setInt(1, transport.getNumberTransport());
            preparedStatement.setInt(2, transport.getCapacity());
            preparedStatement.setString(3, transport.getMODEL_NAME_RU());
            preparedStatement.setString(4, transport.getMODEL_NAME_EN());
            preparedStatement.setInt(5, transport.getTypeTransport().getID_TYPE());
            preparedStatement.executeUpdate();
        } finally {
            if (connection != null) {
                connection.close();
            }
        }
    }

    @Override
    public int addTransportOnRoute(int transportId, int routeId) {
        return 0;
    }

    /**
     * @param transportId
     */
    @Override
    public void removeTransport(int transportId) {
        Transport transport = new Transport(transportId);
        if(transport == null)
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
    public void removeFromRouteTransport(int transportId) {

    }

    /**
     * @param resultSet
     * @return
     * @throws SQLException
     * method witch create new Object for transport
     */
    private Transport map(ResultSet resultSet) throws SQLException {
        return new Transport(resultSet.getInt(1),resultSet.getInt(2),resultSet.getInt(3),
                resultSet.getString(4),resultSet.getString(5),
                mySqlTypeDAO.getConcreteType(resultSet.getInt(6)));
    }
}
