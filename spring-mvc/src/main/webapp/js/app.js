/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

var app = angular.module("app", ['ngRoute']);

app.config(['$routeProvider', function($routeProvider) {

        $routeProvider
                .when('/user-list', {
                    templateUrl: 'views/user-list.html',
                    controller: 'UserListController'
                })
                .when('/add-user', {
                    templateUrl: 'views/add-user.html',
                    controller: 'AddUserController'
                })
                .when('/view-user/:idUser', {
                    templateUrl: 'views/view-user.html',
                    controller: 'UserController'
                })
                .when('/error', {
                    templateUrl: 'views/error.html',
                    controller: 'ErrorController'
                })
                .otherwise({
                    redirectTo: '/'
                });
    }]);

function RemoteResource($http, $q, baseUrl) {
    this.get = function(idUser) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'GET',
            url: baseUrl + '/api/User/' + idUser
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(function(data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };

    this.list = function() {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'GET',
            url: baseUrl + '/api/User'
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(function(data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });


        return promise;
    };

    this.insert = function(user) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'POST',
            url: baseUrl + '/api/User',
            data: user
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(function(data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };

    this.update = function(idUser, user) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'PUT',
            url: baseUrl + '/api/User/' + idUser,
            data: user
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(function(data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };

    this.delete = function(idUser) {
        var defered = $q.defer();
        var promise = defered.promise;

        $http({
            method: 'DELETE',
            url: baseUrl + '/api/User/' + idUser
        }).success(function(data, status, headers, config) {
            defered.resolve(data);
        }).error(function(data, status, headers, config) {
            if (status === 400) {
                defered.reject(data);
            } else {
                throw new Error("Fallo obtener los datos:" + status + "\n" + data);
            }
        });

        return promise;
    };
}

function RemoteResourceProvider() {
    var _baseUrl;
    this.setBaseUrl = function(baseUrl) {
        _baseUrl = baseUrl;
    };
    this.$get = ['$http', '$q', function($http, $q) {
            return new RemoteResource($http, $q, _baseUrl);
        }];
}

app.provider("remoteResource", RemoteResourceProvider);

app.constant("baseUrl", ".");

app.config(['baseUrl', 'remoteResourceProvider',
    function(baseUrl, remoteResourceProvider) {
        remoteResourceProvider.setBaseUrl(baseUrl);
    }
]);

app.controller("IndexController", ['$scope', '$log', function($scope, $log) {

        $log.debug('Dentro de IndexController');
        $scope.urlMenu = "views/menu.html";
    }]);

app.controller("MenuController", ['$scope', '$log', function($scope, $log) {

        $log.debug('Dentro de MenuController');
    }]);

app.controller("UserListController", ['$scope', '$log', 'remoteResource', function($scope, $log, remoteResource) {

        $log.debug('Dentro de UserListController');

        remoteResource.list().then(function(users) {
            $scope.users = users;
        }, function(status) {
            alert("Ha fallado la petición. Estado HTTP:" + status);
        });

    }]);

app.controller("UserController", ['$scope', '$route', '$log', '$location', 'remoteResource', function($scope, $route, $log, $location, remoteResource) {

        $log.debug('Dentro de UserController');

        remoteResource.get($route.current.params.idUser).then(function(user) {
            $scope.user = user;
        }, function(status) {
            alert("Ha fallado la petición. Estado HTTP:" + status);
        });

        $scope.edit = function() {
            remoteResource.update($scope.user.id, $scope.user).then(function() {
                $location.path("/user-list");
            }, function(status) {
                alert("Ha fallado la petición. Estado HTTP:" + status);
            });
        };

        $scope.delete = function() {
            remoteResource.delete($scope.user.id).then(function() {
                $location.path("/user-list");
            }, function(status) {
                alert("Ha fallado la petición. Estado HTTP:" + status);
            });
        };

        $scope.disableEditButton = function() {
            return $scope.userInfo.$pristine;
        };

    }]);


app.controller("AddUserController", ['$scope', '$log', '$location', 'remoteResource', function($scope, $log, $location, remoteResource) {

        $log.debug('Dentro de AddUserController');

        $scope.user = {
            id : 0,
            name: "",
            email: ""
        };

        $scope.add = function() {
            remoteResource.insert($scope.user).then(function() {
                $location.path("/user-list");
            }, function(status) {
                alert("Ha fallado la petición. Estado HTTP:" + status);
            });
        };

    }]);