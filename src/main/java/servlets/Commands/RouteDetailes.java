package servlets.Commands;

import dao.factory.DAOFactory;
import entity.Route;
import entity.Stop;
import entity.Transport;
import org.apache.log4j.Logger;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by valeriyartemenko on 08.04.17.
 */
public class RouteDetailes implements Command {

    private static final Logger LOG = Logger.getLogger(RouteDetailes.class);

    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        //getting route ID
        int routeId = Integer.parseInt(request.getParameter("routeId"));
//        LOG.info("Processing with route ID " + routeId);
        System.out.println(routeId);

        if (routeId == 0) return "routes";
        else {
            DAOFactory daoFactory = SoursceDaoFactory.getDAOFactory();
            List<Stop> allStops = daoFactory.getStopsDao().getRoutStops(routeId);
            request.getSession().setAttribute("routeId", routeId);
            List<Transport> transports = daoFactory.getTransportDao().getRouteTransports(routeId);
            Route route = daoFactory.getRouteDao().getRoute(routeId);
            if (route != null) {
                route.setStopList(allStops);
                if (transports != null) {
                    route.setTransportList(transports);
                    request.getSession().setAttribute("transports", transports);
                    request.getSession().setAttribute("routeUnitsQuantity", transports.size());
                }
//                double routeLength = route.getRouteLength();
//                double routeTime = route.getRouteTimeDerth();
                request.getSession().setAttribute("allStops", allStops);
//                request.getSession().setAttribute("routeLength", routeLength);
//                request.getSession().setAttribute("routeTime", routeTime);
            }
            return "route_detailes";
        }
    }
}
