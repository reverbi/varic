var angControllers = angular.module('myApp.controllers', [])
  .controller('ButtonController', ['$scope', function ($scope) {
    $scope.singleModel = 1;
}]);
