package controller.administorPerform;

import DAO.ConnectHotelDAO;
import model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

@WebServlet(name = "SearchUsefulRoomsByTimeServlet")
public class SearchUsefulRoomsByTimeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String limitTime= request.getParameter("limitTime");
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-mm-dd");
        Date date=new Date();
        try {
            date=simpleDateFormat.parse(limitTime);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        long searchTime=date.getTime();
        ConnectHotelDAO connectHotelDAO=new ConnectHotelDAO();
        ArrayList<Room> roomList=connectHotelDAO.usefulRoomsFindByTime(searchTime);
        request.setAttribute("roomList",roomList);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("findUsefulRoomsByTime.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
