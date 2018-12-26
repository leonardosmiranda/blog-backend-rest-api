package br.com.leonardo.blog.view.controller;

import br.com.leonardo.blog.model.dominio.EStatusArtigo;
import br.com.leonardo.blog.model.entidade.Artigo;
import br.com.leonardo.blog.model.entidade.Categoria;
import br.com.leonardo.blog.model.entidade.Tag;
import br.com.leonardo.blog.model.servico.ArtigoServico;
import br.com.leonardo.blog.view.dto.ArtigoDTO;
import br.com.leonardo.blog.view.dto.TagDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

/**
 * Classe de testes do controller de tags.
 */
@RunWith(MockitoJUnitRunner.class)
public class ArtigosControllerTest {

    @Mock
    private ArtigoServico servico;

    @InjectMocks
    private ArtigosController controller;

    @Test
    public void testarListarTodos() {
        List<Artigo> artigosEntrada = new ArrayList<>();

        Artigo artigo1 = getArtigoCompleto(1L, "Teste 1", "Texto do artigo");
        Artigo artigo2 = getArtigoCompleto(2L, "Teste 2", "Texto do artigo");
        Artigo artigo3 = getArtigoCompleto(3L, "Teste 3", "Texto do artigo");


        artigosEntrada.add(artigo1);
        artigosEntrada.add(artigo2);
        artigosEntrada.add(artigo3);


        Mockito.when(servico.listarTodos()).thenReturn(artigosEntrada);

        List<ArtigoDTO> artigos = controller.listarTodas();

        Assert.assertEquals(3, artigos.size());
    }

    private Artigo getArtigoCompleto(Long id, String titulo, String texto) {
        Categoria categoria = new Categoria("Categoria 1");
        categoria.setId(1L);

        Set<Tag> tags = new LinkedHashSet<>();
        for (int i = 0; i < 3; i++) {
            tags.add(new Tag(1L, "Tag 1"));
            tags.add(new Tag("Tag 2"));
        }

        Artigo artigo = new Artigo();
        artigo.setId(id);
        artigo.setTitulo(titulo);
        artigo.setTexto(texto);
        artigo.setStatus(EStatusArtigo.RASCUNHO);
        artigo.setCategoria(categoria);
        artigo.setTags(tags);
        return artigo;
    }

    @Test
    public void testarInserir() {

        Artigo entrada = getArtigoCompleto(1L, "Teste 1", "Texto do artigo");

        Mockito.when(servico.inserir(Mockito.any(Artigo.class))).thenReturn(entrada);

        ArtigoDTO artigo = controller.inserir(entrada);

        Assert.assertNotNull(artigo);
    }

    @Test
    public void testarRecuperarPorId() {
        Artigo entrada = getArtigoCompleto(1L, "Teste 1", "Texto do artigo");

        Mockito.when(servico.buscarPorId(1L)).thenReturn(entrada);

        ArtigoDTO artigo = controller.recuperaPorId(1L);

        Assert.assertNotNull(artigo);
    }

    @Test
    public void testarAlterar() {
        Artigo entrada  = getArtigoCompleto(1L, "Teste Alterado", "Texto do Alterado");
        Artigo original = getArtigoCompleto(2L, "Teste 2", "Texto do artigo");
        Artigo alterado = getArtigoCompleto(1L, "Teste Alterado", "Texto do artigo");

        Mockito.when(servico.buscarPorId(1L)).thenReturn(original);
        Mockito.when(servico.atualizar(Mockito.any(Artigo.class))).thenReturn(alterado);

        ArtigoDTO retorno = controller.alterar(entrada, 1L);

        Assert.assertNotNull(retorno);
        Assert.assertEquals("Teste Alterado", retorno.getTitulo());
    }

    @Test
    public void testarExcluir() {
        controller.excluir(1L);
        Mockito.verify(servico).excluir(1L);
    }

    @Test
    public void testarListarPorStatus() {
        List<Artigo> artigosEntrada = new ArrayList<>();

        Artigo artigo1 = getArtigoCompleto(1L, "Teste 1", "Texto do artigo");
        Artigo artigo2 = getArtigoCompleto(2L, "Teste 2", "Texto do artigo");
        Artigo artigo3 = getArtigoCompleto(3L, "Teste 3", "Texto do artigo");


        artigosEntrada.add(artigo1);
        artigosEntrada.add(artigo2);
        artigosEntrada.add(artigo3);


        Mockito.when(servico.listarArtigosPorStatus(EStatusArtigo.RASCUNHO)).thenReturn(artigosEntrada);

        List<ArtigoDTO> artigos = controller.listarPorStatus(EStatusArtigo.RASCUNHO);

        Assert.assertEquals(3, artigos.size());
    }
}