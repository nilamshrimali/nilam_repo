<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
   <%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>  
   	
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h2 align="center">entry page</h2>
<form:form action="/spring_practice_001/save" method="post">

<form:hidden path="id"/>
<table border="1" align="center">
<tr>
<td>name :</td>
<td><form:input path="name"/></td></tr>

<tr><td>city :</td>
<td><form:input path="city"/></td></tr>

<tr><td>mobile :</td>
<td><form:input path="mobile"/></td></tr>

<tr><td>email :</td>
<td><form:input path="email"/></td></tr>

<tr><td colspan="2"><input type="submit" name="submit" value="Submit"></td></tr>
</table>

</form:form>


</body>
</html>