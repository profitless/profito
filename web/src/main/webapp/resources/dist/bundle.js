webpackJsonp([1],[
/* 0 */,
/* 1 */,
/* 2 */,
/* 3 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


const angular = __webpack_require__(0);
__webpack_require__(2);
__webpack_require__(1);

angular.module('app', [
    //Angular modules
    'ngResource',
    'ngCookies'])
    .run(function ($http, $cookies) {
        $http.defaults.headers.common['X-CSRF-TOKEN'] = $cookies.get('X-CSRF-TOKEN');
    });



/***/ }),
/* 4 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


const angular = __webpack_require__(0);
__webpack_require__(2);
__webpack_require__(1);

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

/***/ }),
/* 5 */
/***/ (function(module, exports, __webpack_require__) {

"use strict";


const angular = __webpack_require__(0);

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


/***/ }),
/* 6 */,
/* 7 */,
/* 8 */,
/* 9 */
/***/ (function(module, exports, __webpack_require__) {

__webpack_require__(3);
__webpack_require__(5);
module.exports = __webpack_require__(4);


/***/ })
],[9]);