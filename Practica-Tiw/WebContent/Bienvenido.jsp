<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ page session="true"%>
<%@ page import="clases.User"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Bienvenido</title>
</head>
<body>

	<!-- Recogo el usuario guardado en la session -->
	<%!User u = new User();%>
	<%
		u = (User) session.getAttribute("usuario");
	%>

	<h1>
		BIENVENIDO
		<%=u.getName()%>
		con ID
		<%=u.getId()%></h1>


	<a href="ModifyUser.jsp"> Modificar mi usuario</a>

</body>
</html>