<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	background-color: pink;
}

input.ng-valid {
	background-color: lightgreen;
}

.menuStyle {
	background-color : lightblue;
	
}
</style>
<script type="text/javascript">
	var appReg = angular.module("register", [ 'ngMessages', 'ngMaterial' ]);
	// Service layer
	appReg.service("$pageService", function($http, $mdToast) {
		this.deleteUser = function(userid, resultSuccess, resultFailed) {
			$http.post("deleteuser", userid).then(resultSuccess, resultFailed);
		}
		this.showToast = function(message) {
			 $mdToast.show(
                     $mdToast.simple()
                        .textContent(message)                       
                        .hideDelay(3000)
             );
		}
		this.registerUser = function(userData, resultSuccess, resultFailed) {
			$http.post("registeruserangular", userData).then(resultSuccess, resultFailed);
		}
		this.filterColors = function(colors) {
			var elements = [];
			for ( var index in colors) {
				if (colors[index].enabled == true) {
					elements.push(colors[index].colorCode);
				}
			}
			return elements;
		}
	});
	appReg.controller("regController", function($scope, $http, $mdToast,
			$mdDialog, $pageService) {
		$scope.register = function() {
			var colors = $pageService.filterColors($scope.colorValues);
			
			var userData = {
				username : $scope.ruser.username,
				credit : $scope.ruser.credit,
				school : $scope.ruser.school,
				favcol : colors,
				gend : $scope.ruser.sex
			}
			var success = function(response) {
				if (response.data == 1) {
					$scope.ruser.username = "";
					$scope.ruser.credit = "";
					//$scope.rschool
					for ( var color in $scope.colorValues) {
						$scope.colorValues[color].enabled = false;
					}
					$scope.ruser.sex = "MALE";
					$scope.enabledRegistration = false;
					$pageService.showToast("Registration success!");
					$scope.getUsers();
				} else {
					$pageService.showToast("Registration failed!");
				}
			}
			
			var failed = function() {
				$pageService.showToast("Registration failed!");
			}
			
			$pageService.registerUser(userData, success, failed); 
	
		}
		
		$scope.performlogout = function() {
			console.log("dsadas");
			
			$http.post("<c:url value='/logout'></c:url>",{}).then(function(response) {
				document.write(response.data);
				console.log(response);
			}, function(response) {
				console.log(response);
			});
			
		};
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
		
		$scope.deleteuser = function(username) {
	
			var dialog = $mdDialog.confirm().title("Delete confirm!").textContent("Text content!").ok("Yes!").cancel("NO!");
			$mdDialog.show(dialog).then(function() {
				var success = function() {
					$scope.getUsers();
					$pageService.showToast("User deleted!");
				}
				
				var failed = function() {
					$pageService.showToast("Delete failed! :'(");
				}
				$pageService.deleteUser(username,success, failed);
			}, function() {
				
			});
		}

		/////////////////////////////////////////////////////////////////////////////6
		// initialization
		$scope.getUsers();
		$scope.sex = "MALE";
		$scope.getColors();
		$scope.enabledRegistration = false;
		//$scope.colors = {Red: true, Green : false};
		$scope.elements();
	});
</script>

</head>
<body data-ng-app="register" data-ng-controller="regController">
	<div>
		<div layout="row">
			<div flex="100">
				<div class="menuStyle">
				<md-button class="md-raised" ng-click="enabledRegistration = !enabledRegistration">Regisztráció!</md-button>
				Welcome: <sec:authentication property="principal.username"  />
				<md-button class="md-raised" ng-click="performlogout()">Logout</md-button>
				<a href="<c:url value='/logout'></c:url>">Logout</a>
				
				</div>
				
			</div>
		</div>
		<div layout="row" ng-show="enabledRegistration">
			<div flex="33">
				<h2>Registration</h2>
				<p>{{regStatus}}</p>
				<md-content layout-padding>
				<form name="userdata">
					<md-input-container> <label>Username</label> <input
						type="text" name="username" data-ng-model="ruser.username"
						data-ng-minlength="3" data-ng-maxlength="10" required>
					<div data-ng-show="userdata.username.$touched"
						data-ng-messages="userdata.username.$error">
						<p data-ng-show="userdata.username.$error.minlength">A hossz
							túl kicsi!</p>
						<p data-ng-show="userdata.username.$error.maxlength">A hossz
							túl nagy!</p>
						<p ng-show="userForm.username.$error.required">A mező
							kötelező!</p>
					</div>
					</md-input-container>
					<br />
					<md-input-container> <label>Credit</label> <input
						type="text" data-ng-model="ruser.credit"
						data-ng-pattern="/^[0-9]{1,10}$/" required> </md-input-container>
					<br />
					<md-container> <md-select
						data-ng-model="ruser.school"> <md-option
						value="{{elem.key}}" data-ng-repeat="elem in schools"
						selected="selected">{{elem.value}}</md-option> </md-select> </md-container>
					<br /> <br />
					<md-container> <label
						ng-repeat="color in colorValues"> <md-checkbox
							ng-checked="color.enabled" value="color.colorCode"
							ng-click="color.enabled = !color.enabled" />
						{{color.colorValue}}
					</label> </md-container>
					<br /> <br />
					<md-radio-group ng-model="ruser.sex" required> <md-radio-button
						value="MALE" aria-label="Male" ng-checked> Male</md-radio-button>
					<br />
					<md-radio-button value="FEMALE" aria-label="Female">
					Female</md-radio-button> </md-radio-group>
					<md-button class="md-raised" data-ng-click="register()"
						ng-disabled="userdata.$invalid">Register</md-button>
				</form>
				</md-content>
			</div>
		</div>


		<div layout="row" layout-wrap>
			<div layout="column" data-ng-repeat="user in users">
				<md-card>
					<md-card-header>
						<md-card-header-text>
						<span class="md-title">User details:</span>
						</md-card-header-text>
					</md-card-header>
					<md-card-title>
						<md-card-title-text>
						<span class="md-headline">Name: {{user.username}}</span>
						<span class="md-headline">Credit: {{user.credit}}</span>
							<span class="md-headline">School: {{user.school}}</span>
						</md-card-title-text>
					</md-card-title>
					<md-card-content>
						<span class="md-headline">Colors:</span>
						<p data-ng-repeat="color in user.favcols">
							<span class="md-headline">{{color}}</span>
						</p>
					</md-card-content>
					<md-card-action>
						<md-button class="md-raised" ng-click="deleteuser(user.username)">Törlés</md-button>
					</md-card-action>
				</md-card>
			</div>
		</div>
		
	</div>


</body>
</html>