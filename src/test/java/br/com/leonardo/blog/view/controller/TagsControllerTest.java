package br.com.leonardo.blog.view.controller;

import br.com.leonardo.blog.model.entidade.Tag;
import br.com.leonardo.blog.model.servico.TagServico;
import br.com.leonardo.blog.view.dto.TagDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe de testes do controller de tags.
 */
@RunWith(MockitoJUnitRunner.class)
public class TagsControllerTest {

    @Mock
    private TagServico servico;

    @InjectMocks
    private TagsController controller;

    @Test
    public void testarListarTodas() {
        List<Tag> tagsEntrada = new ArrayList<>();

        Tag tag1 = getTagCompleta("TEste 1", 1L);
        Tag tag2 = getTagCompleta("TEste 2", 2L);
        Tag tag3 = getTagCompleta("TEste 3", 3L);


        tagsEntrada.add(tag1);
        tagsEntrada.add(tag2);
        tagsEntrada.add(tag3);


        Mockito.when(servico.listarTodos()).thenReturn(tagsEntrada);

        List<TagDTO> tags = controller.listarTodas();

        Assert.assertEquals(3, tags.size());
    }

    private Tag getTagCompleta(String nome, Long id) {
        Tag tag = new Tag(nome);
        tag.setId(id);
        return tag;
    }

    @Test
    public void testarInserir() {

        Tag entrada = getTagCompleta("Teste 1", 1L);

        Mockito.when(servico.inserir(Mockito.any(Tag.class))).thenReturn(entrada);

        TagDTO tag = controller.inserir(entrada);

        Assert.assertNotNull(tag);
    }

    @Test
    public void testarRecuperarPorId() {
        Tag entrada = getTagCompleta("Teste 1", 1L);

        Mockito.when(servico.buscarPorId(1L)).thenReturn(entrada);

        TagDTO tag = controller.recuperaPorId(1L);

        Assert.assertNotNull(tag);
    }

    @Test
    public void testarAlterar() {
        Tag entrada = getTagCompleta("Teste Alterado", null);
        Tag original = getTagCompleta("Teste 1", 1L);
        Tag alterada = getTagCompleta("Teste Alterado", 1L);

        Mockito.when(servico.buscarPorId(1L)).thenReturn(original);
        Mockito.when(servico.atualizar(Mockito.any(Tag.class))).thenReturn(alterada);

        TagDTO retorno = controller.alterar(entrada, 1L);

        Assert.assertNotNull(retorno);
        Assert.assertEquals("Teste Alterado", retorno.getNome());
    }

    @Test
    public void testarExcluir() {
        controller.excluir(1L);

        Mockito.verify(servico).excluir(1L);
    }
}