<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2>stud list</h2>
<a href="new">add new student</a>

<table border="1">

<td>ID</td>
<td>Name</td>
<td>City</td>
<td>mobile</td>
<td>email</td>
<td>Action</td>

<c:forEach var="s" items="${list}">
<tr>
<td>${s.id}</td>
<td>${s.name}</td>
<td>${s.city}</td>
<td>${s.mobile}</td>
<td>${s.email}</td>
<td>
<a href="edit/${s.id}">update</a>
<a onclick="return confirm('do u want to delete?')" href="delete/${s.id}">delete</a> </td></tr>

</c:forEach>
</table>
</body>
</html>