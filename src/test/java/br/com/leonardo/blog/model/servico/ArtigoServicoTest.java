package br.com.leonardo.blog.model.servico;

import br.com.leonardo.blog.model.entidade.Artigo;
import br.com.leonardo.blog.model.entidade.Categoria;
import br.com.leonardo.blog.model.repositorio.ArtigoRepositorio;
import br.com.leonardo.blog.model.repositorio.CategoriaRepositorio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

/**
 * Classe de Testes do serviço de artigo.
 */
@RunWith(MockitoJUnitRunner.class)
public class ArtigoServicoTest {

    @Mock
    private ArtigoRepositorio repositorio;

    @Mock
    private CategoriaServico categoriaServico;

    @InjectMocks
    private ArtigoServico servico;

    @Test
    public void inserir() {

        Categoria categoria = new Categoria();
        categoria.setId(1L);

        Mockito.when(categoriaServico.buscarPorId(1L)).thenReturn(categoria);

        Artigo artigo = new Artigo();
        artigo.setCategoria(categoria);

        servico.inserir(artigo);

        Mockito.verify(repositorio).save(artigo);
    }

    @Test
    public void atualizar() {
        Categoria categoria = new Categoria();
        categoria.setId(1L);

        Mockito.when(categoriaServico.buscarPorId(1L)).thenReturn(categoria);

        Artigo artigo = new Artigo();
        artigo.setCategoria(categoria);

        servico.atualizar(artigo);

        Mockito.verify(repositorio).save(artigo);
    }

    @Test
    public void excluir() {

        servico.excluir(1L);

        Mockito.verify(repositorio).deleteById(1L);
    }

    @Test
    public void buscarPorId() {
        Mockito.when(repositorio.findById(1L)).thenReturn(Optional.of(new Artigo()));

        servico.buscarPorId(1L);

        Mockito.verify(repositorio).findById(1L);
    }

    @Test
    public void testarListarTodos() {
        servico.listarTodos();

        Mockito.verify(repositorio).findAll();
    }

}
