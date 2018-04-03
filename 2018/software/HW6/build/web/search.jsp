<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="webStyle.css">
        <title>Search Users</title>
    </head>
    <body>
        <h1>Search Users</h1>
        
        <form name="searchForm" action="search" method="get">
            
            <input type="text" name="searchVal" value="" />
            
            <br><br>
            
            <input type="submit" name="submit" value="Search" />
            
        </form>
        
        <br><br>
        <a href="index.jsp">Home Page</a>
        <br><br>
        <a href="read">Back to the list</a>
        
    </body>
</html>
