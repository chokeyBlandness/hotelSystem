package controller.staffPerform;

import DAO.ConnectHotelDAO;
import model.Indent;
import model.Room;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "FindIndentByIdServlet")
public class FindIndentByIdServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String personId=request.getParameter("personId");
        ConnectHotelDAO connectHotelDAO=new ConnectHotelDAO();
        ArrayList<Indent> indents=connectHotelDAO.indentFindByIdentification(personId);
        request.setAttribute("indentList",indents);
        if (indents==null||indents.size()==0){
            response.sendRedirect("index.jsp");
            return;
        }
        Indent indent=indents.get(0);
        request.getSession().setAttribute("indent",indent);
        connectHotelDAO=new ConnectHotelDAO();
        ArrayList<Room> rooms=connectHotelDAO.roomsFindByProporty(indent.getRoomProporty());
        request.getSession().setAttribute("proportyRooms",rooms);
        request.setAttribute("roomList",rooms);
        RequestDispatcher requestDispatcher = request.getRequestDispatcher("allocateRoom.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
