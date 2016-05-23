<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<title></title>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/js/jquery-1.7.js"></script>
<script type="text/javascript">
	function showChildren(parentId,parent){
		$.ajax({
			data : "parentId="+parentId,
			type : "POST",
			dataType : 'json',
			url : "<%=request.getContextPath()%>/org/getOrgs.do",
			error : function(data) {
				alert("出错了！！:" + data.msg);
			},
			success : function(data) {
				var orgList=data.orgList;
				var html=parent.innerHTML+"<ul>";
				for(var i=0;i<orgList.length;i++){
					html=html+"<li>"+orgList[i].orgName+"</li>";
				}
				html=html+"</ul>";
				parent.innerHTML=html;
			}
		});
	}
	function loadTree(){
		$.ajax({
			data : "parentId=",
			type : "POST",
			dataType : 'json',
			url : "<%=request.getContextPath()%>/org/getOrgs.do",
			error : function(data) {
				alert("出错了！！:" + data.msg);
			},
			success : function(data) {
				$("#tree").html("<li onclick=showChildren('"+data.orgList[0].orgId+"',this)>"+data.orgList[0].orgName+"</li>");
			}
		});
	}
</script>
</head>
<body onload="loadTree()">
	<c:forEach items="${orgList}" var="org">
		<a href='preAddOrg.do?parentId=<c:out value="${org.id}"/>'> <c:out
				value="${org.orgName }" /> </a>
		<br />
	</c:forEach>

	<ul id="tree"></ul>
</body>
</html>