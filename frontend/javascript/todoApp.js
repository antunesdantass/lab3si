var todoApp = angular.module('todoApp', ['ngRoute']);

todoApp.config(function($routeProvider, $locationProvider) {
       $locationProvider.html5Mode({
            enabled: true,
            requireBase: false
});
        $routeProvider

            // route for the home page
            .when('/', {
                templateUrl : 'views/home.html',
                controller  : 'todoController'
            })

            .when('/listas', {
                templateUrl : 'views/home.html',
                controller : 'todoController'
            })

            // route for the about page
            .when('/criar', {
                templateUrl : 'views/criar.html',
                controller  : 'criarController'
            })

            // route for the contact page
            .when('/sobre', {
                templateUrl : 'views/sobre.html',
                controller  : 'sobreController'
            });
    });