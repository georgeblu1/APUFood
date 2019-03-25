/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.FoodDetails;
import model.FoodDetailsFacade;
import model.TempFoodOrder;
import model.TempFoodOrderFacade;
import model.UserAccount;

/**
 *
 * @author George
 */
@WebServlet(name = "OrderFood", urlPatterns = {"/OrderFood"})
public class OrderFood extends HttpServlet {

    @EJB
    private TempFoodOrderFacade tempFoodOrderFacade;

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
        
        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("home.jsp").include(request, response);
            request.getRequestDispatcher("orderfood.jsp").include(request, response);
            out.println("<h2>Food Menu</h2>");
            out.println("        <table border=\"1\" width=\"100%\">\n"
                    + "            <tr>\n"
                    + "                <th>ID</th>\n"
                    + "                <th>Name</th>\n"
                    + "                <th>Price</th>\n"
                    + "                <th>Description</th>\n"
                    + "                <th>Food Type</th>\n"
                    + "            </tr>\n");

            List allFood = foodDetailsFacade.findAll();
            
            for (Iterator it = allFood.iterator(); it.hasNext();) {
                FoodDetails food = (FoodDetails) it.next();
                out.println("                <tr>\n"
                        + "                    <td>" + food.getId() + "</td>\n"
                        + "                    <td>" + food.getFoodname() + "</td>\n"
                        + "                    <td>" + food.getPrice() + "</td>\n"
                        + "                    <td>" + food.getDescription() + "</td>\n"
                        + "                    <td>" + food.getFoodtype() + "</td>\n"
                        + "                </tr>\n");            }
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
