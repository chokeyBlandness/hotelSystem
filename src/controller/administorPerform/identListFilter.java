package controller.administorPerform;

import DAO.ConnectHotelDAO;
import model.Indent;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(filterName = "identListFilter")
public class identListFilter implements Filter {
    private FilterConfig config;
    public void destroy() {
        this.config=null;
    }

    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws ServletException, IOException {
        HttpServletRequest request= (HttpServletRequest) req;
        String account= (String) request.getSession().getAttribute("account");
        if (account==null){
            HttpServletResponse response= (HttpServletResponse) resp;
            response.sendRedirect("login.jsp");
            return;
        }else {
            ConnectHotelDAO connectHotelDAO = new ConnectHotelDAO();
            ArrayList<Indent> indentList = connectHotelDAO.indentFindByOrderAccount(account);
            request.setAttribute("indentList",indentList);
            chain.doFilter(request, resp);
        }
    }

    public void init(FilterConfig config) throws ServletException {
        this.config=config;
    }

}
