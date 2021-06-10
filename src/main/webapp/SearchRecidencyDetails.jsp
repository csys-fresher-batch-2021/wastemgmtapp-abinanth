<%@page import="com.abinanth.model.PaymentModel"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Search Status</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	<main class="container-fluid">
		<form action="SearchRecidencyDetailsServlet" method="post">
			<%
			String message = (String) request.getAttribute("message");
			if (message != null) {
				out.println("<font color='red'>" + message + "</font>");
			}
			%>
			<h2>Search by Status or Recidency Name</h2>
			<label for="text">Search</label><input type="text" name="search"
				required>
			<button type="submit">Search</button>
		</form>

		<table class=" table table-container-fluid">
			<caption>Search</caption>
			<thead>
				<th>Recidency No</th>
				<th>Recidency Name</th>
				<th>Amount</th>
				<th>Status</th>
			</thead>
			<tbody>
				<%
				List<PaymentModel> list = (List<PaymentModel>) request.getAttribute("recidencyList");

				if (list != null) {
					for (PaymentModel word : list) {
				%>
				<tr>
					<td><%=word.getRecidencyNo()%></td>
					<td><%=word.getRecidencyType()%></td>
					<td><%=word.getAmount()%></td>
					<td><%=word.getStatus()%></td>
				</tr>
				<%
				}
				}
				%>
			</tbody>
		</table>
	</main>

</body>
</html>