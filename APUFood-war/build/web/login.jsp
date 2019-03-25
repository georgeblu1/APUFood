<%-- 
    Document   : newjsp
    Created on : Mar 22, 2019, 11:40:05 AM
    Author     : George
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <!-- Required meta tags -->
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

        <!-- Bootstrap CSS -->
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <!-- Favicon -->
        <link href="/assets/img/brand/favicon.png" rel="icon" type="image/png">

        <!-- Fonts -->
        <link href="https://fonts.googleapis.com/css?family=Open+Sans:300,400,600,700" rel="stylesheet">

        <!-- Icons -->
        <link href="/assets/vendor/nucleo/css/nucleo.css" rel="stylesheet">
        <link href="/assets/vendor/font-awesome/css/font-awesome.min.css" rel="stylesheet">

        <!-- Argon CSS -->
        <link type="text/css" href="/assets/css/argon.css" rel="stylesheet">
        
        <title>Hello, world!</title>
    </head>
    <body>
        <div class="jumbotron">
            <h1 class="display-4">APU Food Delivery!</h1>
            <p class="lead">Providing You with the fastest food delivery service in the region.</p>
            <hr class="my-4">
            <p>Login to start ordering or register as a new user!</p>
            <a class="btn btn-primary btn-lg" href="register.jsp" role="button">Register</a>
        </div>
        <form action="Login" method = "POST"  style="margin: 3em">
            <div class="form-group" >
                <label for="username">Username</label>
                <input type="text" class="form-control"  name="a" aria-describedby="emailHelp" placeholder="Enter Username" autofocus>
            </div>
            <div class="form-group">
                <label for="password">Password</label>
                <input type="password" class="form-control" name ="password" placeholder="Password">
            </div>
            <input class="btn btn-primary" type="submit" value="Submit">
        </form>

        <!-- Optional JavaScript -->
        <!-- jQuery first, then Popper.js, then Bootstrap JS -->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>
        <script src="/assets/vendor/jquery/jquery.min.js"></script>
        <script src="/assets/vendor/popper/popper.min.js"></script>
        <script src="/assets/vendor/bootstrap/bootstrap.min.js"></script>

        <!-- Optional plugins -->
        <script src="/assets/vendor/PLUGIN_FOLDER/PLUGIN_SCRIPT.js"></script>

        <!-- Theme JS -->
        <script src="/assets/js/argon.js"></script>
    </body>
</html>