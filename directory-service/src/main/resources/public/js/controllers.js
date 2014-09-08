'use strict';

/* Controllers */

var app = angular.module('pspServiceApp.controllers', []);

app.controller('HomeCtrl', function($scope) {});

app.controller('AboutCtrl', function($scope) {});

app.controller('HelpCtrl', function($scope) {});

app.controller('FailedOrderCtrl', function($scope, 'FailedOrderService') {});

function NavBarController($scope, $location) {
    $scope.isActive = function (viewLocation) {
        console.log(viewLocation)
        return viewLocation === $location.path();
    };
}

