package com.avaliacoes.avaliacoesInclusao.repositories;

import com.avaliacoes.avaliacoesInclusao.models.Avaliacao;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AvaliacaoRepository extends JpaRepository<Avaliacao, Long>{

    Avaliacao findById(long id);
    
}