<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
	var appReg = angular.module("register", []);
	appReg.controller("regController", function($scope, $http) {
		$scope.register = function() {
			$http.post("registeruserangular", {
				username : $scope.rusername, credit : $scope.rcredit}
			).then(function(response){
				console.log(response);
				if(response.data == 1) {
					$scope.regStatus = "OK!"
				} else {
					$scope.regStatus = "Registration error!"
				}
			});
		}
		$scope.schools;
		$scope.elements = function(){
			$http.get("getelements").then( function(response){
				console.log(response);
				$scope.schools =  response.data;
			});
		};
		$scope.elements();
	});
</script>

</head>
<body>
	<div data-ng-app="register" data-ng-controller="regController">
		<h2>Registration</h2>
		<p>{{regStatus}}</p>
		<label>Username</label> <input type="text" data-ng-model="rusername">
		<label>Credit</label> <input type="text" data-ng-model="rcredit">
		<select data-ng-option="">
			<option data-ng-repeat="elem in schools">{{elem}}</option>
		</select>
		<button data-ng-click="register()">Register</button>
	</div>

	<h2>Users:</h2>
	<table id="tablazat">
		<thead>
			<tr>
				<th><spring:message code="name"></spring:message></th>
				<th><spring:message code="credit"></spring:message></th>
				<th><spring:message code="school"></spring:message></th>
				<th><spring:message code="favcols"></spring:message></th>
				<th><spring:message code="gender"></spring:message></th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="user" items="${users}">
				<tr>
					<td>username</td>
					<td>credit</td>
					<td>school</td>
					<td>favourite color</td>
					<td>gender</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>