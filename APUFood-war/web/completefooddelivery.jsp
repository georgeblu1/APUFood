<%-- 
    Document   : completefooddelivery
    Created on : Mar 24, 2019, 8:28:23 PM
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
        <form action="Complete1" method="POST">
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
                        Rating:
                    </td> 
                    <td>
                        <input type="text" name="b" size="20" placeholder="1-5">
                    </td>
                </tr>
            </table>
                <input type="submit" value="Complete" name="complete">
        </form>
    </body>
</html>
