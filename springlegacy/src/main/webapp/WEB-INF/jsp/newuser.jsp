<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	${status}
	<form action="<c:url value='/admin/newuser'></c:url>" method="post">
		<input type="text" placeholder="ide nevet!" name="username" value="${username}">
		<input type="text" name="credit" value="${credit}"> <br />
		
		<label>Iskolai végzettség:</label><br />
		
		<select name="school">
			<option value="HIGHSCHOOL" ${HIGHSCHOOL}>Középiskola</option>
		 	<option value="COLLEGE" ${COLLEGE}>Főiskola</option>
		  	<option value="UNIVERSITY" ${UNIVERSITY}>Egyetem</option>
		</select><br />
		
		<label>Kedvenc színek:</label> <br />
		Red <input type="checkbox" name="favcol" value="red" ${RED}> <br />
		Green <input type="checkbox" name="favcol" value="green" ${GREEN}> <br />
		Blue <input type="checkbox" name="favcol" value="blue" ${BLUE}> <br />
		
		<label>Nem:</label><br />
		
		<input type="radio" name="gend" value="male" ${male}> Male<br> 
		<input type="radio" name="gend" value="female" ${female}> Female<br>

		<input type="submit">
	</form>
</body>
</html>