package dao.interfaceDAO;

import entity.Transport;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by valeriyartemenko on 25.03.17.
 */
public interface TransportDAO {

    Transport getTransport(int transportId);

    List<Transport> getAllTransports();

    List<Transport> getRouteTransports(int routeId);

    void addNewTransport(Transport transport) throws SQLException;

    int addTransportOnRoute(int transportId, int routeId);

    void removeTransport(int transportId);

    void removeFromRouteTransport(int transportId);



}
