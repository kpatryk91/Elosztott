<%@page isELIgnored="false" %>
<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>Ez egy adatokat megjelenito jsp file!</h1>
<h2>Tartalom: adatok</h2>

<% String[] adatok = new String[] {"adat1", "adat2", "adat3", "adat4", "adat5"}; %>
<table>
	<c:forEach items="adatok" var="adat">
		<tr>
			<td>${adat}</td>
		 </tr>
	</c:forEach>
</table>
</body>
</html>