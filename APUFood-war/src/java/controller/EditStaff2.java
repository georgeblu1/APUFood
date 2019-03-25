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

/**
 *
 * @author George
 */
@WebServlet(name = "EditStaff2", urlPatterns = {"/EditStaff2"})
public class EditStaff2 extends HttpServlet {

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
        request.getRequestDispatcher("admin.jsp").include(request, response);
        
        String name=request.getParameter("a");
        StaffDetails s = staffDetailsFacade.SearchID(name);
        StaffDetails x = staffDetailsFacade.find(name);
        
        try (PrintWriter out = response.getWriter()) {
            if(s == null){
                out.print("Sorry, Staff ID not found!<br><br>");  
                request.getRequestDispatcher("EditStaff").forward(request, response);

        }
            else{
                if(request.getParameter("edit") != null){
                    
                    HttpSession session=request.getSession();  
                    session.setAttribute("staff",s); 
                    request.getRequestDispatcher("editstaff.jsp").forward(request, response);
                    
                }
                else if (request.getParameter("delete") != null){
                staffDetailsFacade.remove(x);
                out.println("Staff deleted!");
                request.getRequestDispatcher("EditStaff").forward(request, response);
                
                }
                
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
