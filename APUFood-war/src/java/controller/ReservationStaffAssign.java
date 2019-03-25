/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.StaffDetails;
import model.StaffDetailsFacade;
import model.UserAccount;

/**
 *
 * @author George
 */
@WebServlet(name = "ReservationStaffAssign", urlPatterns = {"/ReservationStaffAssign"})
public class ReservationStaffAssign extends HttpServlet {

    @EJB
    private StaffDetailsFacade staffDetailsFacade;
    
    

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        HttpSession hs = request.getSession(false);
        StaffDetails s = (StaffDetails)hs.getAttribute("reservation");
        StaffDetails a = (StaffDetails)hs.getAttribute("delivery");
        
        if(s != null){
            request.getRequestDispatcher("reservationstaff.jsp").include(request, response);
        }else if(a != null){
            request.getRequestDispatcher("deliveryman.jsp").include(request, response);
        }
        else
            request.getRequestDispatcher("admin.jsp").include(request, response);
        
        
        try (PrintWriter out = response.getWriter()) {
            out.println("<h2>View Delivery Staff</h2>");
            request.getRequestDispatcher("searchdeliverystaff.jsp").include(request, response);
            //String id, String password, String staffname, char gender, int phone, String ic, String email, String address
            out.println("<h2>Available Staff</h2>");
            out.println("        <table border=\"1\" width=\"100%\">\n"
                    + "            <tr>\n"
                    + "                <th>ID</th>\n"
                    + "                <th>Name</th>\n"
                    + "                <th>Gender</th>\n"
                    + "                <th>Phone</th>\n"
                    + "                <th>Role</th>\n"
                    + "                <th>Availability</th>\n"
                    + "            </tr>\n");

            List allStaff = staffDetailsFacade.findAll();
            
            for (Iterator it = allStaff.iterator(); it.hasNext();) {
                StaffDetails staff = (StaffDetails) it.next();
                if(staff.getStaffstatus().equals("Available") && staff.getStaffrole() == 'd'){
                out.println("                <tr>\n" 
                         + "                    <td>" + staff.getId() + "</td>\n"
                        + "                    <td>" + staff.getStaffname() + "</td>\n"
                        + "                    <td>" + staff.getGender() + "</td>\n"
                        + "                    <td>" + staff.getPhone() + "</td>\n"
                        + "                    <td>" + staff.getRole()+ "</td>\n"
                        + "                    <td>" + staff.getStaffstatus()
                        + "</td>\n"); 
                }
            }
            out.println("        </table> <br>");
            
            
            out.println("<h2>Unavailable Staff</h2>");
            out.println("        <table border=\"1\" width=\"100%\">\n"
                    + "            <tr>\n"
                    + "                <th>ID</th>\n"
                    + "                <th>Name</th>\n"
                    + "                <th>Gender</th>\n"
                    + "                <th>Phone</th>\n"
                    + "                <th>Role</th>\n"
                    + "                <th>Availability</th>\n"
                    + "            </tr>\n");

            List allStaff1 = staffDetailsFacade.findAll();
            
            for (Iterator it = allStaff1.iterator(); it.hasNext();) {
                StaffDetails staff1 = (StaffDetails) it.next();
                if(staff1.getStaffstatus().equals("Occupied") && staff1.getStaffrole() == 'd'){
                out.println("                <tr>\n" 
                        + "                    <td>" + staff1.getId() + "</td>\n"
                        + "                    <td>" + staff1.getStaffname() + "</td>\n"
                        + "                    <td>" + staff1.getGender() + "</td>\n"
                        + "                    <td>" + staff1.getPhone() + "</td>\n"
                        + "                    <td>" + staff1.getRole()+ "</td>\n"
                        + "                    <td>" + staff1.getStaffstatus()
                        + "</td>\n"); 
                }
            }
            out.println("        </table> <br>");
        
        
        
    }}

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
