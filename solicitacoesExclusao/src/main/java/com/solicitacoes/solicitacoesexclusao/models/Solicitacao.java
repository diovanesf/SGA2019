package com.solicitacoes.solicitacoesexclusao.models;

import java.io.Serializable;
import java.sql.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Solicitacao
 */

@Entity
@Table(name="solicitacao")
public class Solicitacao implements Serializable {

private static final long serialVersionUID = 1L;

@Id
@GeneratedValue(strategy=GenerationType.AUTO)    
private long id;
private long codAtividade;
private String nomeDoAluno;
private int matriculaDoAluno;
private int cargaHoraria;
private int cargaHorariaReal;
private String periodoAtividade;
private Date dataSolicitacao;


    public Solicitacao() {
    }

    public Solicitacao(long id, long codAtividade, String nomeDoAluno, int matriculaDoAluno, int cargaHoraria, int cargaHorariaReal, String periodoAtividade, Date dataSolicitacao) {
        this.id = id;
        this.codAtividade = codAtividade;
        this.nomeDoAluno = nomeDoAluno;
        this.matriculaDoAluno = matriculaDoAluno;
        this.cargaHoraria = cargaHoraria;
        this.cargaHorariaReal = cargaHorariaReal;
        this.periodoAtividade = periodoAtividade;
        this.dataSolicitacao = dataSolicitacao;
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

    public String getNomeDoAluno() {
        return this.nomeDoAluno;
    }

    public void setNomeDoAluno(String nomeDoAluno) {
        this.nomeDoAluno = nomeDoAluno;
    }

    public int getMatriculaDoAluno() {
        return this.matriculaDoAluno;
    }

    public void setMatriculaDoAluno(int matriculaDoAluno) {
        this.matriculaDoAluno = matriculaDoAluno;
    }

    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public int getCargaHorariaReal() {
        return this.cargaHorariaReal;
    }

    public void setCargaHorariaReal(int cargaHorariaReal) {
        this.cargaHorariaReal = cargaHorariaReal;
    }

    public String getPeriodoAtividade() {
        return this.periodoAtividade;
    }

    public void setPeriodoAtividade(String periodoAtividade) {
        this.periodoAtividade = periodoAtividade;
    }

    public Date getDataSolicitacao() {
        return this.dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
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

    public Solicitacao nomeDoAluno(String nomeDoAluno) {
        this.nomeDoAluno = nomeDoAluno;
        return this;
    }

    public Solicitacao matriculaDoAluno(int matriculaDoAluno) {
        this.matriculaDoAluno = matriculaDoAluno;
        return this;
    }

    public Solicitacao cargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
        return this;
    }

    public Solicitacao cargaHorariaReal(int cargaHorariaReal) {
        this.cargaHorariaReal = cargaHorariaReal;
        return this;
    }

    public Solicitacao periodoAtividade(String periodoAtividade) {
        this.periodoAtividade = periodoAtividade;
        return this;
    }

    public Solicitacao dataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
        return this;
    }




}