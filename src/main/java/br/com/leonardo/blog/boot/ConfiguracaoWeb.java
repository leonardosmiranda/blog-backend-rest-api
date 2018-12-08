package br.com.leonardo.blog.boot;

import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@EnableCaching
@ComponentScan(basePackages = { "br.com.leonardo.blog.view.controller", "br.com.leonardo.blog.excecoes"  })
public class ConfiguracaoWeb implements WebMvcConfigurer {
}
