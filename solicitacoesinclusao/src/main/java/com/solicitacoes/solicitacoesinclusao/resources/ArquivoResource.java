package com.solicitacoes.solicitacoesinclusao.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

/**
 * ArquivoResource
 */
@RestController
@RequestMapping("/anexos")
public class ArquivoResource {
    @Autowired
    private Disco disco;

    @PostMapping("/upload")
    public void upload(@RequestParam MultipartFile file){
        file.getBytes
    }
}