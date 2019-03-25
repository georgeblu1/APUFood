<%-- 
    Document   : foodapproval
    Created on : Mar 21, 2019, 7:47:49 PM
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
        <form action="ApproveFood" method="POST">
            <table>
                <tr>
                    <td>
                        ID:
                    </td> 
                    <td>
                        <input type="text" name="a" size="20">
                    </td>
                </tr>
                <tr>
                    <td>
                        Staff ID:
                    </td> 
                    <td>
                        <input type="text" name="b" size="20">
                    </td>
                </tr>
            </table>
                <input type="submit" value="Approve" name="approve">
                <input type="submit" value="Delete" name="delete">
        </form>
    </body>
</html>
