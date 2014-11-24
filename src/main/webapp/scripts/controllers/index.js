'use strict';

angular.module('letusgoApp')
    .controller('IndexController', function ($scope, CartService, UserService) {
        $scope.user = null;
        $scope.userName = '登录/注册';

        $scope.login = function() {
            UserService.getUserByName($scope.user.name, function (user) {
                if(user.password === $scope.user.password) {
                    $scope.userName = user.name;
                } else {
                    $scope.userName = '登录/注册';
                    alert("用户名或密码错误！");
                }
            });
        };

        $scope.register = function() {
            $scope.user.id = null;
            $scope.user.rank = 1;
            UserService.addUser($scope.user, function (data) {
                if(data === 'success') {
                    $scope.userName = $scope.user.name;
                    alert('注册成功，您已登录！');
                } else {
                    alert('注册失败！');
                }
            });
        };

        function barActivity(main, list, cart, manage) {
            $scope.activeMainbar = main;
            $scope.activeListbar = list;
            $scope.activeCartbar = cart;
            $scope.activeManagebar = manage;
        }

        $scope.amounts = CartService.getAmount();

        $scope.$on('to-parent-changeamounts', function () {
            $scope.amounts = CartService.getAmount();
        });

        $scope.$on('to-parent-inmain', function () {
            barActivity(true, false, false, false);
        });

        $scope.$on('to-parent-inlist', function () {
            $scope.amounts = CartService.getAmount();
            barActivity(false, true, false, false);
        });

        $scope.$on('to-parent-incart', function () {
            barActivity(false, false, true, false);
        });

        $scope.$on('to-parent-manage', function () {
            barActivity(false, false, false, true);
        });

    });
