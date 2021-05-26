

<%@page import="com.abinanth.model.RecidencyModel"%>
<%@page import="com.abinanth.dao.RecidencyDao"%>
<%@page import="java.util.List"%>
<%@page import="com.abinanth.services.RecidencyTypeService"%>

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
			String infoMessage = request.getParameter("infoMessage");
					if (infoMessage != null) {
				out.println("<font color='green'>" + infoMessage + "</font>");
					}
			%>
		
			<%
					RecidencyDao dao=new RecidencyDao();
						List<RecidencyModel> recidencyType = RecidencyTypeService.displayRecidencyType();
								int i = 0;
								for (RecidencyModel recidency : recidencyType) {
									i++;
					%>
			<tr>
				<td><%=i%></td>
				<td><%=recidency.getNewRecidency()%></td>
				<td><a href="deleteRecidencyServlet?recidencyType=<%=recidency.getNewRecidency() %>" class="btn btn-danger">Delete</a></td>
			</tr>
			<%
			}
			%>

		</tbody>
	</table>
	<a href="addRecidency.jsp">Add Recidency</a>

</body>
</html>






