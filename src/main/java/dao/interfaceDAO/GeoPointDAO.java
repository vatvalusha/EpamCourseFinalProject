package dao.interfaceDAO;

import entity.GeoPoint;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by valeriyartemenko on 29.03.17.
 */
public interface GeoPointDAO {

    GeoPoint getGeoPointById(int id) throws SQLException;

    List<GeoPoint> getAllPoints() throws SQLException;

}
