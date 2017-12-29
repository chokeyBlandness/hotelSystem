package controller;

import DAO.ConnectHotelDAO;
import model.Room;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;

@WebFilter(filterName = "ShowRoomsFilter")
public class ShowRoomsFilter implements Filter {
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
        ArrayList<Room> rooms= (ArrayList<Room>) request.getAttribute("roomList");
        if (rooms==null&&accountLevel.equals("manager")){
            ConnectHotelDAO connectHotelDAO=new ConnectHotelDAO();
            rooms=connectHotelDAO.allRoom();
            request.setAttribute("roomList",rooms);
        }
        chain.doFilter(request, resp);
    }

    public void init(FilterConfig config) throws ServletException {
        this.config=config;
    }

}
