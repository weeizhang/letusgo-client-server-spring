'use strict';

angular.module('letusgoApp')
    .service('UserService', function ($http) {

        function getUserByName(name, callback) {
            $http.get('/users/' + name)
                .success(function (data) {
                    callback(data);
                });
        }

        function addUser(user, callback) {
            $http.post('/users', {'id': user.id,
                'name': user.name,
                'password': user.password,
                'rank': user.rank})
                .success(function () {
                    callback('success');
                });
        }

        this.getUserByName = function (name, callback) {
            getUserByName(name, function (data) {
                callback(data);
            });
        };

        this.addUser = function (user, callback) {
            addUser(user, function (data) {
                callback(data);
            });
        };

    });


