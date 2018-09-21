<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>产品列表</title>
<link rel="stylesheet" href="a/css/index1.css" type="text/css"></link>
</head>
<body>

<table border="1">
	<tr>
		<td>商品名称</td>
		<td>商品价格</td>
		<td>入库时间</td>
		<td>商品描述</td>
		<td>商品分类</td>
		<td>操作 <a href="insert.jsp">添加</a></td>
	</tr>
	<c:forEach items="${products}" var="p">
		<tr>
			<td>${p.name}</td>
			<td>${p.price}</td>
			<td>${p.createTime}</td>
			<td>${p.detail}</td>
			<td>
				<c:forEach items="${p.categories}" var="c" >
					${c.name} 
				</c:forEach>
			</td>
			<td>
				<a href="deleteProduct.do?id=${p.id}">删除</a>
				<a href="getUpdateForm.do?id=${p.id}">修改</a>
			</td>
		</tr>	
	</c:forEach>
</table>
</body>
</html>