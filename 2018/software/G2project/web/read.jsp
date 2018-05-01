<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/Stylesheet.css"/>
        <title>Bookmarks</title>
    </head>
    <% String table=(String) request.getAttribute("table");%>
    <body>
        <div class="wrap"> <!--div to hold all other divs -->
            
            <%@ include file="includes/menu.jsp"   %>
                <div class ="main">
                    <h1>My Bookmarks</h1>
                    <hr>
                    <%=table %>
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
