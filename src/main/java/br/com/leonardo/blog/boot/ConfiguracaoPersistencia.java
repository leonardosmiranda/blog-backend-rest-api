package br.com.leonardo.blog.boot;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@Configuration
@ComponentScan(basePackages = { "br.com.leonardo.blog.model.servico" })
@EnableJpaRepositories("br.com.leonardo.blog.model.repositorio")
@EntityScan("br.com.leonardo.blog.model.entidade")
@EnableTransactionManagement
public class ConfiguracaoPersistencia {
}
