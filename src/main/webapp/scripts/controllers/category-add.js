'use strict';

angular.module('letusgoApp')
    .controller('CategoryAddCtrl', function ($scope, $location, CategoryService) {

        function addCategory(callback) {
            $scope.addcategory.id = null;
            CategoryService.addCategoryInfo($scope.addcategory, function (data) {
                callback(data);
            });
        }

        $scope.$emit('to-parent-manage');

        $scope.addcategory = {};
        $scope.tip = '';

        CategoryService.getAllCategoryInfo(function (data) {
            $scope.categorys = data;
        });

        $scope.addCategoryInfo = function () {
            if ($scope.addcategory.name !== undefined) {
                $scope.tip = '';
                addCategory(function (data) {
                    if(data === 'success') {
                        $location.path('/category');
                    }
                });
            } else {
                $scope.tip = '请输入类别!';
            }
        };

    });
