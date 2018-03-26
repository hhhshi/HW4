<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="webStyle.css">
        <title>Add A New User</title>
    </head>
    <body>
        <h1>Add A New User</h1>
        
        <form name="addForm" action="addUser" method="get">
            
            <label>User Name:</label>
            <input type="text" name="name" value="" />
            <br>
            <label>User Age:</label>
            <input type="text" name="age" value="" />
            <br>
            <input type="submit" name="submit" value="Submit" id="submit"/>
        </form>
    </body>
</html>
