package com.solicitacoes.solicitacoesexclusao.repositories;

import com.solicitacoes.solicitacoesexclusao.models.Solicitacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>{

    Solicitacao findById(long id);
    
}