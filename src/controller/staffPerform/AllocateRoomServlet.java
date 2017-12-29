package controller.staffPerform;

import DAO.ConnectHotelDAO;
import model.Indent;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AllocateRoomServlet")
public class AllocateRoomServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String allocatedRoom=request.getParameter("allocateRoom");
        Indent indent= (Indent) request.getSession().getAttribute("indent");
        request.getSession().removeAttribute("indent");
        request.getSession().removeAttribute("proportyRooms");
        ConnectHotelDAO connectHotelDAO=new ConnectHotelDAO();
        connectHotelDAO.checkIn(allocatedRoom,indent.getCheckOutTime());
        connectHotelDAO=new ConnectHotelDAO();
        connectHotelDAO.finishIndent(indent.getIndentNumber());
        response.sendRedirect("searchAllRooms.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
