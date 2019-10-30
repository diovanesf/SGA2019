angular.module("solicitacoes").controller("SolicitacoesController", function($scope, TodasSolicitacoes){
    $scope.titulo = "Sistema para solicitação de ACG";

    TodasSolicitacoes.listar().then(function(solicitacoes){
        $scope.solicitacoes =  solicitacoes;
    });
    $scope.resetForm = function(){
        $scope.formulario.$setPristine();
        $scope.formulario.$setUntouched();
    };

    var carregarDados = function(){
        TodasSolicitacoes.listar().then(function(solicitacoes){
            $scope.solicitacoes = solicitacoes;
        });
    } 
    
    $scope.adicionarSolicitacao = function(){
        var solicitacao={
            solicitante: $scope.novaSolicitacao.solicitante,
            matricula: $scope.novaSolicitacao.matricula,
            grupo: $scope.novaSolicitacao.grupo,
            atividade: $scope.novaSolicitacao.atividade,
            cargaHorariaSolicitada: $scope.novaSolicitacao.cargaHorariaSolicitada,
            cargaHorariaAproveitada: $scope.novaSolicitacao.cargaHorariaAproveitada,
            files: $scope.novaSolicitacao.files


        };
        TodasSolicitacoes.inserir(solicitacao).then(carregarDados);
        $scope.novaSolicitacao = {};   

    }
    $scope.removerSolicitacao = function(id){
        TodasSolicitacoes.remover(id).then(carregarDados);
    }

    carregarDados();

})
