<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>demo</title>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default/default.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.7.js"></script>
<script type="text/javascript">
	function sendAjaxPost() {
		$.post("<%=request.getContextPath()%>/demo/goAjax.do", {
			Action : "post",
			Name : "aaa"
		}, function(data, textStatus) {
			alert(data);
		}, "json");
	}
	function ajaxTest() {
		$.ajax({
			data : "{Name:m模型}",
			type : "POST",
			dataType : 'json',
			contentType: "application/json; charset=utf-8",
			url : "<%=request.getContextPath()%>/demo/goAjax.do",
			error : function(data) {
				alert("出错了！！:" + data.msg);
			},
			success : function(data) {
				alert(data.success);
			}
		});
	}
</script>
</head>
<body>
	<h1>demo</h1>
	<c:forEach var="demo" items="${demoList}">
		<c:out value="${demo.username}"></c:out>
		<br />
	</c:forEach>
	<input type="text">
	<button onclick="ajaxTest()">AJAX</button>
</body>