package controller.managerPerform;

import DAO.ConnectHotelDAO;
import model.Administor;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DeleteAdministorServlet")
public class DeleteAdministorServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String deleteAccount=request.getParameter("deleteAccount");
        ConnectHotelDAO connectHotelDAO=new ConnectHotelDAO();
        Administor deleteAdministor=connectHotelDAO.administorFindByAccount(deleteAccount);
        String deleteMessage="";
        if (deleteAdministor==null){
            deleteMessage="no this account!";
        }else {
            if (!deleteAdministor.getAdministorlevel().equals("normal")){
                deleteMessage="not normal account!cannot delete!";
            }else {
                connectHotelDAO=new ConnectHotelDAO();
                connectHotelDAO.deleteNormalAdministorByAccount(deleteAccount);
                response.sendRedirect("successRefresh.html");
                return;
            }
        }
        request.setAttribute("deleteMessage",deleteMessage);
        RequestDispatcher requestDispatcher=request.getRequestDispatcher("deleteAdministor.jsp");
        requestDispatcher.forward(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
