<%-- 
    Document   : addFood
    Created on : Mar 16, 2019, 12:31:20 AM
    Author     : George
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Food</title>
    </head>
    <body>
        <form method="POST" action="AddFood">
            <table border="1" width = "50%">
                <tr>
                    <th>Food ID</th>
                    <td><input type="text" name="foodid" ></td>
                </tr>
                <tr> 
                    <th>Food Name</th>
                    <td><input type="text" name="foodname"></td>
                </tr>
                <tr>
                    <th>Food Price</th>
                    <td><input type="text" name="foodprice"></td>
                </tr>
                <tr>
                    <tr>
                    <th>Food Quantity</th>
                    <td><input type="text" name="foodquantity"></td>
                </tr>
                <tr>
                    <th>Food Description</th>
                    <td><input type="text" name="fooddesc"></td>
                </tr>
                <tr>
                    <th>Food Type</th>
                    <td>
                        <input type="radio" name="foodtype" value="f"> Foods
                        <input type="radio" name="foodtype" value="d"> Drinks<br>
                    </td>
                </tr>
            </table>
            <input type="submit" name="Submit" value="Update" style="background-color:#49743D;font-weight:bold;color:#ffffff;">
        </form>
    </body>
</html>
