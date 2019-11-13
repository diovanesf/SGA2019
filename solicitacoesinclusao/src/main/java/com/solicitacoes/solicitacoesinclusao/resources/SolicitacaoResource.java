package com.solicitacoes.solicitacoesinclusao.resources;

import com.solicitacoes.solicitacoesinclusao.models.Solicitacao;
import com.solicitacoes.solicitacoesinclusao.models.Grupo;
import com.solicitacoes.solicitacoesinclusao.models.Atividade;
import com.solicitacoes.solicitacoesinclusao.repositories.SolicitacaoRepository;
import com.solicitacoes.solicitacoesinclusao.repositories.GrupoRepository;
import com.solicitacoes.solicitacoesinclusao.repositories.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SolicitacaoResource
 */
@RestController
@RequestMapping("")
public class SolicitacaoResource {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;
    @Autowired
    GrupoRepository grupoRepository;
    @Autowired
    AtividadeRepository atividadeRepository;
 
    @CrossOrigin
    @PostMapping(value="/salvar")
    public Solicitacao salvaSolicitacao(@RequestBody Solicitacao solicitacao, Atividade atividade, Grupo grupo){
        atividade.setGrupo(grupo);
        solicitacao.setAtividade(atividade);
        return solicitacaoRepository.save(solicitacao);
    }

    @CrossOrigin
    @GetMapping(value="/buscarGrupos")
    public ResponseEntity<Iterable<Grupo>> buscarGrupos(){
        
        Iterable<Grupo> grupos =  grupoRepository.findAll();
        return ResponseEntity.ok(grupos);
    }

    @CrossOrigin
    @GetMapping(value="/buscarAtividades")
    public ResponseEntity<Iterable<Atividade>> buscarAtividades(){
        
        Iterable<Atividade> atividades =  atividadeRepository.findAll();
        return ResponseEntity.ok(atividades);
    }
}