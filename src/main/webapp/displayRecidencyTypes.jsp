<%@page import="com.abinanth.services.RecidencyTypeService"%>
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
	<table class=" table table-container-fluid">
		<caption>Available Recidency</caption>
		<thead>
			<tr>
				<th scope="col">S.No</th>
				<th scope="col">Recidency Types</th>
			</tr>
		</thead>
		<tbody>
			<%
			List<String> recidencyType = RecidencyTypeService.displayRecidencyType();
					int i = 0;
					for (String recidency : recidencyType) {
						i++;
			%>
			<tr>
				<td><%=i%></td>
				<td><%=recidency%></td>
				</tr>
				<%} %>
				</tbody>
				</table>
				</main>

</body>
</html>