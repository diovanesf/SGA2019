package br.sistema.sistemadeacg.controllers;

import br.sistema.sistemadeacg.anexo.AnexoService;
import br.sistema.sistemadeacg.models.Atividade;
import br.sistema.sistemadeacg.models.Grupo;
import br.sistema.sistemadeacg.repository.AtividadeRepository;
import br.sistema.sistemadeacg.repository.GrupoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import java.util.List;
import java.util.Optional;

import javax.xml.ws.Response;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
public class DataController {

    @Autowired
    private AtividadeRepository atividadeRepository;

    @Autowired
    private GrupoRepository grupoRepository;

    private final AnexoService storageService;
    @Autowired
    public DataController(AnexoService storageService) {
        this.storageService = storageService;
    }

    @GetMapping("/grupos")
    public ResponseEntity getGrupos(){
        return ResponseEntity.ok(grupoRepository.findAll());
    }

    @GetMapping("/atividades/porGrupo/{idGrupo}")
    public ResponseEntity getAtividadesPorGrupo(@PathVariable long idGrupo) {
        Optional<Grupo> grupo = grupoRepository.findById(idGrupo);
        if (!grupo.isPresent()) {
            return ResponseEntity.badRequest().body("O grupo com esse ID nao foi encontrado: " + idGrupo);
        }
        return ResponseEntity.ok(atividadeRepository.findAllByGrupo(grupo.get()));
    }

    
    @GetMapping("/anexos/{filename:.+}") // Busca um anexo a partir do nome, só chamar isso para cada anexo na view, ele mostra o pdf no navegador
    @ResponseBody
    public ResponseEntity<Resource> getFile(@PathVariable String filename) {

        Resource file = storageService.loadAsResource(filename);
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION,
                "attachment; filename=\"" + file.getFilename() + "\"").body(file);
    }
}
