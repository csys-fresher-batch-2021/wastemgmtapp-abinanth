<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Payment</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="PaymentServlet" method="post">
			<%
			String userName = (String) session.getAttribute("LOGGED_IN_USER");
			String finalAmount = (String) session.getAttribute("amount");
			String message = (String) session.getAttribute("message");
			if (message != null) {
				out.println("<font color='green'>" + message + "</font>");
			}
			%>
			<table class=" table table-container-fluid">
				<caption>Payment Status</caption>
				<h3>Payment Status</h3>
				<thead>
					<tr>
						<th scope="col">Username</th>
						<th scope="col">Final Amount</th>
						<th scope="col">Status</th>
					</tr>
				</thead>
				<tr>
					<td><%=userName%></td>
					<td><%=finalAmount%></td>
					<td>Paid</td>
				</tr>
			</table>

		</form>
	</main>
</body>
</html>