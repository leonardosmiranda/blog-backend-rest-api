package br.com.leonardo.blog.view.controller;

import br.com.leonardo.blog.model.entidade.Categoria;
import br.com.leonardo.blog.model.servico.CategoriaServico;
import br.com.leonardo.blog.view.dto.CategoriaDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Classe de testes do controller de categoria.
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoriasControllerTest {

    @Mock
    private CategoriaServico servico;

    @InjectMocks
    private CategoriasController controller;

    @Test
    public void testarListarTodas() {
        List<Categoria> categoriasEntrada = new ArrayList<>();

        Categoria categoria1 = getCategoriaCompleta("TEste 1", 1L);

        Categoria categoria2 = getCategoriaCompleta("TEste 2", 2L);

        Categoria categoria3 = getCategoriaCompleta("TEste 3", 3L);


        categoriasEntrada.add(categoria1);
        categoriasEntrada.add(categoria2);
        categoriasEntrada.add(categoria3);


        Mockito.when(servico.listarTodos()).thenReturn(categoriasEntrada);

        List<CategoriaDTO> categorias = controller.listarTodas();

        Assert.assertEquals(3, categorias.size());
    }

    private Categoria getCategoriaCompleta(String s, Long l) {
        Categoria categoria1 = new Categoria(s);
        categoria1.setId(l);
        categoria1.getBase().setAlteradoEm(LocalDateTime.now());
        categoria1.getBase().setCriadoEm(LocalDateTime.now());
        return categoria1;
    }

    @Test
    public void testarInserir() {

        Categoria entrada = getCategoriaCompleta("Teste 1", 1L);

        Mockito.when(servico.inserir(Mockito.any(Categoria.class))).thenReturn(entrada);

        CategoriaDTO categoria = controller.inserir(entrada);

        Assert.assertNotNull(categoria);
    }

    @Test
    public void testarRecuperarPorId() {
        Categoria entrada = getCategoriaCompleta("Teste 1", 1L);

        Mockito.when(servico.buscarPorId(1L)).thenReturn(entrada);

        CategoriaDTO categoria = controller.recuperaPorId(1L);

        Assert.assertNotNull(categoria);
    }

    @Test
    public void testarAlterar() {
        Categoria entrada = getCategoriaCompleta("Teste Alterado", null);
        Categoria original = getCategoriaCompleta("Teste 1", 1L);
        Categoria alterada = getCategoriaCompleta("Teste Alterado", 1L);

        Mockito.when(servico.buscarPorId(1L)).thenReturn(original);
        Mockito.when(servico.atualizar(Mockito.any(Categoria.class))).thenReturn(alterada);

        CategoriaDTO retorno = controller.alterar(entrada, 1L);

        Assert.assertNotNull(retorno);
        Assert.assertEquals("Teste Alterado", retorno.getNome());
    }

    @Test
    public void testarExcluir() {
        controller.excluir(1L);

        Mockito.verify(servico).excluir(1L);
    }
}