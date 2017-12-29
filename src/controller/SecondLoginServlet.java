package controller;

import DAO.ConnectHotelDAO;
import model.Staff;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SecondLoginServlet")
public class SecondLoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account= (String) request.getSession().getAttribute("account");
        if (account==null){
            response.sendRedirect("login.jsp");
            return;
        }
        String secondPassword=request.getParameter("secondPassword");
        if (secondPassword==null){
            System.out.println("submit error");
            response.sendRedirect("secondLogin.jsp");
            return;
        }
        ConnectHotelDAO connectHotelDAO=new ConnectHotelDAO();
        Staff foundStaff=connectHotelDAO.staffFindById(account);
        if (foundStaff==null){
            response.sendRedirect("login.jsp");
            return;
        }else {
            String secondLoginMessage="";
            String accountLevel="";
            if (foundStaff.getStaffPassword().equals(secondPassword)){
                if (foundStaff.getStaffPosition().equals("staff")){
                    accountLevel="staff";
                    request.getSession().setAttribute("accountLevel",accountLevel);
                    response.sendRedirect("index.jsp");
                    return;
                }//to starff performance
                else if (foundStaff.getStaffPosition().equals("manager")){
                    accountLevel="manager";
                    request.getSession().setAttribute("accountLevel",accountLevel);
                    response.sendRedirect("index.jsp");
                    return;
                }//to manager performance
                else{
                    response.sendRedirect("searchAllRooms.jsp");
                    return;
                }//to ...
            }else {
                secondLoginMessage="wrong second password!";
                RequestDispatcher requestDispatcher=request.getRequestDispatcher("secondLogin.jsp");
                request.setAttribute("secondLoginMessage",secondLoginMessage);
                requestDispatcher.forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
