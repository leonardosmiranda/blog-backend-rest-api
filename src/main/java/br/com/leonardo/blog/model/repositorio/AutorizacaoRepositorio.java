package br.com.leonardo.blog.model.repositorio;

import br.com.leonardo.blog.model.entidade.Autorizacao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório de acesso aos dados de autorizacoes.
 */
@Repository
public interface AutorizacaoRepositorio extends JpaRepository<Autorizacao, Long> {
}
