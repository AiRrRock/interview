(function () {
    angular
        .module('students-front', ['ngRoute', 'ngStorage'])
        .config(config)
        .run(run);

    function config($routeProvider) {
        $routeProvider
            .when('/', {
                templateUrl: 'student/students.html',
                controller: 'studentsController'
            })
            .when('/', {
                  templateUrl: 'student/edit_student.html',
                  controller: 'editStudentsController'
            })
            .otherwise({
                redirectTo: '/'
            });
    }

    function run($rootScope, $http, $localStorage) {
     }
})();

angular.module('students-front').controller('indexController', function ($rootScope, $scope, $http, $localStorage) {
    const contextPath = 'http://localhost:8189/students';

   });