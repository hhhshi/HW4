

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="webStyle.css">
        <title>User Age</title>
    </head>
    <body>
        <div class ="wrap">

            <%@ include file="includes/header.jsp" %>   

            <%@ include file="includes/menu.jsp" %>

            <div class="main">
                <h1>User Database</h1>
                <br>
                <a href="read">View All Users</a>
                <br><br>
                <a href="search.jsp">Search Users</a>
            </div>

            <%@ include file="includes/footer.jsp" %>

        </div>
    </body>
</html>
