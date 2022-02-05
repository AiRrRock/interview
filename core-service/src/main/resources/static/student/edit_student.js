angular.module('students-front').controller('editStudentsController', function ($scope, $http, $routeParams, $location) {
    const contextPath = 'http://localhost:8189/students/';

    $scope.prepareStudentForUpdate = function () {
        $http.get(contextPath + 'api/v1/students/' + $routeParams.studentId)
            .then(function successCallback (response) {
                $scope.updated_student = response.data;
            }, function failureCallback (response) {
                console.log(response);
            });
    }

    $scope.updateStudents = function () {
        $http.put(contextPath + 'api/v1/students', $scope.updated_student)
            .then(function successCallback (response) {
                $scope.updated_product = null;
                $location.path('/students');
            }, function failureCallback (response) {
                alert(response.data.messages);
            });
    }

    $scope.prepareStudentForUpdate();
});