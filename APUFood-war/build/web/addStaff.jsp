<%-- 
    Document   : addStaff
    Created on : Mar 17, 2019, 4:47:49 PM
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
        <!--//String id, String password, String staffname, char gender, int phone, String ic, String email, String address -->
        <form method="POST" action="AddStaff">
            <table border="1" width = "50%">
                <tr>
                    <th>ID</th>
                    <td><input type="text" name="staffid" ></td>
                </tr>
                <tr> 
                    <th>Password</th>
                    <td><input type="text" name="staffpassword"></td>
                </tr>
                <tr>
                    <th>Name</th>
                    <td><input type="text" name="staffname"></td>
                </tr>
                <tr>
                    <th>Gender</th>
                    <td>
                        <input type="radio" name="staffgender" value="m"> Male  
                        <input type="radio" name="staffgender" value=f"> Female<br>
                    </td>
                </tr>
                <tr>
                    <th>Phone</th>
                    <td>
                        <input type="text" name="staffphone" size="30"><br>
                    </td>
                </tr>
                <tr>
                    <th>
                        IC<br>
                    </th> 
                    <td>
                        <input type="text" name="staffic" size="30"><br>
                    </td>
                </tr>
                <tr>
                    <th>
                        Email<br>
                    </th> 
                    <td>
                        <input type="text" name="staffemail" size="30"><br>
                    </td>
                </tr>
                <tr>
                    <th>
                        Address<br>
                    </th> 
                    <td>
                        <input type="text" name="staffaddress" size="30"><br>
                    </td>
                </tr>
                <tr>
                    <th>Role</th>
                    <td>
                        <input type="radio" name="staffrole" value="r"> Reservation  
                        <input type="radio" name="staffrole" value="d"> Delivery
                    </td>
                </tr>
                <tr>
            </table>
            <input type="submit" name="Submit" value="Update" style="background-color:#49743D;font-weight:bold;color:#ffffff;">
        </form>
    </body>
</html>
