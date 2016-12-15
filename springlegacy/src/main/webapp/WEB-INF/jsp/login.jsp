<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>

<script type="text/javascript">
	$(document).ready(function() {
		$("#sendreq").click(function(event){
			
			$.ajax({
				type : "POST",
				url : "<c:url value='/restoreemailrequest'></c:url>",
				data: {
					userid : $("#user").val()
				},
				success : function(result, status, xhr) {
					//if(result == true) {
						$("#resultDIV").html("<h2>" + result + "</h2>");
					//}
				}
			})
		});
	})
</script>
<body>

	<form action="<c:url value='/login'/>" method="post">
		<c:if test="${param.error != null}">
			<p>Invalid username and password.</p>
		</c:if>
		<c:if test="${param.logout != null}">
			<p>You have been logged out.</p>
		</c:if>
		<p>
			<label for="username">Username</label> <input type="text"
				id="username" name="username" />
		</p>
		<p>
			<label for="password">Password</label> <input type="password"
				id="password" name="password" />
		</p>
		<input type="hidden" name="${_csrf.parameterName}"
			value="${_csrf.token}" />
		<button type="submit" class="btn">Log in</button>
	</form>
	<div id="resultDIV"></div>
	<br /> <input type="button" value="Email igenyles!" id="sendreq"> <br> <input type="text" id="user" placholder="Userid"> 
</body>
</html>