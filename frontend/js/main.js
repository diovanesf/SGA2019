const BASE_URL = "http://127.0.0.1:8000"

var selectorCurriculo = document.getElementById('selectorCurriculo')
var selectorGrupo = document.getElementById('selectorGrupo')
var selectorAtividade = document.getElementById('selectorAtividade')

var validationCH = document.getElementById('validationCH')
var validationCHaproveitamento = document.getElementById('validationCHaproveitamento')

// RECUPERANDO TIPOS DE CURRICULOS EXISTENTES PARA O CURSO
axios.get(`${BASE_URL}/curriculo`, {
    headers: {
        'Access-Control-Allow-Origin': '*'
    },
}).then(function (body) {
    var response = body.data
    var json = JSON.stringify(response)
    var obj = JSON.parse(json);
    obj.forEach(function (element){
        var opt = document.createElement("option");
        
        opt.value= element.id;
        opt.innerHTML = element.ano; 
        
        selectorCurriculo.appendChild(opt);
    });
})
.catch(function (error) {
    console.log(error)
})

function setGruposPorCurriculo(params){
    axios.get(`${BASE_URL}/curriculo/${params}`, {
        headers: {
            'Access-Control-Allow-Origin': '*',
        },
    }).then(function (body) {
        var response = body.data
        var json = JSON.stringify(response)
        var obj = JSON.parse(json);
        // selectorGrupo.options.innerHTML = "";
        while (selectorGrupo.firstChild) {
            console.log('whileee')
            selectorGrupo.removeChild(selectorGrupo.firstChild)
        }
        obj.grupos.forEach(function (element){
            var opt = document.createElement("option");
            
            opt.value= element.id;
            opt.innerHTML = element.nome; 
            
            selectorGrupo.appendChild(opt);
        });
    })
    .catch(function (error) {
        console.log(error)
    })
}

function setAtividadePorGrupo(params){
    axios.get(`${BASE_URL}/grupo/${params}`, {
        headers: {
            'Access-Control-Allow-Origin': '*',
        },
    }).then(function (body) {
        var response = body.data
        console.log(response)
        var json = JSON.stringify(response)
        var obj = JSON.parse(json);
        // selectorAtividade.options.innerHTML = "";
        while (selectorAtividade.firstChild) {
            console.log('whileee')
            selectorAtividade.removeChild(selectorAtividade.firstChild)
        }
        obj.atividades.forEach(function (element){
            var opt = document.createElement("option");
            
            opt.value= element.id;
            opt.innerHTML = element.descricao; 
            
            selectorAtividade.appendChild(opt);
        });
    })
    .catch(function (error) {
        console.log(error)
    })
}

selectorCurriculo.addEventListener("change", function() {
    setGruposPorCurriculo(selectorCurriculo.value)
});

selectorGrupo.addEventListener("change", function() {
    setAtividadePorGrupo(selectorGrupo.value)
});

validationCH.addEventListener("change", function() {
    var result = validationCH.value * 2;
    validationCHaproveitamento.value = result
})