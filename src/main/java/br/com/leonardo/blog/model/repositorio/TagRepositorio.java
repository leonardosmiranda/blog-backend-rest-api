package br.com.leonardo.blog.model.repositorio;

import br.com.leonardo.blog.model.entidade.Tag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório de acesso aos dados de tags.
 */
@Repository
public interface TagRepositorio extends JpaRepository<Tag, Long> {
}
