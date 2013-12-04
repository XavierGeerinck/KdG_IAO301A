package be.kdg.webapps102.filters;

import java.io.IOException;
import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;

public class LoggingFilter implements Filter
{
    @Override
    public void init(FilterConfig filterConfig) throws ServletException
    {
        System.out.println("filter staat klaar");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException
    {
        System.out.println("filter voor het oproepen van de servlet");
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        String method = request.getMethod();
        System.out.println("method = " + method);
        StringBuffer requestedURL = request.getRequestURL();
        System.out.println("requestedURL.toString() = " + requestedURL.toString());
        request.setAttribute("message", "message from filter");
        filterChain.doFilter(servletRequest, servletResponse);
        System.out.println("filter na het oproepen van de servlet");
    }

    @Override
    public void destroy()
    {
        System.out.println("filter wordt gestopt");
    }
}
