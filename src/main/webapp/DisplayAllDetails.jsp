<%@page import="java.time.format.DateTimeFormatter"%>
<%@page import="com.abinanth.services.BillGeneratorService"%>
<%@page import="com.abinanth.services.PaymentService"%>
<%@page import="java.time.LocalDate"%>
<%@page import="com.abinanth.model.BillCalculatorModel"%>
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
			String userName = (String) session.getAttribute("username");
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
						<th scope="col">Due Date</th>
						<th scope="col">Paid Date</th>
						<th scope="col">Fine Amount</th>
						<th scope="col">Status</th>
						<th scope="col">Total Amount</th>

					</tr>
				</thead>

				<tbody>
					<%
					double fineAmount = 0;
					double totalAmount = 0.0;
					%>
					<%
					if (myBills != null) {

						DateTimeFormatter formatters = DateTimeFormatter.ofPattern("dd-MM-yyyy");

						for (PaymentModel bill : myBills) {
							String dueDate = bill.getDueDate().format(formatters);
							String payedDate = "----";
							if (bill.getPaidDate() != null) {
						payedDate = bill.getPaidDate().format(formatters);

							}
					%>


					<tr>
						<td><%=bill.getUsername()%></td>
						<td><%=bill.getPaymentId()%></td>
						<td><%=bill.getRecidencyNo()%></td>
						<td><%=bill.getRecidencyType()%></td>
						<td>Rs.<%=bill.getAmount()%></td>

						<td><%=dueDate%></td>

						<td><%=payedDate%></td>
						<%
						if (LocalDate.now().isAfter(bill.getDueDate())) {
							//fineAmount = PaymentService.addFineAmount(bill.getPaymentId());
						%>
						<td>Rs.100.0</td>

						<%
						} else {
						%>
						<td>Rs.0.0</td>
						<%
						}
						%>
						<td><%=bill.getStatus()%></td>
						<%
						totalAmount = bill.getTotalAmount();
						%>

						<td>Rs.<%=totalAmount%></td>
						<%
						if (bill.getStatus().equalsIgnoreCase("PENDING")) {
						%>
						<td><a
							href="PaymentServlet?paymentId=<%=bill.getPaymentId()%>">Pay
								now</a></td>

						<%
						}
						}
						}
						%>

					</tr>
				</tbody>
			</table>

		</form>
	</main>
</body>
</html>