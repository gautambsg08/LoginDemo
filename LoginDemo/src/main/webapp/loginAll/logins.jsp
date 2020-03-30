<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<table>
<tr>
<th>Id</th>
<th>UserName</th>
<th>Roles</th>
</tr>
</table>
<c:forEach items="${lg}" var="lg1">
<table>
<tr>
<td>${lg1.getId()}</td>
<td>${lg1.getUsername()}</td>
<td>${lg1.getRoles()}</td>
</tr>

</table>
<br>
</c:forEach>


</body>
</html>