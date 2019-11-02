package com.solicitacoes.solicitacoesexclusao.resources;

import com.solicitacoes.solicitacoesexclusao.models.Solicitacao;
import com.solicitacoes.solicitacoesexclusao.repositories.SolicitacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SolicitacaoResource
 */
@RestController
@RequestMapping(value="/solicitacao")
public class SolicitacaoResource {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;

    @DeleteMapping("/deletar")
    public void deletaSolicitacao(@RequestBody Solicitacao solicitacao) {
        solicitacaoRepository.delete(solicitacao);
    }

}