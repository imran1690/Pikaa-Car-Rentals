<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
	<c:set var="url" value="${pageContext.request.contextPath}"></c:set>
<style>
*{
	margin:0px;
	padding:0px;
}

body2{
	font-family: verdana;
	background-color:light blue;
	padding:50px;
}

/*rules for menu*/

ul#nav-menu,ul.nav-sub{
	list-style-type:none;
	font-size:12pt;
}

ul#nav-menu li{
	width:130px;
	text-align:center;
	position:relative;
	float:left;
	margin-right:0px;
}

ul#nav-menu a{
	text-decoration:none;
	display:block;
	width:125px;
	height:25px;
	line-height:25px;
	background-color:#ccccb3;
	border:1px solid #CCC;
	border-radius:5px;
}
ul#nav-menu .nav-sub li{
	

}
ul#nav-menu .nav-sub a{
	margin-top:2px;
}

ul#nav-menu li:hover > a{
	background-color:red;

}
ul#nav-menu li:hover a:hover{
	background-color:yellow;

}

ul#nav-menu ul.nav-sub{
	display:none;
	position:absolute;
	top:26px;
	left:0px;
}

ul#nav-menu li:hover .nav-sub{
	display:block;


}

.darrow{
	font-size:14pt;
	position:absolute;
	top:1px;
	right:8px;
}


</style>
</head>
<body>
<nav>
	<body2>
	<h1>
	<h2 style="text-align: center; color: white; text-shadow: -1px 0 black,0 1px black,1px 0 black, 0 -1px black; font-size: 30px">Pik..aa</h2>
	<img src="<c:url value="/resources/images/pikaalogo.png"/>" height="150px" width="250px"/>
	
	</h1>
	
	<ul id="nav-menu">
		<li><a style="background-color: #ccccb3; color: blue">Rent</a><span class="darrow">&#9660;</span>
		<ul class="nav-sub">
			<li><a href="${url}/pikaa/zipcode" style="background-color: #ccccb3; color: blue">Rent a Car</a></li>
		</ul>
		</li>
		<li><a href="#" style="background-color: #ccccb3">Locations</a>
		</li>
		<li><a href="${url}/pikaa/about" style="background-color: #ccccb3">About Us</a></li>
		<li><a href="#" style="background-color: #ccccb3">Careers</a></li>
	
	</ul>
		
</body2>
	</nav>
</body>
</html>