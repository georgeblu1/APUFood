<%-- 
    Document   : orderfood
    Created on : Mar 16, 2019, 5:46:55 PM
    Author     : George
--%>

<%@page import="model.FoodDetails"%>
<%@page import="java.util.Arrays"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.Iterator"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
        <script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
        <script>
                $(function () {
                    $("#datepicker").datepicker();
                });
            </script>
    </head>
    <body>
        <form action="OrderFood2" method="POST">
            <table>
                <tr>
                    <td>
                        Food ID:
                    </td> 
                    <td>
                        <input type="text" name="a" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Quantity:
                    </td> 
                    <td>
                        <input type="text" name="b" size="20">
                    </td>
                </tr>
            </table>
            <input type="submit" value="Add" name="add">
            <input type="text" id="datepicker" name ="date">
    </form>
</body>
</html>
