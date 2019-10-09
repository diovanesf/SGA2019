package com.solicitacoesacg.solicitacaoacg.models;

import java.io.File;
import java.util.ArrayList;

import lombok.Data;

/**
 * Atividade
 */
@Data
public class Atividade {
private String descricao;
private File documento;
private String observacao;
private int cargaHoraria;
private String detalhamento;
private int id;


public Atividade(){

}

public Atividade(String descricao, File documento, String observacao, int cargaHoraria, String detalhamento){
    this.descricao = descricao;
    this. documento = documento;
    this.observacao = observacao;
    this.cargaHoraria = cargaHoraria;
    this.detalhamento = detalhamento;
}

public ArrayList<Atividade> all (){
    ArrayList<Atividade> atividades = new ArrayList<Atividade>();
    return atividades;
}
public Atividade find (){
    Atividade atividade = new Atividade();

    return atividade;
}   
    
} 