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
import model.FoodDetails;
import model.StaffDetails;
import model.StaffDetailsFacade;

/**
 *
 * @author George
 */
@WebServlet(name = "Staff", urlPatterns = {"/Staff"})
public class Staff extends HttpServlet {

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
        
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("admin.jsp").include(request, response);
            request.getRequestDispatcher("addStaff.jsp").include(request, response);
            //String id, String password, String staffname, char gender, int phone, String ic, String email, String address
            out.println("<h2>Staff Details</h2>");
            out.println("        <table border=\"1\" width=\"100%\">\n"
                    + "            <tr>\n"
                    + "                <th>ID</th>\n"
                    + "                <th>Password</th>\n"
                    + "                <th>Name</th>\n"
                    + "                <th>Gender</th>\n"
                    + "                <th>Phone</th>\n"
                    + "                <th>IC</th>\n"
                    + "                <th>Email</th>\n"
                    + "                <th>Address</th>\n"
                     + "                <th>Role</th>\n"
                    + "            </tr>\n");

            List allStaff = staffDetailsFacade.findAll();
            
            for (Iterator it = allStaff.iterator(); it.hasNext();) {
                StaffDetails staff = (StaffDetails) it.next();
                out.println("                <tr>\n" 
                        + "                    <td>" + staff.getId() + "</td>\n"
                        + "                    <td>" + staff.getPassword()+ "</td>\n"
                        + "                    <td>" + staff.getStaffname() + "</td>\n"
                        + "                    <td>" + staff.getGender() + "</td>\n"
                        + "                    <td>" + staff.getPhone() + "</td>\n"
                        + "                    <td>" + staff.getIc() + "</td>\n"
                        + "                    <td>" + staff.getEmail() + "</td>\n"
                        + "                    <td>" + staff.getAddress() + "</td>\n"
                        + "                    <td>" + staff.getRole()
                        + "</td>\n"); 
            }
            out.println("        </table> <br>");
            
        
        }
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
