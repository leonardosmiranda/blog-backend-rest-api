package br.com.leonardo.blog.model.repositorio;

import br.com.leonardo.blog.model.entidade.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repositório de acesso aos dados de usuários.
 */
@Repository
public interface UsuarioRepositorio extends JpaRepository<Usuario, Long> {
}
