package dao.mySqlDAO;

import dao.factory.DBConnection;
import dao.interfaceDAO.TypeTransportDAO;
import entity.TypeTransport;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by valeriyartemenko on 29.03.17.
 */
public class MySqlTypeDAO implements TypeTransportDAO {

    DBConnection dbConnection;

    Connection connection;

    public static final String sqlAllType = "SELECT * FROM type_transport";

    public MySqlTypeDAO(){
        dbConnection = new DBConnection();
    }


    /**
     * @return
     * @throws SQLException
     */
    @Override
    public List<TypeTransport> TYPE_LIST() throws SQLException {
        connection = dbConnection.getConnection();
        List<TypeTransport> listType = new ArrayList<>();
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sqlAllType)) {
            while (resultSet.next()) {
                listType.add(new TypeTransport(resultSet.getInt(1),resultSet.getString(2)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if (connection != null)
                connection.close();
        }
        return listType;
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public TypeTransport getConcreteType(int idType) throws SQLException {
        List<TypeTransport> types = TYPE_LIST();
            for(TypeTransport type : types)
                if (type.getID_TYPE() == idType)
                    return type;

        return null;
    }

}
