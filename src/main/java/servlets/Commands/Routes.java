package servlets.Commands;

import dao.factory.DAOFactory;
import entity.Route;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * Created by valeriyartemenko on 05.04.17.
 */
public class Routes implements Command {
    @Override
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
        if (request.getSession().getAttribute("routes") != null) return "routes";
        else {
            DAOFactory daoFactory = SoursceDaoFactory.getDAOFactory();
            List<Route> allRoutes = daoFactory.getRouteDao().getAllRoutes();
            if (allRoutes == null) {
                request.getSession().setAttribute("error", "Error with DB connection");
                return "error_page";
            }
            request.getSession().setAttribute("routes", allRoutes);
            return "routes";
        }
    }
}
