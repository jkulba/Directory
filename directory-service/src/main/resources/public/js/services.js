'use strict';

/* Services */

//var services = angular.module('pspServiceApp.services', ['ngResource']);
angular.module('pspServiceApp.services', []);
    var baseUrl = 'http://localhost\\:8080';

    .service("FailedOrderService", function( $http, $q ) {

        var request = $http({
            method: "get",
            url: baseUrl + "orderinfo/failedorders"
        });

        return( request.then( handleSuccess, handleError ) );

    function handleError( response ) {

    if (
        ! angular.isObject( response.data ) ||
        ! response.data.message
    ) {

        return( $q.reject( "An unknown error occurred." ) );

    }

        return( $q.reject( response.data.message ) );

    }


    function handleSuccess( response ) {
        return( response.data );
    }


        }


     );




//services.factory('OrdersFactory', function ($resource) {
//    return $resource(baseUrl + '/psp-service/orderinfo', {}, {
//        failedorders: { method: 'GET', isArray: true, cache: false }
//    })
//});
