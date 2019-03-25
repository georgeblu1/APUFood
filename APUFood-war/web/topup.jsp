<%-- 
    Document   : topup
    Created on : Mar 16, 2019, 3:10:42 PM
    Author     : George
--%>

<%@page import="model.UserMoney"%>
<%@page import="java.util.List"%>
<%@page import="model.UserAccount"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
            HttpSession hs = request.getSession(false);
            UserAccount s = (UserAccount)hs.getAttribute("user");
        %>
        <p>
            <jsp:include page="home.jsp"></jsp:include>
            </p>
            <form action="Topup" method="POST">

                <tr>
                    <%
                        List<UserMoney> money = s.getMoney();
                        for (int i = 0; i < money.size(); i++) {
                            UserMoney a = money.get(i);
                            out.print("<br>");
                            out.print("<h2> Your current balance: " + a.getBalance() +"</h2>");
                            out.print("<br><br>");
                        }
                    %>
            </tr>
            <tr> 
                Insert Amount: <input type="text" name="money" size="20">
            <p>
                <input type="submit" value="Top Up">
            </p>
            </tr>
        </form>
    </body>
</html>
