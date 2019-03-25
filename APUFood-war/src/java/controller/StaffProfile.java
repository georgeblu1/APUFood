/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.StaffDetails;
import model.UserAccount;

/**
 *
 * @author George
 */
@WebServlet(name = "StaffProfile", urlPatterns = {"/StaffProfile"})
public class StaffProfile extends HttpServlet {

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
            try (PrintWriter out = response.getWriter()) {
            out.println("<h2>Your Profile</h2>");
            out.println("        <table border=\"1\" width=\"50%\">\n" +
"            <tr>\n" +
"                <th>Login ID </th>" + 
                "<td>"+s.getId() +"</td>" +
             "</tr>"+ "<tr>"+
"                <th>Password</th>\n" +
                        
"                <td>"+s.getPassword()+"</td>" +
                     "</tr>"+ "<tr>"+

"                <th>Name</th>\n" +
"                <td>"+s.getStaffname()+"</td>" +
                     "</tr>"+ "<tr>"+

"                <th>Gender</th>\n" +
"                    <td>"+s.getGender()+"</td>" +
                     "</tr>"+ "<tr>"+

"                <th>Phone Number</th>\n" +
"                    <td>"+s.getPhone()+"</td>" +
                     "</tr>"+ "<tr>"+

"                <th>IC</th>\n" +
 "                <td>"+s.getIc()+"</td>" +       
                      "</tr>"+ "<tr>"+

"                <th>Email Address</th>\n" +
"                    <td>"+s.getEmail()+"</td>" +
                     "</tr>"+ "<tr>"+

"                <th>Address</th>\n" +  
"                    <td>"+s.getAddress()+"</td>" + 
                     "</tr>"+

"               </table> <br>" +
      "<a href=\"editreservationprofile.jsp\">Edit Profile</a> <br>" ); 
        }
            
            
        }else if(a != null){
            request.getRequestDispatcher("deliveryman.jsp").include(request, response);
            try (PrintWriter out = response.getWriter()) {
            out.println("<h2>Your Profile</h2>");
            out.println("        <table border=\"1\" width=\"50%\">\n" +
"            <tr>\n" +
"                <th>Login ID </th>" + 
                "<td>"+a.getId() +"</td>" +
             "</tr>"+ "<tr>"+
"                <th>Password</th>\n" +
                        
"                <td>"+a.getPassword()+"</td>" +
                     "</tr>"+ "<tr>"+

"                <th>Name</th>\n" +
"                <td>"+a.getStaffname()+"</td>" +
                     "</tr>"+ "<tr>"+

"                <th>Gender</th>\n" +
"                    <td>"+a.getGender()+"</td>" +
                     "</tr>"+ "<tr>"+

"                <th>Phone Number</th>\n" +
"                    <td>"+a.getPhone()+"</td>" +
                     "</tr>"+ "<tr>"+

"                <th>IC</th>\n" +
 "                <td>"+a.getIc()+"</td>" +       
                      "</tr>"+ "<tr>"+

"                <th>Email Address</th>\n" +
"                    <td>"+a.getEmail()+"</td>" +
                     "</tr>"+ "<tr>"+

"                <th>Address</th>\n" +  
"                    <td>"+a.getAddress()+"</td>" + 
                     "</tr>"+
"                <tr>\n" +

"                </tr>\n" +
"               </table> <br>" +
      "<a href=\"editdeliveryprofile.jsp\">Edit Profile</a> <br>" ); 
        }
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
