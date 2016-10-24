<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page isELIgnored="false"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-aria.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-messages.min.js"></script>
<script
	src="https://ajax.googleapis.com/ajax/libs/angular_material/1.0.0/angular-material.min.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular.min.js"></script>
<title>Insert title here</title>

<style>
input.ng-invalid {
	background-color: red;
}

input.ng-valid {
	background-color: lightgreen;
}
</style>
<script type="text/javascript">
	var appReg = angular.module("register", [ 'ngMessages', 'ngMaterial' ]);
	appReg.controller("regController", function($scope, $http) {
		$scope.register = function() {
			var elements = [];
			console.log($scope.ruser);
			
			for ( var index in $scope.colorValues) {				
				if ($scope.colorValues[index].enabled == true) {
					elements.push($scope.colorValues[index].colorCode);
				}
			}
			$http.post("registeruserangular", {
				username : $scope.ruser.username,
				credit : $scope.ruser.credit,
				school : $scope.ruser.school,
				favcol : elements,
				gend : $scope.ruser.sex
			}).then(function(response) {

				if (response.data == 1) {
					$scope.rusername = "";
					$scope.rcredit = "";
					//$scope.rschool
					for ( var color in $scope.colors) {
						$scope.colors[color] = false;
					}
					$scope.sex = "MALE"
					$scope.regStatus = "OK!"
					$scope.getUsers();
				} else {
					$scope.regStatus = "Registration error!"
				}
			});
		}
		$scope.schools;
		$scope.elements = function() {
			$http.get("getschools").then(function(response) {
				$scope.schools = response.data;
			});
		};
		$scope.getColors = function() {
			$http.get("getcolors").then(function(response) {
				$scope.colorValues = response.data;
			});
		}

		$scope.getUsers = function() {
			$http.get("getusers").then(function(response) {

				$scope.users = response.data;

			});
		}
		$scope.getUsers();
		$scope.sex = "MALE";
		$scope.getColors();
		//$scope.colors = {Red: true, Green : false};
		$scope.elements();
	});
</script>

</head>
<body>
	<div data-ng-app="register" data-ng-controller="regController">
		<h2>Registration</h2>
		<p>{{regStatus}}</p>
		<md-content layout-padding>
		<form name="userdata">
			<md-input-container> <label>Username</label> <input
				type="text" name="username" data-ng-model="ruser.username"
				data-ng-minlength="3" data-ng-maxlength="10" required>
			<p data-ng-show="userdata.username.$error.minlength">A hossz túl
				kicsi!</p>
			<p data-ng-show="userdata.username.$error.maxlength">A hossz túl
				nagy!</p>
			<p ng-show="userForm.username.$error.required">A mező kötelező!</p>
			</md-input-container>
			<br /> 
			<md-input-container> 
			<label>Credit</label> <input type="text"
				data-ng-model="ruser.credit" data-ng-pattern="/^[0-9]{1,10}$/"
				required>
				</md-input-container> <br />
			<md-container> <md-select data-ng-model="ruser.school">
				<md-option value="{{elem.key}}" data-ng-repeat="elem in schools"
					selected="selected">{{elem.value}}</md-option>
			</md-select> 
			</md-container> <br /><br />
			<md-container> 
			<label ng-repeat="color in colorValues"> <md-checkbox ng-checked="color.enabled" value="color.colorCode"
				ng-click="color.enabled = !color.enabled"/> {{color.colorValue}}</label>
			</md-container> <br /><br />
		 	<md-radio-group ng-model="ruser.sex"> 
		 	<md-radio-button value="MALE" aria-label="Male" ng-checked> Male</md-radio-button>
			 <br /> <md-radio-button 
			 value="FEMALE" aria-label="Female"> Female</md-radio-button>
			</md-radio-group>
			
		</form>
		</md-content>

		
		<button data-ng-click="register()">Register</button>

		<h2>Users:</h2>
		<table id="tablazat" data-ng-model="users">
			<thead>
				<tr>
					<th>Name</th>
					<th>Credit</th>
					<th>Schools</th>
					<th>Favourite colors</th>
					<th>Gender</th>
				</tr>
			</thead>
			<tbody>
				<tr ng-repeat="adat in users">
					<td>{{adat.username}}</td>
					<td>{{adat.credit}}</td>
					<td>{{adat.school}}</td>
					<td><p ng-repeat="data2 in adat.favcols">{{data2}}</p></td>
					<td>{{adat.gend}}</td>
				</tr>
			</tbody>
		</table>
	</div>


</body>
</html>