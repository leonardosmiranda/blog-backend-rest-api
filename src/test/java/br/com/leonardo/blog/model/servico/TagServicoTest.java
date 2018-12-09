package br.com.leonardo.blog.model.servico;

import br.com.leonardo.blog.model.entidade.Tag;
import br.com.leonardo.blog.model.repositorio.TagRepositorio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

/**
 * Classe de Testes do serviço de tag.
 */
@RunWith(MockitoJUnitRunner.class)
public class TagServicoTest {

    @Mock
    private TagRepositorio repositorio;

    @InjectMocks
    private TagServico servico;

    @Test
    public void inserir() {

        Tag objeto = new Tag();

        servico.inserir(objeto);

        Mockito.verify(repositorio).save(objeto);
    }

    @Test
    public void atualizar() {
        Tag objeto = new Tag();

        servico.atualizar(objeto);

        Mockito.verify(repositorio).save(objeto);
    }

    @Test
    public void excluir() {

        servico.excluir(1L);

        Mockito.verify(repositorio).deleteById(1L);
    }

    @Test
    public void buscarPorId() {
        Mockito.when(repositorio.findById(1L)).thenReturn(Optional.of(new Tag()));

        servico.buscarPorId(1L);

        Mockito.verify(repositorio).findById(1L);
    }

    @Test
    public void testarListarTodos() {
        servico.listarTodos();

        Mockito.verify(repositorio).findAll();
    }

}
