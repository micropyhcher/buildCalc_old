package by.tms.buildCalc.filter;

import by.tms.buildCalc.enums.UserRoles;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

public class UserFilter implements Filter {
    public void destroy() {
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
//        HttpServletRequest httpServletRequest = (HttpServletRequest) req;
//        if (httpServletRequest.getSession().isNew()) {
//            httpServletRequest.getSession().setAttribute("user", UserRoles.GUEST);
//        }
//        chain.doFilter(req, resp);
    }

    public void init(FilterConfig config) throws ServletException {

    }

}

