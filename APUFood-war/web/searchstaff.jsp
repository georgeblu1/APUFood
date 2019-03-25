<%-- 
    Document   : searchstaff
    Created on : Mar 17, 2019, 5:18:03 PM
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
        <form action="EditStaff2" method="POST">
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
                <input type="submit" value="Edit" name="edit">
                <input type="submit" value="Delete" name="delete">
            </p>
        </form>
    </body>
</html>
