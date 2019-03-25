<%-- 
    Document   : admin
    Created on : Mar 16, 2019, 12:28:58 AM
    Author     : George
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">

    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Home</title>
    </head>
    <body>
        <div class="jumbotron text-center">
            <h1>Admin Page!</h1>
        </div>

        <nav class="navbar navbar-dark bg-primary">
            <a class="navbar-brand" href="admin.jsp">Home</a>
            <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavAltMarkup" aria-controls="navbarNavAltMarkup" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNavAltMarkup">
                <div class="navbar-nav">
                    <a class="nav-item nav-link active" href="customer.jsp">Customer <span class="sr-only"></span></a>
                    <a class="nav-item nav-link" href="staff.jsp">Staff</a>
                    <a class="nav-item nav-link" href="ReservationStaffAssign">Assign Delivery</a>
                    <a class="nav-item nav-link" href="food.jsp">Food</a>
                    <a class="nav-item nav-link" href="ViewAllOrders">Orders</a>
                    <a class="nav-item nav-link" href="Report">Report</a>
                    <a class="nav-item nav-link" href="History">History</a>
                    <a class="nav-item nav-link" href="Logout">Logout</a>
                </div>
            </div>
        </nav>
<!--
            <a href="Home">Home</a> |
            <a href="Profile">Profile</a> |
            <a href="OrderFood">Reservation</a> |
            <a href="ViewTempOrder">Orders</a> |
            <a href="topup.jsp">Top Up</a> |
            <a href="Logout">History</a> |
            <a href="ratings.jsp">Ratings</a>|
            <a href="Logout">Logout</a> -->


            <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
            <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
            <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
    </body>
</html>
