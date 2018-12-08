package br.com.leonardo.blog.model.repositorio;

import br.com.leonardo.blog.model.dominio.EStatusArtigo;
import br.com.leonardo.blog.model.entidade.Artigo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repositório de acesso aos dados de artigos.
 */
@Repository
public interface ArtigoRepositorio extends JpaRepository<Artigo, Long> {


    @Query("SELECT o FROM Artigo o WHERE o.status = ?1 order by o.base.criadoEm")
    public List<Artigo> pesquisarPorStatus(EStatusArtigo status);
}
