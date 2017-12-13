<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
  <%@page import="bookstoreDao.bookModel"%>
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


<jsp:useBean id="select" class="bookstoreDao.bookDAOIpml">	</jsp:useBean>
	
			
			
<jsp:useBean id="book" class="bookstoreDao.bookModel">	
			<% 
				book=select.getBook(request.getParameter("id"));
				pageContext.setAttribute("book", book);
			%>
			
	</jsp:useBean>
<h1>书籍库存等级系统（V1.0）</h1>
	<div id="d1">
		<a href="show.html">首页</a><br> <a href="index.jsp">入库登记</a><br> <a href="table.jsp">库存列表</a><br>
	</div>
	<div id="d2">
		<div id="d3">
			<span>书名：${book.title }</span><br>
			<span>类别：${book.type }</span><br>
			<span>作者：${book.writer } </span><br>
			<span>折扣：${book.discount }</span><br>
			<span>价格：${book.price } </span><br>
			<span>数量：${book.amount }</span><br>
			<span>简介：${book.synopsis } </span><br>
			
 		</div>
	</div>
	
</body>
</html>