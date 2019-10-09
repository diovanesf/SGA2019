package com.solicitacoesacg.solicitacaoacg.repositories;
import org.springframework.data.jpa.repository.JpaRepository;
import com.solicitacoesacg.solicitacaoacg.models.Solicitacao;
import java.util.List;
/**
 * SolicitacaoRepository
 */
public interface SolicitacaoRepository extends JpaRepository<Solicitacao, Long> {
  List<Solicitacao> findBySolicitante(String solicitante);

  
}