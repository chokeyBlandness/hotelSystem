package controller.managerPerform;

import DAO.ConnectHotelDAO;
import model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "SearchAllRoomsServlet")
public class SearchAllRoomsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchCategory=request.getParameter("searchCategory");
        ArrayList<Room> roomList=null;
        ConnectHotelDAO connectHotelDAO=new ConnectHotelDAO();
        if (searchCategory==null){
            roomList=connectHotelDAO.allRoom();
        }else {
            if (searchCategory.equals("floor")){
                int floor = Integer.parseInt(request.getParameter("floor"));
                roomList=connectHotelDAO.roomsFindByFloor(floor);
            }else if (searchCategory.equals("proporty")){
                String proporty = request.getParameter("proporty");
                roomList=connectHotelDAO.roomsFindByProporty(proporty);
            } else if (searchCategory.equals("direction")) {
                String direction = request.getParameter("direction");
                roomList = connectHotelDAO.roomsFindByDirection(direction);
            }else{
                roomList=connectHotelDAO.allRoom();
            }
        }
        request.setAttribute("roomList",roomList);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("searchAllRooms.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
