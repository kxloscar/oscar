<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
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
form{
	padding-top:40px;
	padding-left:40px;
}
</style>
<body>
	<h1>书籍库存等级系统（V1.0）</h1>
	<div id="d1">
		<a href="show.html">首页</a><br> <a href="lanjieqi?name=rkdj">入库登记</a><br> <a href="lanjieqi?name=kclb">库存列表</a><br>
	</div>
	<div id="d2">
		<form method="get" action="servlet" >

			书名：<input type="text" name="title" value=""> <br>
			类别：
			<label><input name="type" type="checkbox" value="科学" />科学 </label> 
			<label><input name="type" type="checkbox" value="教育" />教育 </label> 
			<label><input name="type" type="checkbox" value="文学" />文学 </label> 
			<label><input name="type" type="checkbox" value="生活" />生活</label> 
			<label><input name="type" type="checkbox" value="其他" />其他</label> <br>
			作者 ：<input type="text" name="writer" value=""> <br>
			折扣：
			
				全价:<input type="radio" name="discount" value="10">    
				<label><span>&nbsp&nbsp9折:</span><input type="radio" name="discount" value="0.9"></label> 
				<label>  &nbsp&nbsp8折:<input type="radio" name="discount" value="0.8"></label>  
				<label>  &nbsp&nbsp7折:<input type="radio" name="discount" value="0.7"></label> 
				<label>  &nbsp&nbsp6折:<input type="radio" name="discount" value="0.6"></label> <br> 
				价格：<input type="text" name="price" value=""> <br>
				数量：<input type="text" name="amount" value=""> <br>

				<!-- 你还有什么想说的 -->
				简介：<br><textarea name="synopsis" style="width: 300px; height: 100px;"></textarea><br>
				<input type="submit" value="提交">&nbsp&nbsp<input type="reset" value="重置" />  
		</form>
	</div>
</body>
</html>