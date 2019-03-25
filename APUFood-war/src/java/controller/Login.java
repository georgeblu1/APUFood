/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
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
import model.UserAccountFacade;
import model.UserMoney;

/**
 *
 * @author George
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    @EJB
    private StaffDetailsFacade staffDetailsFacade;
    @EJB
    private UserAccountFacade userAccountFacade;
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String name=request.getParameter("a");  
        String password=request.getParameter("password");
        UserAccount s = userAccountFacade.find(name);
        StaffDetails a = staffDetailsFacade.find(name);
       
        try (PrintWriter out = response.getWriter()) {
            
            /* TODO output your page here. You may use following sample code. */
            if(s !=null || name.equals("admin") || a !=null){
                if(s!=null && s.getPassword().equals(password)){
                    request.getRequestDispatcher("home.jsp").include(request, response);
                    out.print("<br><br>");
                    if(s.getGender()=='m'){
                        out.print("Welcome Mr. "+s.getName()+"!");
                    }
                    else
                        out.print("Welcome Ms. "+s.getName()+"!");
                    HttpSession session=request.getSession();  
                    session.setAttribute("user",s);        
                    
                    request.getRequestDispatcher("Home").forward(request, response);
                    
                } if(name.equals("admin") && password.equals("12345")){
                    request.getRequestDispatcher("admin.jsp").forward(request, response);
                } 
                else if(a !=null && a.getPassword().equals(password)){
                    if(a.getRole() == 'd'){
                        out.print("Welcome Mr. "+a.getStaffname()+"!");
                        request.getRequestDispatcher("deliveryman.jsp").forward(request, response);
                        HttpSession session=request.getSession();  
                        session.setAttribute("delivery",a);  
                    }
                    else if(a.getRole() == 'r'){
                        out.print("Welcome Mr. "+a.getStaffname()+"!");
                        request.getRequestDispatcher("reservationstaff.jsp").forward(request, response);
                        HttpSession session=request.getSession();  
                        session.setAttribute("reservation",a);  
                    }
                }
            } else{
                out.print("Sorry, wrong username!<br><br>");  
                request.getRequestDispatcher("login.jsp").include(request, response);
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
