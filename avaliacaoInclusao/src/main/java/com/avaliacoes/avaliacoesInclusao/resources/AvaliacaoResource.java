package com.avaliacoes.avaliacoesInclusao.resources;

import com.avaliacoes.avaliacoesInclusao.models.Avaliacao;
import com.avaliacoes.avaliacoesInclusao.repositories.AvaliacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * SolicitacaoResource
 */
@RestController
@RequestMapping("/solicitacao")
public class AvaliacaoResource {

    @Autowired
    AvaliacaoRepository avaliacaoRepository;
 
    @PostMapping(value="/salvar")
    public Avaliacao salvaAvaliacao(@RequestBody Avaliacao avaliacao){
        
        return avaliacaoRepository.save(avaliacao);
    }

}