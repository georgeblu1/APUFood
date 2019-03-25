/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;

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
import model.UserAccountFacade;

/**
 *
 * @author George
 */
@WebServlet(name = "OrderFood2", urlPatterns = {"/OrderFood2"})
public class OrderFood2 extends HttpServlet {

   
    @EJB
    private UserAccountFacade userAccountFacade;

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
        request.getRequestDispatcher("home.jsp").include(request, response);
        HttpSession session=request.getSession(false);  
        
            HttpSession hs = request.getSession(false);
            UserAccount a = (UserAccount)hs.getAttribute("user");
            String foodid=request.getParameter("a"); 
            int foodquantity = Integer.parseInt(request.getParameter("b"));
            String deliverydate = request.getParameter("date"); 
            String status = "pending";
            char deliverystatus = 'p';
            FoodDetails x = foodDetailsFacade.find(foodid);
            UserAccount y = userAccountFacade.SearchID(a.getId());
            
            
            TempFoodOrder tempfood = tempFoodOrderFacade.SearchID(a.getId());
            
            if(tempfood != null){
                tempfood.getFoodid().add(foodid);
                tempfood.setQuantity(foodquantity + tempfood.getQuantity());
                tempfood.setPrice((x.getPrice() * foodquantity) + tempfood.getPrice());
                tempFoodOrderFacade.edit(tempfood);
                request.getRequestDispatcher("ViewTempOrder").forward(request, response);
            }
            else if(tempfood == null){
                TempFoodOrder tp = new TempFoodOrder(foodid);
                tp.setUserid(a.getId());
                tp.setOrderdatetime(deliverydate);
                tp.setQuantity(foodquantity);
                tp.setStatus(status);
                tp.setPrice(x.getPrice());
                tp.setAddress(a.getAddress());
                tp.setDeliverystatus(deliverystatus);
                tempFoodOrderFacade.create(tp); 
                
                  request.getRequestDispatcher("ViewTempOrder").forward(request, response);
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
