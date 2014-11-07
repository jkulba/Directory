'use strict';

/**
 * Main module of the Directory Application.
 */
var app = angular.module('directoryApp', [
  'ui.router',
  'ngResource'
  ]);

app.config(function($stateProvider, $urlRouterProvider) {
  $urlRouterProvider.otherwise('/home');

  $stateProvider
    // HOME STATES AND NESTED VIEWS ========================================
    .state('home', {
      url: '/home',
      templateUrl: 'views/partial-home.html'
    })

// nested list with custom controller
    .state('home.list', {
        url: '/list',
        templateUrl: 'views/partial-home-list.html',
        controller: function($scope) {
            $scope.dogs = ['Bernese', 'Husky', 'Goldendoodle'];
        }
    })

    // nested list with just some random string data
    .state('home.paragraph', {
        url: '/paragraph',
        template: 'I could sure use a drink right now.'
    })

    // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
       .state('about', {
        url: '/about',
        views: {

            // the main template will be placed here (relatively named)
            '': { templateUrl: 'views/partial-about.html' },

            // the child views will be defined here (absolutely named)
            'columnOne@about': { 
              templateUrl: 'views/partial-search-filter.html'
            },

            // for column two, we'll define a separate controller 
            'columnTwo@about': { 
                templateUrl: 'views/table-data.html',
                controller: 'scotchController'
            }
        }
        
    })
       // ABOUT PAGE AND MULTIPLE NAMED VIEWS =================================
       .state('search', {
        url: '/search',
        views: {

            // the main template will be placed here (relatively named)
            '': { templateUrl: 'views/partial-search.html' },

            // the child views will be defined here (absolutely named)
            'columnOne@about': { 
              templateUrl: 'views/partial-search-filter.html'
            },

            // for column two, we'll define a separate controller 
            'columnTwo@about': { 
                templateUrl: 'views/table-data.html',
                controller: 'scotchController'
            }
        }
        
    });


});
