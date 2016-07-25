<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Renter Details</title>
</head>
<body>

 <form:form action="reserve" method="post" modelAttribute="renter">
<fieldset>
<legend>RENTER DETAILS</legend>
<table>
	<tr>
	<td style="color: black">	FIRST NAME:</td> <td><form:input path="firstName"/></td>
		<form:errors path="firstName" cssStyle="color:red"></form:errors>
	
	</tr>
	
	<tr>
	<td style="color: black">	LAST NAME:</td> <td><form:input path="lastName"/></td>
		<form:errors path="lastName" cssStyle="color:red"></form:errors>
	
	</tr>

	<tr>
	<td style="color: black">	PHONE:</td> <td><form:input path="phoneNumber"/></td>
		<form:errors path="phoneNumber" cssStyle="color:red"></form:errors>
	
	</tr>
	
	<tr>
	<td style="color: black">	EMAIL:</td> <td><form:input path="email"/></td>
		<form:errors path="email" cssStyle="color:red"></form:errors>
	
	</tr>	
	
	<tr>

<td colspan="2">
		
	<input type="submit" value="Make a Reservation"/>
	</td>
</tr>
	
	</table>
	</fieldset>
	
</form:form> 
</body>
</html>