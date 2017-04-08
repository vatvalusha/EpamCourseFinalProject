package servlets.Commands;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by valeriyartemenko on 05.04.17.
 */
public class CommandFactory {

    private static final Map<String, Command> comands;

    static {
        comands = new HashMap<>();
        comands.put("/routes", new Routes());
        comands.put("/route_detailes", new RouteDetailes());
    }

    public static Command getCommand(HttpServletRequest request) {
        return comands.get(request.getPathInfo());
    }
}
