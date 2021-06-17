<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Waste Management</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="AdminLoginServlet" method="get">
			<%
			String username = (String) session.getAttribute("username");
			%>
			<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			%>
			<h3>Admin Login</h3>
			<label>Admin Name</label> <input type="text" id="adminUserName"
				name="adminUserName" required autofocus><br> <label>
				Password</label> <input type="password" id="adminPassword"
				name="adminPassword" required><br>
			<button type="submit" class="btn btn-primary">Submit</button>
			<button type="reset" class="btn btn-danger">Reset</button>
			<br> Note :<br> Admin name=admin<br> Admin
			password=admin123
		</form>
		<a href="UserLogin.jsp">User Login</a>
	</main>
	
</body>
</html>