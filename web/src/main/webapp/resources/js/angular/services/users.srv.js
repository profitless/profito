'use strict';

const angular = require('angular');
require('angular-resource');
require('angular-cookies');

angular
    .module('app')
    .factory('usersSrv',
        function ($resource) {
            return $resource('users', {}, {
                    register: {
                        method: 'POST',
                        isArray: true
                    }
            });
        }
    );