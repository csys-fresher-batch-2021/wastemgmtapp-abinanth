<%@page import="com.abinanth.model.PaymentModel"%>
<%@page import="java.util.List"%>
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
			List<PaymentModel> myBills = (List<PaymentModel>) request.getAttribute("bills");

			String status = (String) session.getAttribute("status");
			String message = (String) session.getAttribute("message");
			%>
			<table class=" table table-container-fluid">
				<caption>Payment Status</caption>
				<thead>
					<h2>Payment</h2>
					<tr>
						<th scope="col">USERNAME</th>
						<th scope="col">PaymentId</th>
						<th scope="col">Recidency No</th>

						<th scope="col">Recidency Type</th>
						<th scope="col">Amount</th>
						<th scope="col">Status</th>
					</tr>
				</thead>

				<tbody>
					<%
					for (PaymentModel bill : myBills) {
					%>
					<tr>
						<td><%=bill.getUsername()%></td>
						<td><%=bill.getPaymentId()%></td>
						<td><%=bill.getRecidencyNo()%></td>
						<td><%=bill.getRecidencyType()%></td>
						<td><%=bill.getAmount()%></td>

						<td><%=bill.getStatus()%></td>
						<%
						if (bill.getStatus().equalsIgnoreCase("PENDING")) {
						%>
						<td><a
							href="PaymentServlet?paymentId=<%=bill.getPaymentId()%>">Pay
								now</a></td>

					</tr>
					<%
					}
					}
					%>
				</tbody>
			</table>

		</form>
	</main>
</body>
</html>