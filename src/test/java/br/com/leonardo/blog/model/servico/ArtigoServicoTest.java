package br.com.leonardo.blog.model.servico;

import br.com.leonardo.blog.excecoes.BlogRuntimeEx;
import br.com.leonardo.blog.model.dominio.EStatusArtigo;
import br.com.leonardo.blog.model.entidade.Artigo;
import br.com.leonardo.blog.model.entidade.Categoria;
import br.com.leonardo.blog.model.entidade.Tag;
import br.com.leonardo.blog.model.repositorio.ArtigoRepositorio;
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

    @Mock
    private TagServico tagServico;

    @InjectMocks
    private ArtigoServico servico;

    @Test
    public void inserir() {

        Categoria categoria = new Categoria();
        categoria.setId(1L);

        Mockito.when(categoriaServico.buscarPorId(1L)).thenReturn(categoria);
        Mockito.when(tagServico.buscarPorId(1L)).thenReturn(new Tag(1L, "Tag 1"));

        Artigo artigo = new Artigo();
        artigo.setCategoria(categoria);
        artigo.getTags().add(new Tag(1L,"Tag 1"));
        artigo.getTags().add(new Tag("Tag 2"));

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

    @Test(expected = BlogRuntimeEx.class)
    public void buscarPorIdInvalido() {
        Mockito.when(repositorio.findById(1L)).thenReturn(Optional.empty());

        servico.buscarPorId(1L);

        Mockito.verify(repositorio).findById(1L);
    }


    @Test
    public void testarListarTodos() {
        servico.listarTodos();

        Mockito.verify(repositorio).findAll();
    }

    @Test
    public void testarListarPorStatus() {
        servico.listarArtigosPorStatus(EStatusArtigo.RASCUNHO);

        Mockito.verify(repositorio).listarPorStatus(EStatusArtigo.RASCUNHO);
    }


}
