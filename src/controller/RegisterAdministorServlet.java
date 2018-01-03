package controller;

import DAO.ConnectHotelDAO;
import model.Administor;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "RegisterAdministorServlet")
public class RegisterAdministorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String account=request.getParameter("account");
        String password=request.getParameter("password");
        String username=request.getParameter("username");
        String identification=request.getParameter("identification");
        if (account==null||password==null||username==null||identification==null){
            System.out.println("submit error");
            response.sendRedirect("register.jsp");
            return;
        }
        Administor newAdministor=new Administor();
        newAdministor.setAdministorAccount(account);
        newAdministor.setAdministorPassword(password);
        newAdministor.setUsername(username);
        newAdministor.setAdministorlevel("normal");
        newAdministor.setPersonalIdentification(identification);

        ConnectHotelDAO connectHotelDAO=new ConnectHotelDAO();
        connectHotelDAO.insertNewNormalAdministor(newAdministor);
        connectHotelDAO.insertNewNormalAdministor(newAdministor);
        response.sendRedirect("successRefresh.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
