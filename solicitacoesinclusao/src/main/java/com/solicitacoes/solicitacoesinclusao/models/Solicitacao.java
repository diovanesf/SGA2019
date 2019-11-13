package com.solicitacoes.solicitacoesinclusao.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.hibernate.validator.constraints.Range;

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
@NotNull(message = "É obrigatório selecionar uma atividade")
private Atividade atividade;
@NotNull(message = "É obrigatório selecionar um grupo")
private Grupo grupo;
@NotNull(message = "É obrigatório informar o nome do Solicitante")
private String solicitante;
@Range(min = 9, message = "A matrícula é inválida.")
@NotNull(message = "A matrícula é obrigatória")
private int matricula; 
@NotNull(message = "É obrigatório informar o currículo")
private String curriculo;
@JsonFormat
private Date dataInicioAtividade;
@JsonFormat
private Date dataFimAtividade;
@NotNull(message = "É obrigatório informar a descrição da atividade feita")
private String descricaoAtividade;
@NotNull(message = "É obrigatório informar uma carga horária a ser solicitada")
private int cargaHorariaSolicitada;
private String professorResponsavel;

    public Solicitacao(long id, Atividade atividade, Grupo grupo, String solicitante, int matricula, String curriculo, Date dataInicioAtividade, Date dataFimAtividade, String descricaoAtividade, int cargaHorariaSolicitada, String professorResponsavel, Date dataSolicitacao, int cargaHorariaAproveitada, String observacoesAnexos, int status) {
        this.id = id;
        this.atividade = atividade;
        this.grupo = grupo;
        this.solicitante = solicitante;
        this.matricula = matricula;
        this.curriculo = curriculo;
        this.dataInicioAtividade = dataInicioAtividade;
        this.dataFimAtividade = dataFimAtividade;
        this.descricaoAtividade = descricaoAtividade;
        this.cargaHorariaSolicitada = cargaHorariaSolicitada;
        this.professorResponsavel = professorResponsavel;
        this.dataSolicitacao = dataSolicitacao;
        this.cargaHorariaAproveitada = cargaHorariaAproveitada;
        this.observacoesAnexos = observacoesAnexos;
        this.status = status;
    }

    public String getProfessorResponsavel() {
        return this.professorResponsavel;
    }

    public void setProfessorResponsavel(String professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
    }

    public Date getDataSolicitacao() {
        return this.dataSolicitacao;
    }

    public void setDataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
    }

    public Solicitacao professorResponsavel(String professorResponsavel) {
        this.professorResponsavel = professorResponsavel;
        return this;
    }

    public Solicitacao dataSolicitacao(Date dataSolicitacao) {
        this.dataSolicitacao = dataSolicitacao;
        return this;
    }
