<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@ page import="java.io.*,java.util.*,es.salesianos.model.*"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>

	<%
		List<Actor> listAllActors = (List<Actor>) request.getAttribute("listAllActors");
			request.getAttribute("codPelicula");
	%>
	<form action="/searchActor" method="get">
		<span>From:</span> <input type="text" name="From"> <span>To:</span>
		<input type="text" name="To"> <input type="submit">
	</form>

	<table border="1">
		<thead>
			<tr>
				<td>Cod Actor</td>
				<td>name</td>
				<td>year</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="actor" items="${listAllActors}">
				<tr>
					<td><c:out value="${actor.cod}" /></td>
					<td><c:out value="${actor.name}" /></td>
					<td><c:out value="${actor.year}" /></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<br>
	<div>
		<a href="index.jsp">Return to index</a>
	</div>
</body>	


</body>
</html>