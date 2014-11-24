'use strict';

angular.module('letusgoApp')
    .service('CategoryService', function ($http, ProductService) {

        function getCategories(callback) {
            $http.get('/categories')
                .success(function (data) {
                    callback(data);
                });
        }

        function getCategoryById(id, callback) {
            $http.get('/categories/' + id)
                .success(function (data) {
                    callback(data);
                });
        }

        function addCategory(category, callback) {
            $http.post('/categories', {'id': category.id, 'name': category.name})
                .success(function () {
                    callback('success');
                });
        }

        function updateCategory(category, callback) {
            var id = category.id;
            $http.put('/categories/' + id, {'id': category.id, 'name': category.name})
                .success(function () {
                    callback('success');
                });
        }

        function removeCategory(category, callback) {
            var id = category.id;
            $http.delete('/categories/' + id)
                .success(function () {
                    callback('success');
                });
        }

        this.getAllCategoryInfo = function (callback) {
            getCategories(function (data) {
                callback(data);
            });
        };

        this.getCategoryInfoById = function (id, callback) {
            getCategoryById(id, function (data) {
                callback(data);
            });
        };

        this.addCategoryInfo = function (categoryInfo, callback) {
            addCategory(categoryInfo, function (data) {
                callback(data);
            });
        };

        this.removeCategoryInfo = function (categoryInfo, callback) {
            if (isRemove(categoryInfo)) {
                removeCategory(categoryInfo, function () {
                    callback('success');
                });
            } else {
                callback('failed');
            }
        };

        var isRemove = function (categoryInfo) {
            var productList = null;
            var result = true;
            ProductService.getAllProductInfo(function (data) {
                productList = data;
                _.forEach(productList, function (item) {
                    if (result === true && item.category.id === categoryInfo.id) {
                        result = false;
                    }
                });
                return result;
            });
        };

        this.updateCategoryInfo = function (categoryInfo, callback) {
            updateCategory(categoryInfo, function (data) {
                callback(data);
            });
        };
    });
