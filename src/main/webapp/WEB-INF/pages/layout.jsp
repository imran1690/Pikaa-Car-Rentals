<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
 <table border="1" cellpadding="2" cellspacing="2" align="center">

  <tr>
    <td height="80" width="1250" style="background-color:#6699ff">
    <tiles:insertAttribute name="header"></tiles:insertAttribute>
    </td>
  </tr>
  <tr>
      <td height="500" width="1250" style="background-color:#ffffff">
    <tiles:insertAttribute name="body"></tiles:insertAttribute>
    </td>
     
  </tr>
  <tr>
 
 
  <td height="30" width="1250"  style="background-color:#b3ccff">
    <tiles:insertAttribute name="footer"/>
</td>
  </tr>
</table>
</body>
</html>