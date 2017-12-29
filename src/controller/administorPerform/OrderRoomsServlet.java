package controller.administorPerform;

import DAO.ConnectHotelDAO;
import model.Indent;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "OrderRoomsServlet")
public class OrderRoomsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account= (String) request.getSession().getAttribute("account");
        if (account==null){
            response.sendRedirect("login.jsp");
            return;
        }
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yy-mm-dd");
        Date date=new Date();
        String checkInTimeString=request.getParameter("checkInTime");
        String checkOutTimeString=request.getParameter("checkOutTime");
        String roomProporty=request.getParameter("roomProporty");
        String person_1_identification=request.getParameter("person_1");
        String person_2_identification=request.getParameter("person_2");
        String person_3_identification=request.getParameter("person_3");

        long checkInTime=0;
        long checkOutTime=0;
        try {
            date=simpleDateFormat.parse(checkInTimeString);
            checkInTime=date.getTime();
            date=simpleDateFormat.parse(checkOutTimeString);
            checkOutTime=date.getTime();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Indent newIndent=new Indent();
        newIndent.setOrderAccount(account);
        newIndent.setRoomProporty(roomProporty);
        newIndent.setCheckInTime(checkInTime);
        newIndent.setCheckOutTime(checkOutTime);
        newIndent.setIndentStatus("undone");
        newIndent.setPerson_1(person_1_identification);
        newIndent.setPerson_2(person_2_identification);
        newIndent.setPerson_3(person_3_identification);
        ConnectHotelDAO connectHotelDAO=new ConnectHotelDAO();
        connectHotelDAO.insertNewIndent(newIndent);
        response.sendRedirect("indentList.jsp");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
