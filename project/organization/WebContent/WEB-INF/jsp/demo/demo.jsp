<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title>demo</title>
<link type="text/css" rel="stylesheet"
	href="<%=request.getContextPath()%>/css/default/default.css">
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.7.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/ajaxfileupload.js"></script>
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
	function ajaxFileUpload(){
		$.ajaxFileUpload({
			url : '<%=request.getContextPath()%>/demo/ajaxFileUpload.do',
			secureuri : false,//安全协议
			fileElementId:'file',//id
			type : 'POST',
			dataType : 'json',
			data:"{demo:test}",
			async : false,
			error : function(data,status,e) {
				alert('Operate Failed!');
			},
			success : function(json) {
				if(json!="last"){
					$("#file").remove();
					ajaxFileUpload();
				}
			}
		});
	}
</script>
</head>
<body>
	<div id="aaa"></div>
	<form id="testForm" action="fileUpload.do" method="post"
		enctype="multipart/form-data">
		<input type="file" name="file" id="file"/>
		<br/>
		<input type="file" name="file" id="file"/>
		<button onclick="ajaxFileUpload()">AJAX</button><br />
		<input type="submit">
	</form>

</body>