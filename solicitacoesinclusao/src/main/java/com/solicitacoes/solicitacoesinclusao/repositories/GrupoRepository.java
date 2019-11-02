package com.solicitacoes.solicitacoesinclusao.repositories;

import com.solicitacoes.solicitacoesinclusao.models.Grupo;

import org.springframework.data.jpa.repository.JpaRepository;

public interface GrupoRepository extends JpaRepository<Grupo, Long>{

    Grupo findById(long id);
    
}