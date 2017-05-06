'use strict';

const angular = require('angular');

angular
    .module('app')
    .controller('UserRegistrationCtrl', function ($scope, usersSrv) {
        const vm = this;
        vm.register = function () {
            usersSrv.register(
                vm.user,
                function () {
          });
        };
    });
