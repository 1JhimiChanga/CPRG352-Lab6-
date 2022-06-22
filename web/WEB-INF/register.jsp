<%-- 
    Document   : register
    Created on : 20-Jun-2022, 8:40:47 PM
    Author     : Jimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>
    <body>
        <form method="post" action="ShoppingList">
        <h1>Shopping List</h1>
        <label>Username: </label>
        <input type="text" name="c_username">
        <input type="submit"  value="Register name">
        <input type='hidden' name='action' value='register'>
        </form>
    </body>
</html>
