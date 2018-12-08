package br.com.leonardo.blog.boot;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

/**
 * Classe principal para rodar a aplicação.
 */
@SpringBootApplication
@EnableJpaAuditing
public class BlogAplicacao {

	public static void main(String[] args) {
		SpringApplication.run(BlogAplicacao.class, args);
	}
}
