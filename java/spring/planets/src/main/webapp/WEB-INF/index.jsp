<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Welcome to the Planets</h1>
	<h2>All Planets</h2>
	<table>
		<thead>
			<tr>
				<td>Name</td>
				<td>Size</td>
				<td>Mass</td>
				<td>Actions</td>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${planets}" var="planet" varStatus="loop">
				<tr>
					<td><a href="/planets/${planet.id }"><c:out value="${planet.name }"></c:out></a></td>
					<td><c:out value="${planet.size }"></c:out></td>
					<td><c:out value="${planet.mass }"></c:out></td>
					<td><a href="/planets/${planet.id }/edit">Edit</a> | <a href="/planets/${planet.id}/destroy">Delete</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<a href="/planets/new">Add Planet</a>
</body>
</html>