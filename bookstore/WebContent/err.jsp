<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<style>
#d1 {
	width: 80px;
	height:400px;
	border-top: 1px solid black;
	border-right: 1px solid black;
	float: left;
}

#d2 {
	width: 400px;
	
	border-top: 1px solid black;
	float: left;
}
#d3{
	padding-top:40px;
	padding-left:40px;
}
</style>
<body>
<h1>书籍库存等级系统（V1.0）</h1>
	<div id="d1">
		<a href="show.html">首页</a><br> <a href="index.jsp">入库登记</a><br> <a href="table.jsp">库存列表</a><br>
	</div>
	<div id="d2">
		<div id="d3">
			<c:if test="${not empty errors}">
			<c:forEach items="${errors}" var="err">
			<li>${err }
			</c:forEach>
	</c:if>
 		</div>
	</div>
</body>
</html>