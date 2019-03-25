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
import javax.persistence.Query;
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
import model.UserAccountFacade;

/**
 *
 * @author George
 */
@WebServlet(name = "ViewTempOrder", urlPatterns = {"/ViewTempOrder"})
public class ViewTempOrder extends HttpServlet {

    @EJB
    private FoodDetailsFacade foodDetailsFacade;

    @EJB
    private TempFoodOrderFacade tempFoodOrderFacade;

    @EJB
    private UserAccountFacade userAccountFacade;
    
    

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
        request.getRequestDispatcher("home.jsp").include(request, response);
        try (PrintWriter out = response.getWriter()) {
            HttpSession hs = request.getSession(false);
            UserAccount a = (UserAccount)hs.getAttribute("user");
            UserAccount y = userAccountFacade.SearchID(a.getId());
            out.println("<h2>Cart</h2>");
            out.println("        <table border=\"1\" width=\"100%\">\n"
                    + "            <tr>\n"
                    + "                <th>ID</th>\n"
                    + "                <th>Food ID</th>\n"
                    + "                <th>Price</th>\n"
                    + "                <th>Quantity</th>\n"
                    + "                <th>Date</th>\n"
                    + "                <th>Address</th>\n"
                    + "                <th>Status</th>\n"
                    + "            </tr>\n");
                    
            //List allOrder = tempFoodOrderFacade.findAll()
            
            List allOrder = tempFoodOrderFacade.findAll();
            
            int price = 0;
            for (Iterator it = allOrder.iterator(); it.hasNext();) {
                TempFoodOrder tf = (TempFoodOrder) it.next();
                if(tf.getUserid().equals(a.getId())){
                out.println("                <tr>\n"
                         + "                    <td>" + tf.getId() + "</td>\n"
                                + "                    <td>" + tf.getFoodid() + "</td>\n"
                                + "                    <td>" + tf.getPrice() * tf.getQuantity()+ "</td>\n"
                                + "                    <td>" + tf.getQuantity() + "</td>\n"
                                + "                    <td>" + tf.getOrderdatetime() + "</td>\n"
                                        + "                    <td>" + tf.getAddress() + "</td>\n"
                                            + "                    <td>" + tf.getStatus() + "</td>\n"    
                        + "                </tr>\n");    
                price = price + (tf.getPrice() * tf.getQuantity());
                }
                
            }
            out.println("        </table> <br>");
            out.println("<h2>Final price: RM " + price + " </h2>");
//            for (Iterator it = allOrder.iterator(); it.hasNext();) {
//                TempFoodOrder userorder = new TempFoodOrder();
//                out.println("                <tr>\n"
//                + "                    <td>" + userorder.getId() + "</td>\n"
//                + "                    <td>" + userorder.getFoodid()+ "</td>\n"
//                + "                    <td>" + userorder.getPrice() + "</td>\n"
//                + "                    <td>" + userorder.getQuantity() + "</td>\n"
//                + "                    <td>" + userorder.getOrderdatetime()+ "</td>\n" 
//                + "                    <td>" + userorder.getAddress() + "</td>\n" );
//                            out.println("        </table> <br>");
//                }
                      }
    }
            
      
            
        
            
            
//            for (Iterator it = userorder.iterator(); it.hasNext();) {
//                FoodDetails userorder = (FoodDetails) it.next();
//                out.println("                <tr>\n"
//                        + "                    <td>" + userorder.getId() + "</td>\n"
//                        + "                    <td>" + userorder.getFoodname() + "</td>\n"
//                        + "                    <td>" + userorder.getPrice() + "</td>\n"
//                        + "                    <td>" + userorder.getDescription() + "</td>\n"
//                        + "                    <td>" + userorder.getFoodtype() + "</td>\n"
//                                + "                    <td>" + userorder.getQuantity() + "</td>\n"
//                        + "                </tr>\n");            }
            
        
    

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
