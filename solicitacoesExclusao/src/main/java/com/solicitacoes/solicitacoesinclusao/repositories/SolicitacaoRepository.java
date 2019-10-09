package com.solicitacoes.solicitacoesinclusao.repositories;

import com.solicitacoes.solicitacoesinclusao.models.Solicitacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>{

    Solicitacao findById(long id);
    
}