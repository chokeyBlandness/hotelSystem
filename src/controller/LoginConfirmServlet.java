package controller;

import DAO.ConnectHotelDAO;
import model.Administor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "LoginConfirmServlet")
public class LoginConfirmServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account=request.getParameter("account");
        String passowrd=request.getParameter("password");
        String loginMessage="";
        ConnectHotelDAO connectHotelDAO=new ConnectHotelDAO();
        Administor administor=connectHotelDAO.administorFindByAccount(account);
        if (administor==null){//do not find account
            loginMessage="do not have this account";
        }else {
            if (administor.getAdministorPassword().equals(passowrd)){//login success
                request.getSession().setAttribute("account",administor.getAdministorAccount());
                if (administor.getAdministorlevel().equals("manager")||
                        administor.getAdministorlevel().equals("staff")){
                    response.sendRedirect("secondLogin.jsp");
                    return;
                }//to second login
                else {
                    String accountLevel="normal";
                    request.getSession().setAttribute("accountLevel",accountLevel);
                    response.sendRedirect("findUsefulRoomsByTime.jsp");
                    return;
                }//to administor performance
            }else {
                loginMessage="wrong password!";
            }
        }
        request.setAttribute("loginMessage",loginMessage);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("login.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
