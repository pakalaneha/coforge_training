<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login Page</title>
</head>
<body>
    <%--JSP Declaration Tag--%>
	<%!
		//instance variable
		String name = "Neha";
		int a = 10, b = 20; 
	%>
	
	<%--JSP Scriptlet Tag--%>
	<%--out is implicit object in jsp --%>
	<%
		//local variable
		out.println("<br>Welcome " + name);
		if(a > b) {
			out.println("<br>a is Big Element");
		}
		else {
			out.println("<br>b is Big Element");
		}
		
		int sum = a + b;
		
	%>
	
	<br> 
	<%--JSP Expression Tag--%>
	Sum = <%=sum %>
	
	
</body>
</html>