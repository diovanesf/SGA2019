package com.solicitacoesacg.solicitacaoacg.controllers;
import com.solicitacoesacg.solicitacaoacg.models.Solicitacao;
import com.solicitacoesacg.solicitacaoacg.repositories.SolicitacaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/")
public class SolicitacaoController {

    private SolicitacaoRepository solicitacaoRepository;

    @Autowired
    public SolicitacaoController(SolicitacaoRepository solicitacaoRepository) {
        this.solicitacaoRepository = solicitacaoRepository;
    }
    
    

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String adicionaSolicitacao(Solicitacao solicitacao){
     
        solicitacaoRepository.save(solicitacao);
        return "redirect:/";
    }

}
