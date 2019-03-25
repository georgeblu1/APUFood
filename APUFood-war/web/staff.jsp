<%-- 
    Document   : staff
    Created on : Mar 17, 2019, 5:09:55 PM
    Author     : George
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
    <jsp:include page="admin.jsp"></jsp:include>
            <form action ="Staff" method ="POST">
                <p>
                    <input type="submit" value ="View/Add Staff">
                </p>
            </form>
      <form action ="EditStaff" method ="POST">
          <p>
            <input type="submit" value="Edit/Delete Staff">
          </p>
       </form>
        
        <!--
        <button onclick="location.href='searchfood.jsp'">Edit Food2</button>
        -->
 
    </body>
</html>
