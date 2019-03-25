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
import model.UserAccount;
import model.UserAccountFacade;
import model.UserMoney;
import model.UserMoneyFacade;

/**
 *
 * @author George
 */
@WebServlet(name = "Register", urlPatterns = {"/Register"})
public class Register extends HttpServlet {

    @EJB
    private UserMoneyFacade userMoneyFacade;

    @EJB
    private UserAccountFacade userAccountFacade;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
        String username=request.getParameter("userName"); 
        String password = request.getParameter("password");
        String name = request.getParameter("name");
        int ic = Integer.parseInt(request.getParameter("ic"));
        char gender =  request.getParameter("gender").charAt(0);
        int phone = Integer.parseInt(request.getParameter("phone"));
        String email=request.getParameter("email");
        String address = request.getParameter("address");  
        double balance = Double.parseDouble(request.getParameter("balance"));
       
        UserMoney m = new UserMoney();
        m.setBalance(balance);
        userMoneyFacade.create(m);
        
        char status = 'p';
        
        UserAccount a = new UserAccount(username,password,name,ic,gender,phone,email,address,status,m);
        userAccountFacade.create(a);
        
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.print("Registration done. Login to proceed!<br><br>");  
            request.getRequestDispatcher("login.jsp").include(request, response);
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
