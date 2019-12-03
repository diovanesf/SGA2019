package br.sistema.sistemadeacg.formulario;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.Data;

/**
 * SolicitacaoEnviaFormulario
 */
@Data
public class SolicitacaoEnviaFormulario {

	private String local;
	private long matricula;
	private String aluno;
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataInicio;
	@JsonFormat(pattern="yyyy-MM-dd")
	private String dataFim;
	private long cargaHorariaSoli;
	private String profRes;
	private String descricao;
	private long idAtividade;
}