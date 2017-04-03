package dao.interfaceDAO;

import entity.TransportType;
import entity.TypeTransport;

import java.sql.SQLException;
import java.util.List;


/**
 * Created by valeriyartemenko on 29.03.17.
 */
public interface TypeTransportDAO {

    List<TypeTransport> TYPE_LIST() throws SQLException;

    TypeTransport getConcreteType(int idType) throws SQLException;
}
