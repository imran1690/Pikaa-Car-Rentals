<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.0/jquery.min.js"></script>
  <script src="http://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/js/bootstrap.min.js"></script>

<title>Insert title here</title>

<c:set var="url" value="${pageContext.request.contextPath}"></c:set>
</head>
<body>
<div class="container">
           
           <h1 style="color: brown"> Summary of Charges</h1>
  <table class="table table-hover">
  
    <tbody>
 
      <tr style="color: black">
        <td><b>Base price :</b></td>
        <td>${basePrice}</td>   
      </tr>

 	<tr style="color: black">
        <td><b>Tax :</b></td>
        <td>${tax}</td>   
      </tr>
      <hr>
       <tr style="color: black">
        <td><b>Total charges :</b></td>
        <td>${totalPrice}</td>   
      </tr>
    </tbody>
  </table>
</div>

<a href="${url}/pikaa/reserve">Continue...</a>

</body>
</html>