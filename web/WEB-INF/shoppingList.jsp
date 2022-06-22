<%-- 
    Document   : shoppingList
    Created on : 21-Jun-2022, 10:19:49 AM
    Author     : Jimmy
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Shopping List</title>
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        
    
    <body>
        <h1>Shopping List</h1>
        <form method='post' action=''>
            <label>Hello, ${name}</label>
            <a href="<c:url value='/ShoppingList?action=logout' />">Logout</a>
           
            
            
        </form>
        
            <form method="post" action="">
            <h3>List</h3>
            <label>Add item: </label>
            <input type="text" name='c_item'>
            <input type="hidden" name="action" value="add">
            <input type="submit" value="Add">
        </form>    
            
        <form method="post" action="">
            <c:forEach items="${itemList}" var="item">
                
                <input type="radio" name="v_item" value="${item}" >
                <label>${item}</label>
                <br>
            </c:forEach>
            <c:if test="${itemList.size() > 0}">
                
                <input type="hidden" name="action" value="delete">
                <input type="submit"  value="Delete">
                
            </c:if>
                
                
        </form>
    </body>
</html>
