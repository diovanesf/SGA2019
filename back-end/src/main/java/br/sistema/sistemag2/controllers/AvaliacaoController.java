package br.sistema.sistemag2.controllers;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.annotation.JsonIgnore;
import br.sistema.sistemag2.dto.AvaliacaoDTO;
import br.sistema.sistemag2.models.Anexo;
import br.sistema.sistemag2.models.AvaliacaoSolicitacao;
import br.sistema.sistemag2.models.Solicitacao;
import br.sistema.sistemag2.models.Status;
import br.sistema.sistemag2.repository.AnexoRepository;
import br.sistema.sistemag2.repository.AtividadeRepository;
import br.sistema.sistemag2.repository.AvaliacaoRepository;
import br.sistema.sistemag2.repository.CurriculoRepository;
import br.sistema.sistemag2.repository.GrupoRepository;
import br.sistema.sistemag2.repository.SolicitacaoRepository;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * AvaliacaoController
 */
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("avaliacao")
public class AvaliacaoController {

    @Autowired
    SolicitacaoRepository solicitacaoRepository;
    @Autowired
    AtividadeRepository atividadeRepository;
    @Autowired
    GrupoRepository grupoRepository;
    @Autowired
    CurriculoRepository curriculoRepository;
    @Autowired
    AvaliacaoRepository avaliacaoRepository;
    @Autowired
    AnexoRepository anexoRepository;



    @JsonIgnore
    @PostMapping("/{id}") //Envia nova avaliação
    public ResponseEntity postAvaliacao(@RequestBody AvaliacaoDTO avaliacao, @PathVariable long id) throws Exception{

        AvaliacaoSolicitacao newavaliacao = new AvaliacaoSolicitacao();
        Date dataAtual = new Date();
        Solicitacao avaliada = (solicitacaoRepository.findById(id).isPresent()) ? solicitacaoRepository.findById(id).get() : null;

        if(avaliacao.isDeferido()){
            assert avaliada != null;
            avaliada.setStatus(Status.DEFERIDO.toString());
            newavaliacao.setCargaHorariaAtribuida(avaliacao.getCargaHorariaAtribuida());
        }else{
            assert avaliada != null;
            avaliada.setStatus(Status.INDEFERIDO.toString());
        }
        avaliada.setIdSolicitacao(id);
        solicitacaoRepository.save(avaliada);

        newavaliacao.setDataAvaliacao(dataAtual);
        newavaliacao.setSolicitacao(avaliada);
        newavaliacao.setJustificativa(avaliacao.getParecer());


            newavaliacao.ValidaDeferimento();

        AvaliacaoSolicitacao retornableAvaliacao = avaliacaoRepository.save(newavaliacao);

        return ResponseEntity.ok(retornableAvaliacao);
    }

    @DeleteMapping(value = "/{id}") // Busca no banco pelo ID
    public @ResponseBody ResponseEntity<Optional<AvaliacaoSolicitacao>> deleteAvaliacaobyId(@PathVariable long id) {
        Optional<AvaliacaoSolicitacao> retornableAvaliacao = avaliacaoRepository.findById(id);
        avaliacaoRepository.deleteById(id);
        if(retornableAvaliacao.isPresent()) {
            retornableAvaliacao.get().getSolicitacao().setStatus(Status.PENDENTE.toString());
        } else {
            throw new ExceptionInInitializerError();
        }
        solicitacaoRepository.save(retornableAvaliacao.get().getSolicitacao());
        return ResponseEntity.ok(retornableAvaliacao);
    }

    @GetMapping(value = "/dados/{id}") // Busca dados para avaliacao
    public HashMap<Solicitacao,List<String>> getInfos(@PathVariable long id) {
        // Busca no banco pelo id

        Solicitacao retornableSolicitacao = (solicitacaoRepository.findById(id).isPresent()) ? solicitacaoRepository.findById(id).get() : null;

        Iterable<Anexo> anexos = anexoRepository.findAll();

        List<String> anexosDaSolicitacao = new ArrayList<>();

        HashMap<Solicitacao,List<String>> retorno = new HashMap<>();

        for(Anexo anexo: anexos){
            if(anexo.getSolicitacao().equals(retornableSolicitacao)){
                anexosDaSolicitacao.add(anexo.getNome());

            }
        }

        retorno.put(retornableSolicitacao, anexosDaSolicitacao);

        return retorno;
    }


   
}