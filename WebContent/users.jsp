<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>

<%-- 
    Author     : Arda
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>All users</title>
    </head>
    <body>
		<table border="1">
		<c:forEach items="${users}" var="element"> 
  			<tr>
    			<td>${element.name}</td>
			    <td>${element.email}</td>
			    <td>${element.phone_num}</td>
			    <td>${element.hash}</td>
		    </tr>
			</c:forEach>
		</table>
		<table border="1">
		<c:forEach items="${vehicles}" var="elements"> 
  			<tr>
    			<td>${elements.vin}</td>
			    <td>${elements.make}</td>
			    <td>${elements.model}</td>
			    <td>${elements.year}</td>
			    <td>${elements.tire_num}</td>
			    <td>${elements.axis_num}</td>
			    <td>${elements.email}</td>
		    </tr>
			</c:forEach>
		</table>
		
   </body>
</html>