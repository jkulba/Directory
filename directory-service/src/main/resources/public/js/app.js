'use strict';

angular.module('pspServiceApp', [
    'ngResource',
    'ngRoute',
    'pspServiceApp.controllers',
    'pspServiceApp.services'
])

    .config(function ($routeProvider) {
        $routeProvider
        .when('/', {templateUrl: 'views/home.html'})
        .when('/about', {templateUrl: 'views/about.html', controller: 'AboutCtrl'})
        .when('/help', {templateUrl: 'views/help.html', controller: 'HelpCtrl'})
        .when('/failed', {templateUrl: 'views/failed.html', controller: 'FailedOrderCtrl'})
        .otherwise({redirect: '/'});
    });



    // Can also add the resolve object array for dependencies or promises.
