
<%@page import="com.service.MobieServiceImpl"%>
<%@page import="com.service.MobileService"%>
<%@page import="com.dao.MobileDAO"%>
<%@page import="com.entity.Mobile"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="css/form.css">
</head>
<body><%!MobileService service;

	public void init() throws ServletException {
		service = new MobieServiceImpl();
	}%>
	<%
	String id = request.getParameter("id");
	Mobile mob = service.readMobileById(id);
	if (mob != null) {
	%>
	<form action="UpdateMobileServlet" method="get">
		ModelNo<input type="text" name="id" value="<%=mob.getModelNo()%>"
			readonly><br> New NAME<input type="text" name="name"
			value="<%=mob.getName()%>"><br> New Price<input
			type="text" name="price" value="<%=mob.getPrice()%>"><br>
		Launch Date<input type="date" name="launchDate"
			value="<%=mob.getLaunchDate()%>" readonly><br> <input
			type="submit" value="UPDATE"><br>
	</form>
	<%
	} else {
	%>
	<h2>Record Not Found</h2>

	<%
	}
	%>
</body>
</html>