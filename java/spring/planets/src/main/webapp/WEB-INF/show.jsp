<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link href="/style/style.css" type="text/css" rel="stylesheet"> 
</head>
<body>
	<h1>Name: <c:out value="${planet.name }"></c:out></h1>
	<h1>Size: <c:out value="${planet.size }"></c:out></h1>
	<h1>Mass: <c:out value="${planet.mass }"></c:out></h1>
	<h1>Moons:</h1>
	<ul>
		<c:forEach items="${planet.moons}" var="moon">
			<li><c:out value="${moon.name }"/></li>
		</c:forEach>
	</ul>
	<a href="/">Home</a>
	<a href="/planets/${planet.id }/edit">Edit</a>
	<h2>Add a moon</h2>
	<form:errors path="moon.*" cssClass="errors"></form:errors>
<!-- ... -->
	<form:form method="POST" action="/planets/${planet.id}/addMoon" modelAttribute="newMoon">
	<p>
	    <form:label path="name">Name:
	    <%-- <form:errors path="name"/> --%>
	    <form:input path="name"/></form:label>
	   </p> 
	    <input type="submit" value="Submit"/>
	</form:form>
	<c:if test="${success != null}">
		<p class="success"><c:out value="${success}"></c:out></p>
	</c:if>
</body>
</html>