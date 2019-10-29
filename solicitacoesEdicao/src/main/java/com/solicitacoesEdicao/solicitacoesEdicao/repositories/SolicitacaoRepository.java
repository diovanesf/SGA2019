package com.solicitacoesEdicao.solicitacoesEdicao.repositories;

import com.solicitacoesEdicao.solicitacoesEdicao.models.Solicitacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long>{

    Solicitacao findById(long id);
    
}