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
@Table(name="Grupo")
public class Grupo implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)    
private long id;
private String nomeGrupo;

public Grupo(long id, String nomeGrupo){
this.id = id;
this.nomeGrupo = nomeGrupo;
}
public void setId(long id) {
    this.id = id;
}
public void setNomeAtividade(String nomeGrupo) {
    this.nomeGrupo = nomeGrupo;
}
public long getId(){
    return this.id;
}
 public String getnomeGrupo(){
     return this.nomeGrupo;
 }


}