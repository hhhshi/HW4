
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="webStyle.css">
        <title>User Database</title>
    </head>
    
    <% String table = (String) request.getAttribute("table"); %>
    
    <body>
        <h1>User Database</h1>
        
        <table id="thead">
            <tr>
                <th>User ID</th>

                <th>User Name</th>

                <th>User Age</th>

                <th>Update?</th>
                
                <th>Delete?</th>
            </tr>
        </table>


        <%=table %>

        <br><br><br>
        <a href="index.jsp">Home Page</a>
        <br><br>
        <a href ="add">Add A New User</a>
        <br><br>
        <a href="search.jsp">Search Users</a>

        
    </body>
</html>
