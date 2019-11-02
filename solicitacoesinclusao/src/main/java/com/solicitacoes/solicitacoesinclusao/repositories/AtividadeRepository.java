package com.solicitacoes.solicitacoesinclusao.repositories;

import com.solicitacoes.solicitacoesinclusao.models.Atividade;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AtividadeRepository extends JpaRepository<Atividade, Long>{

    Atividade findById(long id);
    
}