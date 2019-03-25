<%-- 
    Document   : searchdeliverystaff
    Created on : Mar 22, 2019, 12:02:32 AM
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
        <form action="OccupiedReservation" method="POST">
            <table>
                <tr>
                    <td>
                        Staff ID:
                    </td> 
                    <td>
                        <input type="text" name="a" size="20">
                    </td>
                </tr>
            </table>
            <p>
                <input type="submit" value="Assign" name="assign">
                <input type="submit" value="Available" name="available">
            </p>
        </form>
    </body>
</html>
