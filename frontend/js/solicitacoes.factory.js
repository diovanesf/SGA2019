angular.module("solicitacoes").factory("TodasSolicitacoes", function($q, $http){
    return{
        listar: function(){
            var promessa = $q.defer();

            $http.get("colocar aqui a url").then(function(){
                function(result){
                    var solicitacoes = [];
                    
                    angular.forEach(result.data, function(solicitacao, id){
                        solicitacao.id = id;
                        solicitacoes.push(solicitacao);
                    });
                    promessa.resolve(solicitacoes);
                };
            }
            );

            return promessa.promise;
        },
        inserir: function(solicitacao){
            return $http.put("url do serviço de inclusao", solicitacao);
        },
        remover: function(id){
            return $http.delete();
        }
    };
});