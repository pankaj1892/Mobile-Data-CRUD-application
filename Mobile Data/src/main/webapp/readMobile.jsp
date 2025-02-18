<%@page import="com.entity.Mobile"%>
<%@page import="java.util.List"%>
<%@page import="com.service.MobileService"%>
<%@page import="com.service.MobieServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/form.css">
</head>
<body>
	<%!MobileService service;

	public void init() throws ServletException {
		service = new MobieServiceImpl();
	}%>
	<%
	List<Mobile> mobile = service.readAllMobiles();
	request.setAttribute("list", mobile);
	%>
	<table id="Mobile" border="1px">

		<tr>
			<th>Model No</th>
			<th>Name</th>
			<th>Price</th>
			<th>Launch Date</th>
			<th>DELETE</th>
			<th>UPDATE</th>
		</tr>

		<c:forEach var="mob" items="${requestScope.list}">
			<tr>
				<td><c:out value="${mob.modelNo}"></c:out></td>
				<td><c:out value="${mob.name}"></c:out></td>
				<td><c:out value="${mob.price}"></c:out></td>
				<td><c:out value="${mob.launchDate}"></c:out></td>
				<td><a href="DeleteMobileServlet?id=${mob.modelNo}">DELETE</a></td>
				<td><a href="updateMobile.jsp?id=${mob.modelNo}">UPDATE</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>