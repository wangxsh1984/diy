<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>demo</title>
</head>
<body>
	<h1>demo</h1>
	<c:forEach var="demo" items="${demoList}">
		<c:out value="${demo.username}"></c:out>
		<br />
	</c:forEach>
</body>