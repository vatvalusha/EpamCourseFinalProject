import dao.mySqlDAO.*;
import entity.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by valeriyartemenko on 25.03.17.
 */
public class MainTest {

   public static MySqlStopDAO mySqlStopDAO = new MySqlStopDAO();
   public static MySqlTypeDAO mySqlTypeDAO = new MySqlTypeDAO();
   public static MySqlGeoPointDAO mySqlGeoPointDAO = new MySqlGeoPointDAO();
   public static MySqlTransportDAO mySqlTransportDAO = new MySqlTransportDAO();
   public static MySqlRouteDAO mySqlRouteDAO = new MySqlRouteDAO();

    public static void main(String[] args) throws SQLException {
//        showAllRoutes();
            showAllTransport();

    }


    public static void showAllRoutes() throws SQLException {
        List<Route> routes = mySqlRouteDAO.getAllRoutes();
        for(Route route : routes)
            System.out.println(route.toString());
    }

    public static void showAllTransport(){
        List<Transport> transports = mySqlTransportDAO.getAllTransports();
        for(Transport transport: transports)
            System.out.println(transport.toString());
    }
        public static Stop oldStop(String nameRu, String nameEn){
        Stop stop = new Stop(nameEn,nameRu);
        return stop;
    }

    public static void showAllFromStop() throws SQLException {
        List<Stop> stops =  mySqlStopDAO.getAllStops();
        for(Stop p : stops){
            System.out.println(p.toString());
        }
    }
    public static void showRoutStops() throws SQLException {
            List<Stop> stops = mySqlStopDAO.getRoutStops(1);
            for(Stop stop : stops){
                System.out.println(stop.toString());
            }
    }

    public static void showAllTypes() throws SQLException {
            List<TypeTransport> types = mySqlTypeDAO.TYPE_LIST();
            for(int i = 0 ; i<types.size();i++)
                System.out.println(types.get(i).toString());
    }

    public static void showAllPoint() throws SQLException {
        List<GeoPoint> geoPoints = mySqlGeoPointDAO.getAllPoints();
        for(GeoPoint p : geoPoints)
            System.out.println(p.toString());
    }
}
