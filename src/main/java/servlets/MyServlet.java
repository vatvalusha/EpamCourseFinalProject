package servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
/**
 * Created by valeriyartemenko on 04.04.17.
 */
public class MyServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name = req.getParameter("userName");
        resp.setContentType("text/html");
        PrintWriter pw = resp.getWriter();
        pw.println("<html>");
        pw.println("<body>");
        pw.println("Hello, " + name);
        pw.println("</body>");
        pw.println("</html>");
        pw.close();
    }
}
