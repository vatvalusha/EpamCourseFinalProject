package servlets;

import servlets.Commands.Command;
import servlets.Commands.CommandFactory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by valeriyartemenko on 05.04.17.
 */
public class Controller extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html");
        String view;
        Command command = CommandFactory.getCommand(request);
        try {
            view = command.execute(request, response);
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            view = request.getPathInfo().substring(1);
        }
        dispatch(request, response, view);
    }

    private void dispatch(HttpServletRequest request, HttpServletResponse response, String view) throws ServletException, IOException {
        String prefix = "/view/";
        String suffix = ".jsp";
        RequestDispatcher dispatcher = request.getRequestDispatcher(prefix + view + suffix);
        dispatcher.forward(request, response);
    }
}
