<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>User Login</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="UserLoginServlet" method="post">
			<%
			String username = (String) session.getAttribute("username");
			%>
			<%
			String errorMessage = request.getParameter("errorMessage");
			if (errorMessage != null) {
				out.println("<font color='red'>" + errorMessage + "</font>");
			}
			%>
			<h3>User Login</h3>
			<label>User Name</label> <input type="text" id="username"
				name="username" required autofocus><br> <label>
				Password</label> <input type="password" id="password" name="password"
				required><br>
			<button type="submit" class="btn btn-primary">Submit</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form>
		Note:<br> password should be between 8 to 20 characters, at least
		one numeric and at least one capital letter
	</main>


</body>
</html>