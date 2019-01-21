<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Adding actors</title>
</head>
<body>

	<%
		List<Actor> listAllActores = (List<Actor>) request.getAttribute("listAllActores");
	%>

	<form action="/actor" method="post">
		<span>name:</span> <input type="text" name="nombre"> <span>Year
			of birth:</span> <input type="text" name="year"> <br /> <input
			type="submit">
	</form>
	<br />
	<br />
	<br />
	<table border="1">
		<thead>
			<tr>
				<td>Cod</td>
				<td>Name</td>
				<td>Year of Birth</td>
				<td></td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="actor" items="${listAllActores}">
				<tr>
					<td><c:out value="${actor.cod}" /></td>
					<td><c:out value="${actor.name}" /></td>
					<td><c:out value="${actor.year}" /></td>
					<td><a href="/actor?cod=${actor.cod}">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<div>
		<a href="index.jsp">Return to index</a>
	</div>

</body>
</html>