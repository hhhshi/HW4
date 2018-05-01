<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="model.Bookmarks"%>
<% Bookmarks bookmark = (Bookmarks) request.getAttribute("bookmark"); %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/Stylesheet.css"/>
        <title>Update Bookmark</title>
    </head>
    <body>
        <div class="wrap"> <!--div to hold all other divs -->
        
        <%@ include file="includes/menu.jsp"   %>
            <div class ="main">
            <h1>Update Bookmark</h1>
            <hr>
            <form name="updateForm" action="updateBookmark" method="get">
                <table>
                <tbody>
                    <tr>
                        <td>Bookmark's ID:</td>
                        <td><input type="text" name="bookmark_id" value="<%= bookmark.getBookmark_ID() %>" readonly="" /></td> 
                    </tr>
                    <tr>
                        <td>Page Name:</td>
                        <td><input type="text" name="page_name" value="<%= bookmark.getPage_name() %>" /></td> 
                    </tr>
                    <tr>
                        <td>URL:</td>
                        <td><input type="text" name="url" value="<%= bookmark.getUrl() %>" /></td> 
                    </tr>
                    <tr>
                        <td>Username:</td>
                        <td><input type="text" name="username" value="<%= bookmark.getUsername() %>" readonly="" /></td> 
                    </tr>
                    <tr>
                        <td>Category:</td>
                        <td><input type="text" name="cat" value="<%= bookmark.getCat() %>" /></td> 
                    </tr>
                    <tr>
                        <td>note:</td>
                        <td><input type="text" name="note" value="<%= bookmark.getNote() %>" /></td> 
                    </tr>        
                    <tr>
                        <td></td>
                        <td><input type="reset" value="clear" id="clear">
                            <input type="submit" name="submit" value="update" />
                            <form name="leaders" action="read.jsp" method="post">
                            <a href="read"> Cancel </a>
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

