package controller.staffPerform;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebFilter(filterName = "StaffLimitFilter")
public class StaffLimitFilter implements Filter {
    private FilterConfig config;
    public void destroy() {
        config=null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        String accountLevel= (String) request.getSession().getAttribute("accountLevel");
        if (accountLevel==null){
            accountLevel="";
        }
        if (accountLevel.equals("staff")||accountLevel.equals("manager")){
            chain.doFilter(req, resp);
        }else {
            HttpServletResponse response= (HttpServletResponse) resp;
            response.sendRedirect("index.jsp");
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.config=config;
    }

}
