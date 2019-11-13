package com.solicitacoes.solicitacoesinclusao.models;

import java.io.Serializable;
import java.util.Objects;

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
private Grupo grupo;

    public Atividade() {
    }

    public Atividade(long id, String nomeAtividade, Grupo grupo) {
        this.id = id;
        this.nomeAtividade = nomeAtividade;
        this.grupo = grupo;
    }

    public Grupo getGrupo() {
        return this.grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public Atividade id(long id) {
        this.id = id;
        return this;
    }

    public Atividade nomeAtividade(String nomeAtividade) {
        this.nomeAtividade = nomeAtividade;
        return this;
    }

    public Atividade grupo(Grupo grupo) {
        this.grupo = grupo;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Atividade)) {
            return false;
        }
        Atividade atividade = (Atividade) o;
        return id == atividade.id && Objects.equals(nomeAtividade, atividade.nomeAtividade) && Objects.equals(grupo, atividade.grupo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nomeAtividade, grupo);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", nomeAtividade='" + getNomeAtividade() + "'" +
            ", grupo='" + getGrupo() + "'" +
            "}";
    }

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