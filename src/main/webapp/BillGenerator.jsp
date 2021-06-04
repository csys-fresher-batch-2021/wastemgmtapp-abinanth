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


		<%
		String finalamount = (String) session.getAttribute("amount");
		String recidencyType = (String) session.getAttribute("recidencyType");
		%>
		<table class=" table table-container-fluid">
			<caption>Bill is Generated</caption>
			<h2>Get your bill</h2>
			<thead>
				<tr>
					<th scope="col">Your Recidency Type</th>

					<th scope="col">Your Amount</th>

				</tr>
			</thead>
			<tbody>
				<tr>
					<td><%=recidencyType%></td>
					<td>Rs.<%=finalamount%>


					</td>

				</tr>
			<tbody>







			</tbody>
		</table>



	</main>
</body>
</html>