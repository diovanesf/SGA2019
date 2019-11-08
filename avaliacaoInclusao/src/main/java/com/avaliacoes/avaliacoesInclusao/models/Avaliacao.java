package com.avaliacoes.avaliacoesInclusao.models;

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
@Table(name="Avaliacao")
public class Avaliacao implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)    
private long id;
private String comentario;

    public Avaliacao() {
    }

    public Avaliacao(long id, String comentario) {
        this.id = id;
        this.comentario = comentario;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getComentario() {
        return this.comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }


}