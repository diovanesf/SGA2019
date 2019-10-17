package com.solicitacoes.solicitacoesinclusao.resources;

import com.solicitacoes.solicitacoesinclusao.models.Solicitacao;
import com.solicitacoes.solicitacoesinclusao.repositories.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;


/**
 * SolicitacaoResource
 */
@RestController
@RequestMapping(value="/api")
public class SolicitacaoResource {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;

     @GetMapping("/solicitacoes")
     public List<Solicitacao> listaSolicitacoes(){
         return solicitacaoRepository.findAll();
     }

     @GetMapping("/solicitacao/{id}")
     public Solicitacao listaSolicitacaoUnica(@PathVariable(value="id")long id){
         return solicitacaoRepository.findById(id);
     }


}