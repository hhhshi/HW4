<%@page import="model.user"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<% user newuser = (user) request.getAttribute("newuser"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="webStyle.css">
        <title>Update A User</title>
    </head>
    <body>
        <h1>Update A User Record</h1>
        
        <form name="updateForm" action="updateUser" method="get">
            <table class="update">
                
            <tr>
            <td><label>User ID:</label></td>
            <td><input type="text" name="id" value="<%= newuser.getUSER_ID() %>" readonly/></td>
            </tr>
            
            <tr>
            <td><label>User Name:</label></td>
            <td><input type="text" name="name" value="<%= newuser.getUSERNAME() %>" /></td>
            </tr>
            
            <tr>
            <td><label>User Age:</label></td>
            <td><input type="text" name="age" value="<%= newuser.getUSERAGE() %>" /></td>
            </tr>
            
            </table>
            <input type="submit" name="submit" value="Update" id="update"/>
            <input type="reset" value="clear" id="clear">
            <br>
            
        </form>
    </body>
</html>
