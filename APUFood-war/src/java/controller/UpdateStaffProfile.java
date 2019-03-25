/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
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
@WebServlet(name = "UpdateStaffProfile", urlPatterns = {"/UpdateStaffProfile"})
public class UpdateStaffProfile extends HttpServlet {

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
             String name = request.getParameter("name");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
             String ic = request.getParameter("ic");
            char gender =  request.getParameter("gender").charAt(0);
            int phone = Integer.parseInt(request.getParameter("phone"));
            String email=request.getParameter("email");
            String address = request.getParameter("address");  


            try (PrintWriter out = response.getWriter()) {
                s.setStaffname(name);
                s.setId(username);
                s.setPassword(password);
                s.setIc(ic);
                s.setGender(gender);
                s.setPhone(phone);
                s.setEmail(email);
                s.setAddress(address);
                staffDetailsFacade.edit(s);
                out.println("Your User Profile has been updated!<br><br>");
                request.getRequestDispatcher("reservationstaff.jsp").forward(request, response);
            
        }}else if(a != null){
            request.getRequestDispatcher("deliveryman.jsp").include(request, response);
            String name = request.getParameter("name");
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            String ic = request.getParameter("ic");
            char gender =  request.getParameter("gender").charAt(0);
            int phone = Integer.parseInt(request.getParameter("phone"));
            String email=request.getParameter("email");
            String address = request.getParameter("address");  
            
            try (PrintWriter out = response.getWriter()) {
                a.setStaffname(name);
                a.setId(username);
                a.setPassword(password);
                a.setIc(ic);
                a.setGender(gender);
                a.setPhone(phone);
                a.setEmail(email);
                a.setAddress(address);
                staffDetailsFacade.edit(a);
                out.println("Your User Profile has been updated!<br><br>");
                request.getRequestDispatcher("deliveryman").forward(request, response);
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
