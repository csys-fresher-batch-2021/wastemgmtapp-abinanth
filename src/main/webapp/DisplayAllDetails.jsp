<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="PaymentServlet" method="post">
			<%
			String userName = (String) session.getAttribute("LOGGED_IN_USER");
			String recidencyNo = (String) session.getAttribute("recidencyNo");

			String recidencyType = (String) session.getAttribute("recidencyType");
			String finalAmount = (String) session.getAttribute("amount");

			String status = (String) session.getAttribute("status");
			String message = (String) session.getAttribute("message");
			%>
			<table class=" table table-container-fluid">
				<caption>Payment pending</caption>
				<tr>
					<td>USERNAME</td>
					<td>Recidency No</td>
					<td>Recidency Type</td>
					<td>Amount</td>
				</tr>
				<tr>
					<td><%=userName%></td>
					<td><%=recidencyNo%></td>
					<td><%=recidencyType%></td>
					<td><%=finalAmount%></td>
				</tr>
			</table>
			<button type="submit">Pay now</button>
		</form>
	</main>
</body>
</html>