<%-- 
    Document   : editfood
    Created on : Mar 16, 2019, 12:09:45 PM
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
        <form action="EditFood2" method="POST">
            <table>
                <tr>
                    <td>
                        Food ID:
                    </td> 
                    <td>
                        <input type="text" name="a" size="20">
                    </td>
                </tr>
            </table>
                <input type="submit" value="Edit" name="edit">
                <input type="submit" value="Delete" name="delete">
        </form>
    </body>
</html>
