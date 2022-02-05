angular.module('students-front').controller('studentsController', function ($scope, $http, $location) {
    const contextPath = 'http://localhost:8189/students/';

    $scope.loadStudents = function (pageIndex = 1) {
        currentPageIndex = pageIndex;
        $http({
            url: contextPath + 'api/v1/students',
            method: 'GET'
        }).then(function (response) {
            console.log(response);
            $scope.productsPage = response.data;
        });
    };


    $scope.navToEditProductPage = function (studentId) {
        $location.path('/edit_student/' + studentId);
    }

    $scope.loadStudents();
});