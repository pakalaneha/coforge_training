<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
	<b><font color = 'green'>Welcome <%=session.getAttribute("username") %></font></b>
	<!-- cookie -->
	<%
		Cookie[] cookies = request.getCookies();// returns all the cookies from client machine
		out.println("<p><b><font color ='green'>Welcome " + cookies[0].getValue() + "</font></b></p>");
		// based on version username can be on cookies[0](9.0) or cookies[1](version 10)
		// 1st cookie can be session id in some version
	%>
</body>
</html>