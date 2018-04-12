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
	<form:errors path="planet.*" cssClass="errors"></form:errors>
<!-- ... -->
	<form:form method="POST" action="/planets/${planet.id}" modelAttribute="planet">
	<p>
	    <form:label path="name">Name:
	    <form:input path="name" /></form:label>
	   </p> 
	   <p>
	    <form:label path="size">Size:
	    <form:textarea path="size" /></form:label>
	    </p>
	    <p>
	    <form:label path="mass">Mass:
	    <form:input type="number" path="mass"/></form:label>
	    </p>
	    <input type="submit" value="Submit"/>
	</form:form>
	<a href="/">Home</a>
</body>
</html>