private Date dataSolicitacao;
private int cargaHorariaAproveitada;
private String observacoesAnexos;
private int status;


    public Solicitacao() {
    }

    public Solicitacao(long id, Atividade atividade, Grupo grupo, String solicitante, int matricula, String curriculo, Date dataInicioAtividade, Date dataFimAtividade, String descricaoAtividade, int cargaHorariaSolicitada, int cargaHorariaAproveitada, String observacoesAnexos, int status) {
        this.id = id;
        this.atividade = atividade;
        this.grupo = grupo;
        this.solicitante = solicitante;
        this.matricula = matricula;
        this.curriculo = curriculo;
        this.dataInicioAtividade = dataInicioAtividade;
        this.dataFimAtividade = dataFimAtividade;
        this.descricaoAtividade = descricaoAtividade;
        this.cargaHorariaSolicitada = cargaHorariaSolicitada;
        this.cargaHorariaAproveitada = cargaHorariaAproveitada;
        this.observacoesAnexos = observacoesAnexos;
        this.status = status;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Atividade getAtividade() {
        return this.atividade;
    }

    public void setAtividade(Atividade atividade) {
        this.atividade = atividade;
    }

    public Grupo getGrupo() {
        return this.grupo;
    }

    public void setGrupo(Grupo grupo) {
        this.grupo = grupo;
    }

    public String getSolicitante() {
        return this.solicitante;
    }

    public void setSolicitante(String solicitante) {
        this.solicitante = solicitante;
    }

    public int getMatricula() {
        return this.matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getCurriculo() {
        return this.curriculo;
    }

    public void setCurriculo(String curriculo) {
        this.curriculo = curriculo;
    }

    public Date getDataInicioAtividade() {
        return this.dataInicioAtividade;
    }

    public void setDataInicioAtividade(Date dataInicioAtividade) {
        this.dataInicioAtividade = dataInicioAtividade;
    }

    public Date getDataFimAtividade() {
        return this.dataFimAtividade;
    }

    public void setDataFimAtividade(Date dataFimAtividade) {
        this.dataFimAtividade = dataFimAtividade;
    }

    public String getDescricaoAtividade() {
        return this.descricaoAtividade;
    }

    public void setDescricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
    }

    public int getCargaHorariaSolicitada() {
        return this.cargaHorariaSolicitada;
    }

    public void setCargaHorariaSolicitada(int cargaHorariaSolicitada) {
        this.cargaHorariaSolicitada = cargaHorariaSolicitada;
    }

    public int getCargaHorariaAproveitada() {
        return this.cargaHorariaAproveitada;
    }

    public void setCargaHorariaAproveitada(int cargaHorariaAproveitada) {
        this.cargaHorariaAproveitada = cargaHorariaAproveitada;
    }

    public String getObservacoesAnexos() {
        return this.observacoesAnexos;
    }

    public void setObservacoesAnexos(String observacoesAnexos) {
        this.observacoesAnexos = observacoesAnexos;
    }

    public int getStatus() {
        return this.status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public Solicitacao id(long id) {
        this.id = id;
        return this;
    }

    public Solicitacao atividade(Atividade atividade) {
        this.atividade = atividade;
        return this;
    }

    public Solicitacao grupo(Grupo grupo) {
        this.grupo = grupo;
        return this;
    }

    public Solicitacao solicitante(String solicitante) {
        this.solicitante = solicitante;
        return this;
    }

    public Solicitacao matricula(int matricula) {
        this.matricula = matricula;
        return this;
    }

    public Solicitacao curriculo(String curriculo) {
        this.curriculo = curriculo;
        return this;
    }

    public Solicitacao dataInicioAtividade(Date dataInicioAtividade) {
        this.dataInicioAtividade = dataInicioAtividade;
        return this;
    }

    public Solicitacao dataFimAtividade(Date dataFimAtividade) {
        this.dataFimAtividade = dataFimAtividade;
        return this;
    }

    public Solicitacao descricaoAtividade(String descricaoAtividade) {
        this.descricaoAtividade = descricaoAtividade;
        return this;
    }

    public Solicitacao cargaHorariaSolicitada(int cargaHorariaSolicitada) {
        this.cargaHorariaSolicitada = cargaHorariaSolicitada;
        return this;
    }

    public Solicitacao cargaHorariaAproveitada(int cargaHorariaAproveitada) {
        this.cargaHorariaAproveitada = cargaHorariaAproveitada;
        return this;
    }

    public Solicitacao observacoesAnexos(String observacoesAnexos) {
        this.observacoesAnexos = observacoesAnexos;
        return this;
    }

    public Solicitacao status(int status) {
        this.status = status;
        return this;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof Solicitacao)) {
            return false;
        }
        Solicitacao solicitacao = (Solicitacao) o;
        return id == solicitacao.id && Objects.equals(atividade, solicitacao.atividade) && Objects.equals(grupo, solicitacao.grupo) && Objects.equals(solicitante, solicitacao.solicitante) && matricula == solicitacao.matricula && Objects.equals(curriculo, solicitacao.curriculo) && Objects.equals(dataInicioAtividade, solicitacao.dataInicioAtividade) && Objects.equals(dataFimAtividade, solicitacao.dataFimAtividade) && Objects.equals(descricaoAtividade, solicitacao.descricaoAtividade) && cargaHorariaSolicitada == solicitacao.cargaHorariaSolicitada && cargaHorariaAproveitada == solicitacao.cargaHorariaAproveitada && Objects.equals(observacoesAnexos, solicitacao.observacoesAnexos) && status == solicitacao.status;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, atividade, grupo, solicitante, matricula, curriculo, dataInicioAtividade, dataFimAtividade, descricaoAtividade, cargaHorariaSolicitada, cargaHorariaAproveitada, observacoesAnexos, status);
    }

    @Override
    public String toString() {
        return "{" +
            " id='" + getId() + "'" +
            ", atividade='" + getAtividade() + "'" +
            ", grupo='" + getGrupo() + "'" +
            ", solicitante='" + getSolicitante() + "'" +
            ", matricula='" + getMatricula() + "'" +
            ", curriculo='" + getCurriculo() + "'" +
            ", dataInicioAtividade='" + getDataInicioAtividade() + "'" +
            ", dataFimAtividade='" + getDataFimAtividade() + "'" +
            ", descricaoAtividade='" + getDescricaoAtividade() + "'" +
            ", cargaHorariaSolicitada='" + getCargaHorariaSolicitada() + "'" +
            ", cargaHorariaAproveitada='" + getCargaHorariaAproveitada() + "'" +
            ", observacoesAnexos='" + getObservacoesAnexos() + "'" +
            ", status='" + getStatus() + "'" +
            "}";
    }


   

}