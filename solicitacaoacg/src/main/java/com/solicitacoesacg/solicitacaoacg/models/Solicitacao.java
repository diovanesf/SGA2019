package com.solicitacoesacg.solicitacaoacg.models;

import java.io.File;
import java.sql.Date;/* 
import java.util.ArrayList; */
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;


/**
 * Solicitacao
 */
@Entity
public class Solicitacao {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NotEmpty
    private long id;

    @Column(name = "solicitante", nullable = false)
    private String solicitante;

    @Column(name = "local", nullable = false)
    private String local;

    @Column(name = "dataCriacao", nullable = false)
    private Date dataCriacao;

    @Column(name = "dataAceite", nullable = false)
    private Date dataAceite;


    private File anexo;

    @Column(name = "cargaHoraria", nullable = false)
    private int cargaHoraria;


    public Solicitacao(long id, String solicitante, String local, Date dataCriacao, Date dataAceite, File anexo, int cargaHoraria, Atividade atividade) {
        this.id = id;
        this.solicitante = solicitante;
        this.local = local;
        this.dataCriacao = dataCriacao;
        this.dataAceite = dataAceite;
        this.anexo = anexo;
        this.cargaHoraria = cargaHoraria;
        this.atividade = atividade;
    }

  

   

    private Atividade atividade;


    public Solicitacao(){

    }
    public Solicitacao(String solicitante, String local, File anexo, int cargaHoraria){
        this.anexo = anexo;
        this.cargaHoraria = cargaHoraria;
        this.dataCriacao = new Date(System.currentTimeMillis());
        this.local = local;
        this.solicitante = solicitante;
    }
    public boolean create (){

        return true;
    }
    
    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSolicitante() {
        return this.solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public String getLocal() {
        return this.local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getDataCriacao() {
        return this.dataCriacao;
    }

    public void setDataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public Date getDataAceite() {
        return this.dataAceite;
    }

    public void setDataAceite(Date dataAceite) {
        this.dataAceite = dataAceite;
    }

    public File getAnexo() {
        return this.anexo;
    }

    public void setAnexo(File anexo) {
        this.anexo = anexo;
    }

    public int getCargaHoraria() {
        return this.cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public Atividade getAtividade() {
        return this.atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Solicitacao id(long id) {
        this.id = id;
        return this;
    }

    public Solicitacao solicitante(String solicitante) {
        this.solicitante = solicitante;
        return this;
    }

    public Solicitacao local(String local) {
        this.local = local;
        return this;
    }

    public Solicitacao dataCriacao(Date dataCriacao) {
        this.dataCriacao = dataCriacao;
        return this;
    }

    public Solicitacao dataAceite(Date dataAceite) {
        this.dataAceite = dataAceite;
        return this;
    }

    public Solicitacao anexo(File anexo) {
        this.anexo = anexo;
        return this;
    }

    public Solicitacao cargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
        return this;
    }

    public Solicitacao atividade(Atividade atividade) {
        this.atividade = atividade;
        return this;
    }
/*     public ArrayList<Solicitacao> all (){
        ArrayList<Solicitacao> solicitacoes = new ArrayList<Solicitacao>();
        return solicitacoes;
    }
    public Solicitacao find (int id){
        Solicitacao solicitacao = new Solicitacao();
        return solicitacao;
    }
    public boolean delete (Solicitacao solicitacao){
        return true;
    } */

}