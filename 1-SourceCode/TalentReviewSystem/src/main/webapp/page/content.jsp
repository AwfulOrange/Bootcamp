<%-- 
    Document   : content
    Created on : Mar 14, 2016, 3:23:28 PM
    Author     : bootcamp19
--%>


<body class="contentStyle">
 <div class="contentStyle" ng-app="myApp" ng-controller="customersCtrl">

<ul ng-repeat="x in names">{{x.Name}}
  <li >
    {{  x.Country }}
  </li>
</ul>

</div>

<script>
var app = angular.module('myApp', []);
app.controller('customersCtrl', function($scope, $http) {
    $http.get("http://10.2.1.183:8080/TRS/test/test_1")
    .success(function(response) {$scope.names = response.records;});
});
</script> 
</body>
