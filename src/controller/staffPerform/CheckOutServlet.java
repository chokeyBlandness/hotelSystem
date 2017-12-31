package controller.staffPerform;

import DAO.ConnectHotelDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CheckOutServlet")
public class CheckOutServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String roomId=request.getParameter("checkOutRoomId");
        ConnectHotelDAO connectHotelDAO=new ConnectHotelDAO();
        connectHotelDAO.checkOut(roomId);
        response.sendRedirect("successRefresh.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
