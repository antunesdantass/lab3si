todoApp.controller('todoController', ['$scope', '$http', function($scope, $http) {

  $scope.listas = [];

  var api = {url : 'http://localhost:8080/listas'};

  var getListaEspecifica = {
    url : 'http://localhost:8080/listas',
    method : 'GET'
  };

  $scope.listaAtual;
  $scope.tarefaAtual;

  $scope.carregarListas = function() {
    $http(api).then(function successCallback(response) {
      $scope.listas = response.data;
    })
  };

  $scope.carregarListas();

  $scope.mostraDetalhes = function(id) {
    getListaEspecifica.url = getListaEspecifica.url + '/' + id;
    $http(getListaEspecifica).then(function successCallback(response) {
      $scope.listaAtual = response.data;
      getListaEspecifica.url = api.url;
    })
  };

  $scope.mostraTarefaDetalhes = function(id) {
    $http({url : api.url + '/' + $scope.listaAtual.id +'/' + id, method : 'GET'}).then(function successCallback(response) {
      $scope.tarefaAtual = response.data;
    })
  }

  $scope.deletarTodasListas = function() {
    $http({url : api.url, method : 'DELETE'}).then(function successCallback(response) {
      $scope.listas = [];
    })
  };

  $scope.deletarLista =  function(id) {
    $http({url : api.url + '/' + id, method : 'DELETE'}).then(
      function successCallback (response) {
        listaAtual = null;
        $scope.carregarListas();
      })
  };

  $scope.deletarTarefaLista = function(id) {
    $http({url : api.url + '/' + $scope.listaAtual.id + '/' + id, method : 'DELETE'}).then(
      function successCallback (response) {
        $scope.listaAtual = response.data;
      })
  };

  $scope.deletarSubTarefaLista = function(id) {
    $http({url : api.url + '/' + $scope.listaAtual.id + '/' + $scope.tarefaAtual.id + '/'+ id, method : 'DELETE'}).then(
      function successCallback (response) {
        $scope.tarefaAtual = response.data;
      })
  };

  $scope.tarefaFeita = function (tarefa, feita) {
			if (angular.isDefined(feita)) {
				tarefa.feita = feita;
			}
			$http({url : api.url + '/' + $scope.listaAtual.id + '/', method : 'PUT', data : tarefa})
				.then(function success() {}, function error() {
					tarefa.feita = !tarefa.feita;
				});
		};

}]);