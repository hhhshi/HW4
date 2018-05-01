<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/Stylesheet.css"/>
        <title>Users</title>
    </head>
    <% String table=(String) request.getAttribute("user_table");%>
    <body>
        <div class="wrap"> <!--div to hold all other divs -->
            
            <%@ include file="includes/menu.jsp"   %>
                <div class ="main">
                    <h1>Users</h1>
                    <hr>
                    <%=table %>
                    <br><br>
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
