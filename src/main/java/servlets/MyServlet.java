package servlets;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Created by valeriyartemenko on 04.04.17.
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

//        String name = req.getParameter("userName");
        String name = null;
//        Cookie[] cookies = req.getCookies();
//        if(cookies != null){
//            for(Cookie cookie : cookies){
//                if(cookie.getName().equals("name")){
//                    name = cookie.getValue();
//                }
//            }
//        }
//        if(name == null) {
//            name = req.getParameter("userName");
//            Cookie cookie = new Cookie("name",name);
//            cookie.setMaxAge(10000);
////            JavaScript have access on cookies
////            cookie.setHttpOnly(false);
//            resp.addCookie(cookie);
//        }

        //true - in not exists session will be create
        //false - in not exists session will not be create
//        HttpSession session = req.getSession(true);
//        name  = (String) session.getAttribute("name");
//        if(name == null) {
//            name = req.getParameter("userName");
//            session.setAttribute("name",name);
//        }
        name = (String) req.getAttribute("userName");
        RequestDispatcher dispatcher  = req.getRequestDispatcher("/output");
        req.setAttribute("user",name);
        dispatcher.include(req,resp);
    }
}
