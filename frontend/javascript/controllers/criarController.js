todoApp.controller('criarController', ['$scope', '$http', function($scope, $http) {

    var listaId;
    var tarefaId;
    $scope.mostrarForm = false;
    
    $scope.subTarefas = [];

    var salvarLista = {
        url : 'http://localhost:8080/listas',
        method : 'POST'
    };

    var adicionarTarefa = {
        url : 'http://localhost:8080/listas/',
        method : 'POST'
    }

    $scope.formNSubmetido = function() {
        return listaId in window;
    }

    $scope.addSubTarefa = function(subTarefa) {
        subTarefa.feita = false;
        $scope.subTarefas.push(subTarefa);
        delete $scope.subTarefa;
    }

    $scope.addLista = function(listaDeTarefa) {
        salvarLista.data = listaDeTarefa;
        $http(salvarLista).then(function successCallback(data) {
            listaId = data.data.id;
            delete $scope.listaDeTarefa;
            salvarLista.data = null;
        });
    };

    $scope.addTarefa = function (tarefa) {
        adicionarTarefa.data = tarefa;
        adicionarTarefa.url = adicionarTarefa.url + listaId;
        if (tarefa.prioridade in window) {
            tarefa.prioridade = "BAIXA";
        }
        tarefa.prioridade = tarefa.prioridade.toUpperCase();
        tarefa.subTarefas = $scope.subTarefas;
        $http(adicionarTarefa).then(function sucessCallback(data) {
            tarefaId = data.data.id;
            delete $scope.tarefa;
            adicionarTarefa.data = null;
            adicionarTarefa.url = salvarLista.url + '/';
            $scope.subTarefas = [];
        });
    };
 
    $scope.processarForm = function() {
        $scope.mostrarForm = true;
}

    $('#demolist li').on('click', function(){
        $('#prioridadeBox').val($scope.tarefa.prioridade = $(this).text());

}); 

}]);