<%@page import="com.abinanth.servlet.AddRecidencyServlet"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Add Recidency</title>
</head>
<body>

	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<%
		String errorMessage = request.getParameter("errorMessage");
		if (errorMessage != null) {
			out.println("<font color='red'>" + errorMessage + "</font>");
		}
		%>
		


		<h2>Add Recidency</h2>
		<form action="AddRecidencyServlet" method="post">
			<label for=" addRecidency">Recidency</label> <input type="text"
				name="recidency" required>
			<button type="submit">Submit</button>
		</form>

	</main>


</body>
</html>