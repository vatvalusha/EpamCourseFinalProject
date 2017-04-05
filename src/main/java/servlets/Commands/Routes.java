//package servlets.Commands;
//
//import dao.factory.DAOFactory;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * Created by valeriyartemenko on 05.04.17.
// */
//public class Routes implements Command {
//    @Override
//    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
//        if (request.getSession().getAttribute("routes") != null) return "routes";
//        else {
//            DAOFactory daoFactory = DataSourceDaoFactory.getDAOFactory();
//            List<Route> allRoutes = daoFactory.getRouteDao().getAllRoutes();
//            if (allRoutes == null) {
//                request.getSession().setAttribute("error", "Error with DB connection");
//                return "error_page";
//            }
//            request.getSession().setAttribute("routes", allRoutes);
//            return "routes";
//        }
//    }
//}
