package servlets.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by valeriyartemenko on 05.04.17.
 */
public class MyFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = servletRequest.getParameter("userName");
        name += "from filter 1";
        servletRequest.setAttribute("userName",name);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
