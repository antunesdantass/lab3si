todoApp.controller('todoController', ['$scope', '$http', function($scope, $http) {

  $scope.listas = [];

  var getListas = {
    url : 'http://localhost:8080/listas',
    method : 'GET'
  };

  var getListaEspecifica = {
    url : 'http://localhost:8080/listas',
    method : 'GET'
  };

  $scope.listaAtual;

  $scope.carregarListas = function() {
    $http(getListas).then(function successCallback(response) {
      $scope.listas = response.data;
    })
  };

  $scope.carregarListas();

  $scope.mostraDetalhes = function(id) {
    getListaEspecifica.url = getListaEspecifica.url + '/' + id;
    $http(getListaEspecifica).then(function successCallback(response) {
      $scope.listaAtual = response.data;
      getListaEspecifica.url = getListas.url;
    })
  };

  $scope.deletarTodasListas = function() {
    $http({url : getListas.url, method : 'DELETE'}).then(function successCallback(response) {
      $scope.listas = [];
    })
  };

}]);