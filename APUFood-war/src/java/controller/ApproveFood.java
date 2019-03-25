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
import model.StaffDetails;
import model.StaffDetailsFacade;
import model.TempFoodOrder;
import model.TempFoodOrderFacade;

/**
 *
 * @author George
 */
@WebServlet(name = "ApproveFood", urlPatterns = {"/ApproveFood"})
public class ApproveFood extends HttpServlet {

    @EJB
    private StaffDetailsFacade staffDetailsFacade;

    @EJB
    private TempFoodOrderFacade tempFoodOrderFacade;
    

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
        
        
        Long foodorder = Long.parseLong(request.getParameter("a"));
        
        String staff = request.getParameter("b");
        
        TempFoodOrder order = tempFoodOrderFacade.find(foodorder);
        
        StaffDetails delivery = staffDetailsFacade.SearchID(staff);
        
        
        
        if(request.getParameter("approve") != null){
        order.setStatus("Approved");
        order.setDeliveryman(delivery.getId());
        delivery.setStaffstatus("Occupied");
        tempFoodOrderFacade.edit(order);
        staffDetailsFacade.edit(delivery);
        try (PrintWriter out = response.getWriter()) {
            out.println(order.getId() + " Approved!");
            request.getRequestDispatcher("ViewAllOrders").forward(request, response);
        }
        }
        else if (request.getParameter("delete") != null){
            tempFoodOrderFacade.remove(order);
            try (PrintWriter out = response.getWriter()) {
            out.println("Order Removed!");
            request.getRequestDispatcher("ViewAllOrders").forward(request, response);
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
