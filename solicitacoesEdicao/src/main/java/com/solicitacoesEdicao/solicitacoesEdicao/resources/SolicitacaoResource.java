package com.solicitacoesEdicao.solicitacoesEdicao.resources;

import com.solicitacoesEdicao.solicitacoesEdicao.models.Solicitacao;
import com.solicitacoesEdicao.solicitacoesEdicao.repositories.SolicitacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SolicitacaoResource
 */
@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoResource {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;

   

    @PutMapping("/atualizar")
    public Solicitacao editaSolicitacao(@RequestBody Solicitacao solicitacao){
        
        return solicitacaoRepository.save(solicitacao);
    }

}