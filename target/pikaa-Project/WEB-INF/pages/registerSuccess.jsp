<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<c:set var="url" value="${pageContext.request.contextPath}"></c:set>
</head>
<body>
<h2>
<pre>

Congratulations ${renterName} !!!
You have successfully made a reservation with pikaa. 

</pre>
</h2>
<br><br><br><br><br>
<p>If you need any assistance, you can contact us via email or telephone</p>
<br><br>
<a href="${url}/pikaa/welcome">Go to Home Page</a>
</body>
</html>