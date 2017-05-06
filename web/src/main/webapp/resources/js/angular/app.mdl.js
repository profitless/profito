'use strict';

const angular = require('angular');
require('angular-resource');
require('angular-cookies');

angular.module('app', [
    //Angular modules
    'ngResource',
    'ngCookies'])
    .run(function ($http, $cookies) {
        $http.defaults.headers.common['X-CSRF-TOKEN'] = $cookies.get('X-CSRF-TOKEN');
    });

