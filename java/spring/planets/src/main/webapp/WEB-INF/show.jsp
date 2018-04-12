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
	<h1>Name: <c:out value="${planet.name }"></c:out></h1>
	<h1>Size: <c:out value="${planet.size }"></c:out></h1>
	<h1>Mass: <c:out value="${planet.mass }"></c:out></h1>
	<a href="/">Home</a>
	<a href="/planets/${planet.id }/edit">Edit</a>
</body>
</html>