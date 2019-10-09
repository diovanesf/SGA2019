package com.solicitacoes.solicitacoesinclusao.storage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;
/**
 * Disco
 */
@Component
public class Disco {

    @Value("${solicitacoes.disco.raiz}")
    private String raiz;

    @Value("${solicitacoes.disco.diretorio-arquivos}")
    private String diretorioArquivos;

    public void salvarArquivo(MultipartFile arquivo){
        this.salvar(this.diretorioArquivos, arquivo);
    }
    public void salvar(String diretorio, MultipartFile arquivo){
        Path diretorioPath = Path.get(this.raiz, diretorio);
        Path arquivoPath = diretorioPath.resolve(arquivo.getOriginalFilename());

        try{
            Files.createDirectories(diretorioPath);
            arquivo.transferTo(arquivoPath.toFile());

        } catch (IOException e){
            throw new RuntimeException("Problemas ao tentar salvar arquivo")
        }
    }
}