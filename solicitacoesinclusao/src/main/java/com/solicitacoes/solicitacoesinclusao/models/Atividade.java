package com.solicitacoes.solicitacoesinclusao.models;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Solicitacao
 */

@Entity
@Table(name="Atividade")
public class Atividade implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)    
private long id;
private String nomeAtividade;

public Atividade(long id, String nomeAtividade){
this.id = id;
this.nomeAtividade = nomeAtividade;
}
public void setId(long id) {
    this.id = id;
}
public void setNomeAtividade(String nomeAtividade) {
    this.nomeAtividade = nomeAtividade;
}
public long getId(){
    return this.id;
}
public String getNomeAtividade(){
    return this.nomeAtividade;
}


}