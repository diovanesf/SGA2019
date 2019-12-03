package br.sistema.sistemadeacg.formulario;

import br.sistema.sistemadeacg.models.Atividade;
import br.sistema.sistemadeacg.models.Grupo;

import lombok.Data;

/**
 * DadosSolicitacaoFormulario
 */
@Data
public class DadosSolicitacaoFormulario {
    Iterable<Atividade> atividades;
    Iterable<Grupo> grupos;
    // Iterable<Curriculo> curriculo;

    public DadosSolicitacaoFormulario() {
    }
}