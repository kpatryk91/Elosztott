<%@ taglib prefix="c" 
           uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
${status}
<form action="<c:url value='/admin/newuser'></c:url>" method="post">
	<input type="text" placeholder="ide nevet!" name="username">
	<input type="text" name="credit">
	<input type="submit">
</form>
</body>
</html>