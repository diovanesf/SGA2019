package br.sistema.sistemadeacg.repository;

import br.sistema.sistemadeacg.models.Atividade;
import br.sistema.sistemadeacg.models.Grupo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

/**
 * AtividadeRepository
 */
public interface AtividadeRepository extends CrudRepository<Atividade, Long> {

    List<Atividade> findAllByGrupo(Grupo grupo);

}