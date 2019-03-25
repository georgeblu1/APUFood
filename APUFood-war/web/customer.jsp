<%-- 
    Document   : customer
    Created on : Mar 17, 2019, 10:04:01 PM
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
            <form action ="Customer" method ="POST">
                <p>
                    <input type="submit" value ="View Customer">
                </p>
            </form>
      <form action ="EditCustomer" method ="POST">
          <p>
            <input type="submit" value="Edit/Delete Customer">
          </p>
       </form>
 
    </body>
</html>
