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
String finalamount=(String)session.getAttribute("amount");
String recidencyType=(String)session.getAttribute("recidencyType");
%>
<table class=" table table-container-fluid">

<tr>
<td scope="col"><h2>Get your bill</h2></td>
</tr>

<tbody>
<tr>
<td>

Your recidencyType is :
<%=recidencyType %>
</td>
<td>
Your amount is:
	Rs.<%=finalamount %>
</td>
</tr>
</tbody></table>


	
	</main>
</body>
</html>