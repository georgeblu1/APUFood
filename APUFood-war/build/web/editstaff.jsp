<%-- 
    Document   : editstaff
    Created on : Mar 17, 2019, 5:38:16 PM
    Author     : George
--%>

<%@page import="model.StaffDetails"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form method="POST" action="UpdateStaff">
<table border="1" width = "50%">

<%
HttpSession hs = request.getSession(false);
StaffDetails s = (StaffDetails)hs.getAttribute("staff");
%>
<p>
<jsp:include page="admin.jsp"></jsp:include>
</p>
<tr>
    <th>Name</th>
    <td><input type="text" name="name" value="<%= s.getStaffname()%>"></td>
</tr>
<tr> 
    <th>Username</th>
    <td><input type="text" name="username" value="<%=s.getId()%>"></td>
</tr>
<tr>
    <th>Password</th>
    <td><input type="text" name="password" value="<%=s.getPassword()%>"></td>
</tr>
<tr>
    <th>IC</th>
    <td><input type="text" name="ic" value="<%=s.getIc()%>"></td>
</tr>
<tr>
    <th>Gender</th>
    <td><input type="text" name="gender" value="<%=s.getGender()%>"></td>
</tr>
<tr>
    <th>Phone Number</th>
    <td><input type="text" name="phone" value="<%=s.getPhone()%>"></td>
</tr>
<tr>
    <th>Email</th>
    <td><input type="text" name="email" value="<%=s.getEmail()%>"></td>
</tr>
<tr>
    <th>Address</th>
    <td><input type="text" name="address" value="<%=s.getAddress()%>"></td>
</tr>
<tr>
    <th>Role</th>
    <td><input type="text" name="role" value="<%=s.getRole()%>"></td>
</tr>
</table>
<input type="submit" name="Submit" value="Update" style="background-color:#49743D;font-weight:bold;color:#ffffff;">

</form>
    </body>
</html>
