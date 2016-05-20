<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
</head>
<body>
<form action="addOrg.do" method="post">
	<input name="orgName" />
	<br />
	<input name="orgCode" />
	<br />
	<input name="parentId" type="hidden" value='<c:out value="${parentId}"></c:out>'/>
	<br />
	<input type="submit" value="确定">
</form>
</body>
</html>