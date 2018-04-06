<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Show Dog!</title>
</head>
<body>
	<h2>You created a <c:out value="${dog.getBreed()}"></c:out></h2>
	<h4><c:out value="${dog.getName()}"></c:out> <c:out value="${dog.showAffection()}"></c:out></h4>
</body>
</html>