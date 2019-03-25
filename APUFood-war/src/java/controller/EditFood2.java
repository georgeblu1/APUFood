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
import model.FoodDetails;
import model.FoodDetailsFacade;

/**
 *
 * @author George
 */
@WebServlet(name = "EditFood2", urlPatterns = {"/EditFood2"})
public class EditFood2 extends HttpServlet {

    @EJB
    private FoodDetailsFacade foodDetailsFacade;

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
        FoodDetails s = foodDetailsFacade.SearchID(name);
        FoodDetails x = foodDetailsFacade.find(name);
        
        try (PrintWriter out = response.getWriter()) {
            if(s == null){
                out.print("Sorry, Food ID not found!<br><br>");  
                request.getRequestDispatcher("EditFood").forward(request, response);

        }
            else{
                if(request.getParameter("edit") != null){
                    
                    HttpSession session=request.getSession();  
                    session.setAttribute("food",s); 
                    request.getRequestDispatcher("editfood.jsp").forward(request, response);
                    
                }
                else if (request.getParameter("delete") != null){
                foodDetailsFacade.remove(x);
                out.println("Food deleted!");
                request.getRequestDispatcher("EditFood").forward(request, response);
                
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
