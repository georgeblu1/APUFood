<%-- 
    Document   : food
    Created on : Mar 16, 2019, 12:32:48 AM
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
            <form action ="ViewFood" method ="POST">
                <p>
                    <input type="submit" value ="View/Add Food">
                </p>
            </form>
        </form>
      <form action ="EditFood" method ="POST">
          <p>
            <input type="submit" value="Edit/Delete Food">
          </p>
       </form>
        
        <!--
        <button onclick="location.href='searchfood.jsp'">Edit Food2</button>
        -->
 
    </body>
</html>
