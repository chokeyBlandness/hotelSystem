package controller.managerPerform;

import DAO.ConnectHotelDAO;
import model.Administor;
import model.Staff;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AddNewStaffServlet")
public class AddNewStaffServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String staffId=request.getParameter("staffId");

        ConnectHotelDAO connectHotelDAO=new ConnectHotelDAO();
        Staff foundStaff = connectHotelDAO.staffFindById(staffId);
        if (foundStaff!=null){
            String addStaffMessage="exist staff!";
            request.setAttribute("addStaffMessage",addStaffMessage);
            RequestDispatcher requestDispatcher = request.getRequestDispatcher("addNewStaff.jsp");
            requestDispatcher.forward(request,response);
            return;
        }

        String staffPassword=request.getParameter("staffPassword");
        String staffName=request.getParameter("staffName");
        String staffIdentification=request.getParameter("staffIdentification");
        if (staffId==null||staffPassword==null||staffName==null||staffIdentification==null){
            System.out.println("submit error");
            response.sendRedirect("addNewStaff.jsp");
            return;
        }
        Staff newStaff=new Staff();
        newStaff.setStaffId(staffId);
        newStaff.setStaffPassword(staffPassword);
        newStaff.setStaffName(staffName);
        newStaff.setStaffPosition("staff");

        Administor staffAdministor=new Administor();
        staffAdministor.setAdministorAccount(newStaff.getStaffId());
        staffAdministor.setAdministorPassword(newStaff.getStaffId());
        staffAdministor.setUsername(newStaff.getStaffName());
        staffAdministor.setAdministorlevel("staff");
        staffAdministor.setPersonalIdentification(staffIdentification);

        connectHotelDAO.insertNewStaff(newStaff);
        connectHotelDAO.insertNewNormalAdministor(staffAdministor);
        response.sendRedirect("successRefresh.html");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
