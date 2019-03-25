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
import model.StaffDetailsFacade;
import model.TempFoodOrder;
import model.UserAccount;
import model.UserAccountFacade;

/**
 *
 * @author George
 */
@WebServlet(name = "Report", urlPatterns = {"/Report"})
public class Report extends HttpServlet {

    @EJB
    private StaffDetailsFacade staffDetailsFacade;

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
        List male = userAccountFacade.searchByGender('m');
        List female = userAccountFacade.searchByGender('f');
        
        List smale = staffDetailsFacade.searchByGender('m');
        List sfemale = staffDetailsFacade.searchByGender('f');
        
        HttpSession session = request.getSession();
        
        int nmale = 0;
        int nfemale = 0;
        
        int nrmale = 0;
        int nrfemale = 0;
        
        int ndmale = 0;
        int ndfemale = 0;
        
        for (Iterator it = male.iterator(); it.hasNext();) {
            UserAccount tf = (UserAccount) it.next();
            nmale = nmale + 1;
        }
        session.setAttribute("nmale", nmale);
        
        for (Iterator it = female.iterator(); it.hasNext();) {
            UserAccount tf = (UserAccount) it.next();
            nfemale = nfemale + 1;
        }

        session.setAttribute("nfemale", nfemale);
        
        for (Iterator it = smale.iterator(); it.hasNext();) {
            StaffDetails tf = (StaffDetails) it.next();
            if(tf.getRole() == 'd'){
                ndmale = ndmale +1;
            }
            else if (tf.getRole() == 'r'){
                nrmale = nrmale +1;
            }
        }
        
        for (Iterator it = sfemale.iterator(); it.hasNext();) {
            StaffDetails tf = (StaffDetails) it.next();
            if(tf.getRole() == 'd'){
                ndfemale = ndfemale +1;
            }
            else if (tf.getRole() == 'r'){
                nrfemale = nrfemale +1;
            }
        }

        try (PrintWriter out = response.getWriter()) {
            request.getRequestDispatcher("admin.jsp").include(request, response);
            out.println("<head><meta charset=\"utf-8\">\n"
                    + "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1, shrink-to-fit=no\">\n"
                    + "\n"
                    + "    <!-- Bootstrap CSS -->\n"
                    + "    <link rel=\"stylesheet\" href=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css\" integrity=\"sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T\" crossorigin=\"anonymous\"> "
                    + " <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n"
                    + "    <script type=\"text/javascript\">\n"
                    + "      google.charts.load('current', {'packages':['bar']});\n"
                    + "      google.charts.setOnLoadCallback(drawChart);\n"
                    + "\n"
                    + "      function drawChart() {\n"
                    + "        var data = google.visualization.arrayToDataTable([\n"
                    + "          ['Gender', 'Reservation', 'Delivery'],\n"
                    + "          ['Male', " + nrmale + ", " + ndmale + "],\n"
                    + "          ['Female', " + nrfemale + ", " + ndfemale + "],\n"
                    + "        ]);\n"
                    + "\n"
                    + "        var options = {\n"
                    + "          chart: {\n"
                    + "            title: 'Male and Female Staff',\n"
                    + "          },\n"
                    + "          bars: 'horizontal' // Required for Material Bar Charts.\n"
                    + "        };\n"
                    + "\n"
                    + "        var chart = new google.charts.Bar(document.getElementById('barchart_material'));\n"
                    + "\n"
                    + "        chart.draw(data, google.charts.Bar.convertOptions(options));\n"
                    + "      }\n"
                    + "    </script>"
                    + "</head>"
                    + "<body>"
                    + "<div class=\"jumbotron jumbotron-fluid\">\n"
                    + "  <div class=\"container\">\n"
                    + "    <h1 class=\"display-4\">Charts</h1>\n"
                    + " <p class=\"lead\">The chart shows the number of male and female users</p>"
                    + "<div id=\"piechart\"></div>\n"
                    + "        <script type=\"text/javascript\" src=\"https://www.gstatic.com/charts/loader.js\"></script>\n"
                    + "        <script type=\"text/javascript\">\n"
                    + "// Load google charts\n"
                    + "            google.charts.load('current', {'packages': ['corechart']});\n"
                    + "            google.charts.setOnLoadCallback(drawChart);\n"
                    + "\n"
                    + "// Draw the chart and set the chart values\n"
                    + "            function drawChart() {\n"
                    + "                var data = google.visualization.arrayToDataTable([\n"
                    + "                    ['Task', 'Hours per Day'],\n"
                    + "                    ['Male', " + nmale + "],\n"
                    + "                    ['Female', " + nfemale + "],\n"
                    + "                ]);\n"
                    + "\n"
                    + "                // Optional; add a title and set the width and height of the chart\n"
                    + "                var options = {'title': 'Gender', 'width': 550, 'height': 400};\n"
                    + "\n"
                    + "                // Display the chart inside the <div> element with id=\"piechart\"\n"
                    + "                var chart = new google.visualization.PieChart(document.getElementById('piechart'));\n"
                    + "                chart.draw(data, options);\n"
                    + "            }\n"
                    + "        </script>"
                    + "  </div>\n"
                    + "</div>"
                    + "<div id=\"barchart_material\" style=\"width: 900px; height: 500px;\"></div>"
                    + "<script src=\"https://code.jquery.com/jquery-3.3.1.slim.min.js\" integrity=\"sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo\" crossorigin=\"anonymous\"></script>\n"
                    + "    <script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js\" integrity=\"sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1\" crossorigin=\"anonymous\"></script>\n"
                    + "    <script src=\"https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js\" integrity=\"sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM\" crossorigin=\"anonymous\"></script>\n"
                    + "</body>");
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
