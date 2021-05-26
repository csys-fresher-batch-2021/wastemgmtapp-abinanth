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
<jsp:include page="header.jsp"></jsp:include>
<h3>Select Recidency Type And City</h3>
<form action="SelectRecidencyType" method="post">
<label>Recidency Type</label>
<select> 

<% List<RecidencyModel> recidencyType=RecidencyTypeService.displayRecidencyType();
for (RecidencyModel recidency : recidencyType) {
%>
<option>

<%=recidency.getNewRecidency() %>
<% 
}
%>
</option>

</select><br>
<label>Enter Recidency No</label>
<input type="number" name="recidencyNo"><br>
<label>Enter The Street Name</label>
<input type="text" name="streetName"><br>

<label>Enter Your City</label>
<input type="text" name="cityName"><br>
<label>Enter Your District</label>
<input type="text" name="districtName"><br>
<button type="submit">Submit</button>
</form>

</body>
</html>