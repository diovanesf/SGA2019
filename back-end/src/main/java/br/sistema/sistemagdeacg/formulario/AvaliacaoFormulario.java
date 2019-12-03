package br.sistema.sistemagdeacg.formulario;

import br.sistema.sistemadeacg.models.Solicitacao;
import lombok.Data;

/**
 * AvaliacaoFormulario
 */
@Data
public class AvaliacaoFormulario {

	private long cargaHorariaAtribuida;
    private Solicitacao solicitacao;
    private String parecer;
    private boolean deferido;

}