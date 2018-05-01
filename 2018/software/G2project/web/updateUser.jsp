<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Users"%>
<% Users user = (Users) request.getAttribute("user");%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/Stylesheet.css"/>
        <title>Update Users</title>
    </head>
    <body>
        <div class="wrap"> <!--div to hold all other divs -->
            
            <%@ include file="includes/menu.jsp"   %>
            <div class ="main">
                <h1>Update Category</h1>
                <hr>
                <form name="updateUser" action="updateUsers" method="get">
                    <table>
                        <tbody>
                            <tr>
                                <td>Email:</td>
                                <td><input type="text" name="email" value="<%= user.getEmail()%>" readonly="" /></td> 
                            </tr>
                            <tr>
                                <td>Password:</td>
                                <td><input type="text" name="passwd" value="<%= user.getPasswd()%>" /></td> 
                            </tr>
                            <tr>
                                <td>First Name:</td>
                                <td><input type="text" name="firstname" value="<%= user.getFirstname()%>" /></td> 
                            </tr>
                            <tr>
                                <td>Last Name:</td>
                                <td><input type="text" name="lastname" value="<%= user.getLastname()%>" /></td> 
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="reset" value="clear" id="clear">
                                    <input type="submit" name="submit" value="update" />
                                    <form name="user" action="readUser.jsp" method="post">
                                        <a href="readUser"> Cancel </a>
                                </td> 
                            </tr>
                        </tbody>
                    </table>
                </form>
            </div>
                <footer>
        <div class="container">
            <div class="row">
                <div class="col-lg-12">
                
                    <p class="copyright text-muted small">Copyright 2018 MSCI 3300. All Rights Reserved</p>
                </div>
            </div>
        </div>
    </footer>

        </div>
    </body>
</html>