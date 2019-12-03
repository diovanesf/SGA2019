package br.sistema.sistemadeacg;

import br.sistema.sistemadeacg.anexo.AnexoProperties;
import br.sistema.sistemadeacg.anexo.AnexoService;


import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableConfigurationProperties(AnexoProperties.class)
public class SistemagDeAcgApplication {

	public static void main(String[] args) {
		SpringApplication.run(SistemagDeAcgApplication.class, args);
	}

	@Bean
    CommandLineRunner init(AnexoService anexoService) {
        return (args) -> {
            anexoService.deleteAll();
            anexoService.init();
        };
    }
}
