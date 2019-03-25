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
import model.TempFoodOrder;
import model.TempFoodOrderFacade;
import model.UserAccount;
import model.UserAccountFacade;

/**
 *
 * @author George
 */
@WebServlet(name = "Complete", urlPatterns = {"/Complete"})
public class Complete extends HttpServlet {

    @EJB
    private UserAccountFacade userAccountFacade;

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
        request.getRequestDispatcher("deliveryman.jsp").include(request, response);
        request.getRequestDispatcher("completefooddelivery.jsp").include(request, response);
        try (PrintWriter out = response.getWriter()) {
            
            out.println("<h2>All Orders</h2>");
            out.println("        <table border=\"1\" width=\"100%\">\n"
                    + "            <tr>\n"
                    + "                <th>ID</th>\n"
                    + "                <th>User ID</th>\n"
                    + "                <th>Name</th>\n"
                    + "                <th>Food ID</th>\n"
                    + "                <th>Price</th>\n"
                    + "                <th>Quantity</th>\n"
                    + "                <th>Order Date</th>\n"
                    + "                <th>Address</th>\n"
                    + "                <th>Status</th>\n"
                    + "                <th>Deliveryman</th>\n"
                    + "                <th>rating</th>\n"
                    + "            </tr>\n");

            List allOrder = tempFoodOrderFacade.findAll();
            
            for (Iterator it = allOrder.iterator(); it.hasNext();) {
                TempFoodOrder tf = (TempFoodOrder) it.next();
                UserAccount name = userAccountFacade.SearchID(tf.getUserid());
                        out.println("                <tr>\n"
                                
                                + "                    <td>" + tf.getId() + "</td>\n"
                                + "                    <td>" + tf.getUserid() + "</td>\n"
                                + "                    <td>" + name.getName() + "</td>\n"
                                + "                    <td>" + tf.getFoodid() + "</td>\n"  
                                + "                    <td>" + tf.getPrice() + "</td>\n"
                                + "                    <td>" + tf.getQuantity() + "</td>\n"
                                + "                    <td>" + tf.getOrderdatetime() + "</td>\n"
                                + "                    <td>" + tf.getAddress() + "</td>\n"
                                + "                    <td>" + tf.getStatus() + "</td>\n"
                                        + "                    <td>" + tf.getDeliveryman() + "</td>\n"
                                                + "                    <td>" + tf.getRating() + "</td>\n"
                        + "                </tr>\n");            }
//            out.println("        </table> <br>");
//            
//            out.println("<h2>Available Delivery Staff</h2>");
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
//                StaffDetails staff = (StaffDetails) it.next();
//                if(staff.getStaffstatus().equals("Available") && staff.getStaffrole() == 'd'){
//                out.println("                <tr>\n" 
//                         + "                    <td>" + staff.getId() + "</td>\n"
//                        + "                    <td>" + staff.getStaffname() + "</td>\n"
//                        + "                    <td>" + staff.getGender() + "</td>\n"
//                        + "                    <td>" + staff.getPhone() + "</td>\n"
//                        + "                    <td>" + staff.getRole()+ "</td>\n"
//                        + "                    <td>" + staff.getStaffstatus()
//                        + "</td>\n"); 
//                }
//            }
//            out.println("        </table> <br>");
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
