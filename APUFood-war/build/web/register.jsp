<%-- 
    Document   : register
    Created on : Mar 13, 2019, 2:28:11 PM
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
        <title>Registration Page</title>
    </head>

    <body>
        <div class="jumbotron text-center">
            <h1>Register</h1>
        </div>

        <form action ="Register" method = "POST">
            <div class="form-row">
                <div class="form-group col-md-4">
                    <label for="username">Username</label>
                    <input type="username" class="form-control" name="userName" id="inputEmail4" >
                </div>
                <div class="form-group col-md-4">
                    <label for="inputPassword4">Password</label>
                    <input type="password" class="form-control" name="password"id="inputPassword4">
                </div>
            </div>
            <div class="form-group col-md-4">
                <label for="inputAddress">Name</label>
                <input type="text" class="form-control" name="name" id="inputAddress">
            </div>
            <div class="form-group col-md-4">
                <label for="inputAddress">IC</label>
                <input type="text" class="form-control" name="ic" id="inputAddress" >
            </div>
            <fieldset class="form-group">
                <div class="row">
                    <legend class="col-form-label col-sm-2 pt-0">Gender</legend>
                    <div class="col-sm-10">
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="gender" id="gridRadios1" value="m" checked>
                            <label class="form-check-label" for="gridRadios1">
                                Male
                            </label>
                        </div>
                        <div class="form-check">
                            <input class="form-check-input" type="radio" name="gender" id="gridRadios2" value="f">
                            <label class="form-check-label" for="gridRadios2">
                                Female
                            </label>
                        </div>
                    </div>
                </div>
            </fieldset>
            <div class="form-group col-md-4">
                <label for="inputAddress">Phone</label>
                <input type="text" class="form-control" name="phone" id="inputAddress">
            </div>
            <div class="form-group col-md-4">
                <label for="inputAddress">Email</label>
                <input type="email" class="form-control" name="email" id="inputAddress">
            </div>
            <div class="form-group col-md-4">
                <label for="inputAddress">Address</label>
                <input type="text" class="form-control" name="address" id="inputAddress" >
            </div>
            <div class="form-group col-md-4">
                <label for="inputAddress">Balance</label>
                <input type="text" class="form-control" name="balance" id="inputAddress" >
            </div>


            <input class="btn btn-primary" type="submit" value="Register">
        </form>
        <!--        <form action="Register" method="POST">
                    <table>
                        <tr>
                            <td>
                                Username:<br>
                            </td> 
                            <td>
                                <input type="text" name="userName" size="20"><br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Password:<br>
                            </td> 
                            <td>
                                <input type="text" name="password" size="20"><br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Name:<br>
                            </td> 
                            <td>
                                <input type="text" name="name" size="20"><br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                IC:<br>
                            </td> 
                            <td>
                                <input type="text" name="ic" size="30"><br>
                            </td>
                        </tr>
                         <tr>
                            <td>
                                Gender:<br>
                            </td> 
                            <td>
                                <input type="radio" name="gender" value="m"> Male
                                <input type="radio" name="gender" value="f"> Female<br>
                            </td>
                        </tr>
                         <tr>
                            <td>
                                Phone:<br>
                            </td> 
                            <td>
                                <input type="text" name="phone" size="30"><br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Email:<br>
                            </td> 
                            <td>
                                <input type="text" name="email" size="30"><br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Address:<br>
                            </td> 
                            <td>
                                <input type="text" name="address" size="30"><br>
                            </td>
                        </tr>
                        <tr>
                            <td>
                                Balance:<br>
                            </td> 
                            <td>
                                <input type="text" name="balance" size="30"><br>
                            </td>
                        </tr>
                    </table>
                    <p>
                        <input type="submit" value="Submit">
                    </p>
                </form>-->
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

    </body>
</html>
