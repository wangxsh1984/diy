<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<link type="text/css" rel="stylesheet" href="<%=request.getContextPath()%>/css/default/default.css">
<title>demo</title>
</head>
<body>
	<h1>demo</h1>
	<c:forEach var="demo" items="${demoList}">
		<c:out value="${demo.username}"></c:out>
		<br />
	</c:forEach>
	<input type="text">
</body>