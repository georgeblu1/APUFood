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
import model.StaffDetails;
import model.StaffDetailsFacade;

/**
 *
 * @author George
 */
@WebServlet(name = "OccupiedReservation", urlPatterns = {"/OccupiedReservation"})
public class OccupiedReservation extends HttpServlet {

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
        
        String staff = request.getParameter("a");
        
        StaffDetails reservation = staffDetailsFacade.SearchID(staff);
        if(request.getParameter("assign") != null){
        reservation.setStaffstatus("Occupied");
        staffDetailsFacade.edit(reservation);
        request.getRequestDispatcher("ReservationStaffAssign").forward(request, response);
        }
        else if(request.getParameter("available") != null){
            reservation.setStaffstatus("Available");
            staffDetailsFacade.edit(reservation);
            request.getRequestDispatcher("ReservationStaffAssign").forward(request, response);
        }
//        try (PrintWriter out = response.getWriter()) {
//            
//            //String id, String password, String staffname, char gender, int phone, String ic, String email, String address
//            out.println("<h2>Unavailable Staff</h2>");
//            out.println("        <table border=\"1\" width=\"100%\">\n"
//                    + "            <tr>\n"
//                    + "                <th>ID</th>\n"
//                    + "                <th>Name</th>\n"
//                    + "                <th>Gender</th>\n"
//                    + "                <th>Phone</th>\n"
//                    + "                <th>Role</th>\n"
//                    + "                <th>Availability</th>\n"
//                    + "            </tr>\n");
//
//            List allStaff = staffDetailsFacade.findAll();
//            
//            for (Iterator it = allStaff.iterator(); it.hasNext();) {
//                StaffDetails staff1 = (StaffDetails) it.next();
//                if(staff1.getStaffstatus().equals("Occupied") && staff1.getStaffrole() == 'd'){
//                out.println("                <tr>\n" 
//                        + "                    <td>" + staff1.getId() + "</td>\n"
//                        + "                    <td>" + staff1.getStaffname() + "</td>\n"
//                        + "                    <td>" + staff1.getGender() + "</td>\n"
//                        + "                    <td>" + staff1.getPhone() + "</td>\n"
//                        + "                    <td>" + staff1.getRole()+ "</td>\n"
//                        + "                    <td>" + staff1.getStaffstatus()
//                        + "</td>\n"); 
//                }
//            }
//            out.println("        </table> <br>");
//        
//        }
    }

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
