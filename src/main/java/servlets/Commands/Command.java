package servlets.Commands;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by valeriyartemenko on 05.04.17.
 */
public interface Command {
    public String execute(HttpServletRequest request, HttpServletResponse response) throws Exception;
}

