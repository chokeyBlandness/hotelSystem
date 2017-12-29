package controller.staffPerform;

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

@WebServlet(name = "SearchProportyRoomsServlet")
public class SearchProportyRoomsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<Room> proportyRooms= (ArrayList<Room>) request.getSession().getAttribute("proportyRooms");
        if (proportyRooms==null){
            proportyRooms=new ArrayList<Room>();
        }
        ArrayList<Room> roomList=new ArrayList<Room>();
        String searchCategory=request.getParameter("searchCategory");
        if (searchCategory==null){
            roomList=proportyRooms;
        }
        else if (searchCategory.equals("floor")){
            int floor = Integer.parseInt(request.getParameter("floor"));
            for (Room room:proportyRooms){
                if (room.getRoomFloor()==floor){
                    roomList.add(room);
                }
            }
        }else if (searchCategory.equals("direction")){
            String direction = request.getParameter("direction");
            for (Room room:proportyRooms){
                if (room.getRoomDirection().equals(direction)){
                    roomList.add(room);
                }
            }
        }else {
            roomList=proportyRooms;
        }
        request.setAttribute("roomList",roomList);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("allocateRoom.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
