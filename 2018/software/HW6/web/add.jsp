<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="webStyle.css">
        <title>Add A New User</title>
    </head>
    <body>
        <div class ="wrap">

            <%@ include file="includes/header.jsp" %>   

            <%@ include file="includes/menu.jsp" %>

            <div class="main">
                <h1>Add A New User</h1>


                <form name="addForm" action="addUser" method="get">
                    <table>
                        <tr>
                            <td><label>User Name:</label></td>
                            <td><input type="text" name="name" value="" /></td>
                        </tr>

                        <tr>
                            <td><label>User Age:</label></td>
                            <td><input type="text" name="age" value="" /></td>
                        </tr>

                    </table>
                    <input type="submit" name="submit" value="Submit" id="submit"/>
                    <input type="reset" value="clear" id="clear">
                    <br>

                </form>



            </div>

            <%@ include file="includes/footer.jsp" %>

        </div>
    </body>
</html>
