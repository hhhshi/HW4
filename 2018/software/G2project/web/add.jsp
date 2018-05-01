<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<% String bookmark_url = (String)request.getParameter("bookmark_url"); %>
<% String page_title = (String)request.getParameter("page_title"); %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="./css/Stylesheet.css"/>
        <title>Add new Bookmark</title>
    </head>
    <body>
        <div class="wrap"> <!--div to hold all other divs -->
        
        <%@ include file="includes/menu.jsp"   %>
            <div class ="main">
                <h1>Add a new Bookmark</h1>
                <hr>
                <form name="addForm" action="addBookmark" method="get">
                    <table>
                        <tbody>
                            <tr>
                                <td>Page's Name:</td>
                                <td><input type="text" name="page_name" value=" <%= page_title %>" /></td> 
                            </tr>
                            <tr>
                                <td>URL:</td>
                                <td><input type="text" name="url" value="<%= bookmark_url %>" /></td> 
                            </tr>
                            <tr>
                                <td>Username:</td>
                                <td><input type="text" name="username" value="" /></td> 
                            </tr>
                            <tr>
                                <td>Category number:</td>
                                <td><select id="selectedRecord" name="cat">
                                    <c:forEach var="allCategories" items="${allCategories}">
                                    <option value="${allCategories.cat_ID}">${allCategories.cat_name}</option>
                                    </c:forEach>
                                    </select></td>
                            </tr>
                            <tr>
                                <td>Notes:</td>
                                <td><input type="text" name="note" value="" /></td> 
                            </tr>
                            <tr>
                                <td></td>
                                <td><input type="reset" value="clear" id="clear">
                                    <input type="submit" name="submit" value="submit" />
                                    <form name="bookmarks" action="read.jsp" method="post">
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
