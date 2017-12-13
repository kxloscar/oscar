<%@page import="bookstoreDao.bookModel"%>
<%@page import="java.util.List"%>
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
h1 {margin-left =100px;
	
}

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
table{
	border:1px solid black;
	font-size:10px;
}

th{
	border:1px solid black;
	width:50px;
	textalign:center;
}
td{
	border:1px solid black;
	width:50px;
	
}
</style>
<body>
<h1>书籍库存等级系统（V1.0）</h1>
	<div id="d1">
		<a href="show.html">首页</a><br> <a href="lanjieqi?name=rkdj">入库登记</a><br> <a href="lanjieqi?name=kclb">库存列表</a><br>
	</div>
	<div id="d2">
		<div id="d3">
			<jsp:useBean id="selectAll" class="bookstoreDao.bookDAOIpml" scope="request">	
			</jsp:useBean>
		 	<table > 
		       <tr> 
		           <th>编号</th> 
		           <th>书名</th> 
		           <th>作者</th> 
		           <th>价格</th> 
		           <th>数量</th> 
		           <th></th> 
		       </tr> 
		       <c:forEach items="${selectAll.allbooks}" var="book">
		       <tr> 
		        	<td>${ book.id}</td> 
		        	<td>${ book.title}</td>
		        	<td>${ book.writer}</td>
		        	<td>${ book.price}</td>
		        	<td>${ book.amount}</td>
		        	<td><a href="xq.jsp?id=${book.id}">详情</a></td>
		       </tr>
		       </c:forEach>
		       
		   </table> 
 		</div>
	</div>
</body>
</html>