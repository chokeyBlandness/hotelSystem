package controller.managerPerform;

import DAO.ConnectHotelDAO;
import model.Administor;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(filterName = "SearchAllAdministorFilter")
public class SearchAllAdministorFilter implements Filter {
    private FilterConfig config;
    public void destroy() {
        this.config=null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        ConnectHotelDAO connectHotelDAO=new ConnectHotelDAO();
        ArrayList<Administor> allAdministor=connectHotelDAO.allAdministor();
        HttpServletRequest request= (HttpServletRequest) req;
        request.setAttribute("allAdministors",allAdministor);
        chain.doFilter(request, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.config=config;
    }

}
