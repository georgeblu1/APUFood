/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import javax.ejb.EJB;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import model.UserAccount;
import model.UserAccountFacade;
import model.UserMoney;
import model.UserMoneyFacade;

/**
 *
 * @author George
 */
@WebServlet(name = "Topup", urlPatterns = {"/Topup"})
public class Topup extends HttpServlet {

    @EJB
    private UserAccountFacade userAccountFacade;

    @EJB
    private UserMoneyFacade userMoneyFacade;

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
        request.getRequestDispatcher("topup.jsp").include(request, response);
        double amount = Double.parseDouble(request.getParameter("money"));
        try (PrintWriter out = response.getWriter()) {
        HttpSession session = request.getSession(false);
        UserAccount s = (UserAccount) session.getAttribute("user");
        
        List<UserMoney> money = s.getMoney();
            for(int i=0; i<money.size(); i++){
                UserMoney a = money.get(i);
                double x = a.getBalance();
                a.setBalance(amount + x);
                userMoneyFacade.edit(a);
            }
            request.getRequestDispatcher("topup.jsp").forward(request, response);
        }

//        List<UserMoney> money = user.getMoney();
//                    for(int i=0; i<money.size(); i++){
//                        UserMoney a = money.get(i);
//                        double x = a.getBalance();
//            }
//                    
//           userMoneyFacade.edit(entity);
//        
//        studentFacade.edit(user);
//        try (PrintWriter out = response.getWriter()) {
//            /* TODO output your page here. You may use following sample code. */
//            out.print("Transaction done!<br><br>");  
//            request.getRequestDispatcher("student.jsp").include(request, response);
//            out.print("<br><br>");
//            out.print("Welcome "+user.getId()+"!"); 
//            out.print("<br>Your account balance is RM"+user.getBalance()+".");
//        }
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

