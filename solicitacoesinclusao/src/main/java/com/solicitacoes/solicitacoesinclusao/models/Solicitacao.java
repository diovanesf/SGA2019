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
@Table(name="Solicitacao")
public class Solicitacao implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)    
private long id;
private long codAtividade;
private String solicitante;
private String curriculo;
private String descricaoAtividade;
private int cargaHorariaSolicitada;
private int cargaHorariaAproveitada;
private String observacoesAnexos;
private int status;
private String periodoAtividade;
private long dataSolicitacao;
private String professorResponsavel;


    public Solicitacao() {
    }

    public Solicitacao(long id, long codAtividade, String solicitante, String curriculo, String descricaoAtividade, 
    int cargaHorariaSolicitada, int cargaHorariaAproveitada, String observacoesAnexos, int status, String periodoAtividade, String professorResponsavel) {
        this.id = id;
        this.codAtividade = codAtividade;
        this.solicitante = solicitante;
        this.curriculo = curriculo;
        this.periodoAtividade = periodoAtividade;
        this.dataSolicitacao = System.currentTimeMillis();
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getCodAtividade() {
        return this.codAtividade;
    }

    public void setCodAtividade(long codAtividade) {
        this.codAtividade = codAtividade;
    }

    public String getPeriodoAtividade() {
        return this.periodoAtividade;
    }

    public void setPeriodoAtividade(String periodoAtividade) {
        this.periodoAtividade = periodoAtividade;
    }

    public long getDataSolicitacao() {
        return this.dataSolicitacao;
    }

    public void setDataSolicitacao(long dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Solicitacao id(long id) {
        this.id = id;
        return this;
    }

    public Solicitacao codAtividade(long codAtividade) {
        this.codAtividade = codAtividade;
        return this;
    }

    public Solicitacao periodoAtividade(String periodoAtividade) {
        this.periodoAtividade = periodoAtividade;
        return this;
    }

    public Solicitacao dataSolicitacao(long dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
        return this;
    }





    /**
     * @return String return the solicitante
     */
    public String getSolicitante() {
        return solicitante;
    }

    /**
     * @param solicitante the solicitante to set
     */
    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    /**
     * @return String return the curriculo
     */
    public String getCurriculo() {
        return curriculo;
    }

    /**
     * @param curriculo the curriculo to set
     */
    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    /**
     * @return String return the descricaoAtividade
     */
    public String getDescricaoAtividade() {
        return descricaoAtividade;
    }

    /**
     * @param descricaoAtividade the descricaoAtividade to set
     */
    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }

    /**
     * @return int return the cargaHorariaSolicitada
     */
    public int getCargaHorariaSolicitada() {
        return cargaHorariaSolicitada;
    }

    /**
     * @param cargaHorariaSolicitada the cargaHorariaSolicitada to set
     */
    public void setCargaHorariaSolicitada(int cargaHorariaSolicitada) {
        this.cargaHorariaSolicitada = cargaHorariaSolicitada;
    }

    /**
     * @return int return the cargaHorariaAproveitada
     */
    public int getCargaHorariaAproveitada() {
        return cargaHorariaAproveitada;
    }

    /**
     * @param cargaHorariaAproveitada the cargaHorariaAproveitada to set
     */
    public void setCargaHorariaAproveitada(int cargaHorariaAproveitada) {
        this.cargaHorariaAproveitada = cargaHorariaAproveitada;
    }

    /**
     * @return String return the observacoesAnexos
     */
    public String getObservacoesAnexos() {
        return observacoesAnexos;
    }

    /**
     * @param observacoesAnexos the observacoesAnexos to set
     */
    public void setObservacoesAnexos(String observacoesAnexos) {
        this.observacoesAnexos = observacoesAnexos;
    }

    /**
     * @return int return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @param status the status to set
     */
    public void setStatus(int status) {
        this.status = status;
    }


    /**
     * @return String return the professorResponsavel
     */
    public String getProfessorResponsavel() {
        return professorResponsavel;
    }

    /**
     * @param professorResponsavel the professorResponsavel to set
     */
    public void setProfessorResponsavel(String professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

}