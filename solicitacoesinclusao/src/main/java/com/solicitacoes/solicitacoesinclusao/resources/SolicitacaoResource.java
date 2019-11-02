package com.solicitacoes.solicitacoesinclusao.resources;

import com.solicitacoes.solicitacoesinclusao.models.Solicitacao;
import com.solicitacoes.solicitacoesinclusao.models.Grupo;
import com.solicitacoes.solicitacoesinclusao.models.Atividade;
import com.solicitacoes.solicitacoesinclusao.repositories.SolicitacaoRepository;
import com.solicitacoes.solicitacoesinclusao.repositories.GrupoRepository;
import com.solicitacoes.solicitacoesinclusao.repositories.AtividadeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

/**
 * SolicitacaoResource
 */
@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoResource {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;
    @Autowired
    GrupoRepository grupoRepository;
    @Autowired
    AtividadeRepository atividadeRepository;
 
    @PostMapping(value="/salvar")
    public Solicitacao salvaSolicitacao(@RequestBody Solicitacao solicitacao){
        
        return solicitacaoRepository.save(solicitacao);
    }

    @GetMapping(value="/buscarGrupos")
    public List<Grupo> buscarGrupos(){
        
        return grupoRepository.findAll();
    }

    @GetMapping(value="/buscarAtividades")
    public List<Atividade> buscarAtividades(){
        
        return atividadeRepository.findAll();
    }

}