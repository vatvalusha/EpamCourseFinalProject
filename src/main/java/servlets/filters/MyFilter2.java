package servlets.filters;

import javax.servlet.*;
import java.io.IOException;

/**
 * Created by valeriyartemenko on 05.04.17.
 */
public class MyFilter2 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        String name = (String) servletRequest.getAttribute("userName");
        name += "from filter 2";
        servletRequest.setAttribute("userName",name);
        filterChain.doFilter(servletRequest,servletResponse);
    }

    @Override
    public void destroy() {

    }
}
