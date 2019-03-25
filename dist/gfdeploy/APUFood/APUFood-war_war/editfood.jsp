<%-- 
    Document   : editfood
    Created on : Mar 16, 2019, 12:17:15 PM
    Author     : George
--%>

<%@page import="model.FoodDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="UpdateFood">
<table border="1" width = "50%">

<%
HttpSession hs = request.getSession(false);
FoodDetails s = (FoodDetails)hs.getAttribute("food");
%>
<p>
<jsp:include page="admin.jsp"></jsp:include>
</p>

<tr>
    <th>Food ID</th>
    <td><input type="text" name="foodid" value="<%=s.getId()%>"></td>
</tr>
<tr> 
    <th>Food Name</th>
    <td><input type="text" name="foodname" value="<%=s.getFoodname()%>"></td>
</tr>
<tr>
    <th>Food Price</th>
    <td><input type="text" name="foodprice" value="<%=s.getPrice()%>"></td>
</tr>
<tr>
    <th>Food Quantity</th>
    <td><input type="text" name="foodquantity" value="<%=s.getQuantity()%>"></td>
</tr>
<tr>
    <th>Food Description</th>
    <td><input type="text" name="fooddesc" value="<%=s.getDescription()%>"></td>
</tr>
<tr>
    <th>Food Type</th>
    <td><input type="text" name="foodtype" value="<%=s.getFoodtype()%>"></td>
</tr>
</table>
<input type="submit" name="Submit" value="Update" style="background-color:#49743D;font-weight:bold;color:#ffffff;">
</form>
    </body>
</html>
