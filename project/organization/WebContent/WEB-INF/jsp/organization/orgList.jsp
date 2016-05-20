<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.7.js"></script>
</head>
<body>
	<c:forEach items="${orgList}" var="org">
		<a href='preAddOrg.do?parentId=<c:out value="${org.id}"/>'> <c:out
				value="${org.orgName }" /> </a>
		<br />
	</c:forEach>

	<ul id="tree1">
		<li>主节点内容
			<ul>
				<li>主节点的子节点1</li>
				<li>主节点的子节点2
					<ul>
						<li>主节点的子节点2的子节点</li>
						<li>主节点的子节点2的子节点</li>
						<li>主节点的子节点2的子节点</li>
						<li>主节点的子节点2的子节点</li>
					</ul></li>
				<li>主节点的子节点3</li>
				<li>主节点的子节点4</li>
			</ul></li>
	</ul>
</body>
</html>