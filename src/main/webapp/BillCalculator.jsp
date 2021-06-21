<%@page import="com.abinanth.model.RecidencyModel"%>
<%@page import="java.util.List"%>
<%@page import="com.abinanth.services.RecidencyTypeService"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="ISO-8859-1">
<title>Select Recidency Type</title>
</head>
<body>
	<jsp:include page="message.jsp"></jsp:include>
	<main class="container-fluid">
		<h3>Bill Calculation</h3>
		<%
		String message = request.getParameter("message");
		if (message != null) {
			out.println("<font color='green'>" + message + "</font>");
		}
		%>
		<form action="BillCalculator" method="post">
			<label>Enter Name</label> <input type="text" name="username"
				autofocus required><br> <label>Recidency Type</label> <select
				name="recidencyType">
				<option value="">Please select a Recidency</option>
				<%
				List<RecidencyModel> recidencyType = RecidencyTypeService.displayRecidencyType();
				for (RecidencyModel recidency : recidencyType) {
				%>
				<option value="<%=recidency.getNewRecidency()%>">
					<%=recidency.getNewRecidency()%>
					<%
					}
					%>
				</option>
			</select><br> <label>Enter Recidency No</label> <input type="number"
				name="recidencyNo" min=1 required><br> <label>Enter
				The Street Name</label> <input type="text" name="streetName" required><br>
			<label>Enter Your City</label> <input type="text" name="cityName"
				required><br> <label>Enter Your District</label> <input
				type="text" name="districtName" required><br> <label>Enter
				Number of years You need to pay</label> <input type="number" name="date"
				min=1 max=3 required><br>
			<button type="submit" class="btn btn-primary">Get Bill</button>
			<button type="reset" class="btn btn-danger">Reset</button>
		</form>
	</main>
</body>
</html>