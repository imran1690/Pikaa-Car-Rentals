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
           
           <h1 style="color: brown"> Choose the Car of your choice ! </h1>
  <table class="table table-hover">
    <thead>
      <tr style="color: red">
        <th>Car Type</th>
        <th>Available Cars</th>
        <th>price(per day)</th>
      </tr>
    </thead>
    <tbody>
    
      <tr style="color: black">
        <td>Economy</td>
        <td>${availCars_Economy}</td>
        <td>$19.50</td>
        <td><a href="${url}/pikaa/price/1">select</a></td>
      </tr>
      
      <tr style="color: black">
        <td>Compact</td>
        <td>${availCars_Compact}</td>
        <td>$21.50</td>
        <td><a href="${url}/pikaa/price/2">select</a></td>
      </tr>
      
      <tr style="color: black">
        <td>Intermediate</td>
        <td>${availCars_Intermediate}</td>
        <td>$23.25</td>
        <td><a href="${url}/pikaa/price/3">select</a></td>
      </tr>
      
      <tr style="color: black">
        <td>Standard</td>
        <td>${availCars_Standard}</td>
        <td>$25.50</td>
        <td><a href="${url}/pikaa/price/4">select</a></td>
      </tr>
      
      <tr style="color: black">
        <td>Full Size</td>
        <td>${availCars_FullSize}</td>
        <td>$27.00</td>
        <td><a href="${url}/pikaa/price/5">select</a></td>
      </tr>
      
      <tr style="color: black">
        <td>Premium</td>
        <td>${availCars_Premium}</td>
        <td>$32.50</td>
        <td><a href="${url}/pikaa/price/6">select</a></td>
      </tr>
    </tbody>
  </table>
</div>


</body>
</html>