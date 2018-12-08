package br.com.leonardo.blog.model.repositorio;

import br.com.leonardo.blog.model.entidade.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório de acesso aos dados de categorias.
 */
@Repository
public interface CategoriaRepositorio extends JpaRepository<Categoria, Long> {
}
