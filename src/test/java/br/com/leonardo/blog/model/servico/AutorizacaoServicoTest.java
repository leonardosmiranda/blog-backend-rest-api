package br.com.leonardo.blog.model.servico;

import br.com.leonardo.blog.model.entidade.Autorizacao;
import br.com.leonardo.blog.model.repositorio.AutorizacaoRepositorio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.Optional;

/**
 * Classe de Testes do serviço de autorização.
 */
@RunWith(MockitoJUnitRunner.class)
public class AutorizacaoServicoTest {

    @Mock
    private AutorizacaoRepositorio repositorio;

    @InjectMocks
    private AutorizacaoServico servico;

    @Test
    public void inserir() {

        Autorizacao objeto = new Autorizacao();

        servico.inserir(objeto);

        Mockito.verify(repositorio).save(objeto);
    }

    @Test
    public void atualizar() {
        Autorizacao objeto = new Autorizacao();

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
        Mockito.when(repositorio.findById(1L)).thenReturn(Optional.of(new Autorizacao()));

        servico.buscarPorId(1L);

        Mockito.verify(repositorio).findById(1L);
    }

    @Test
    public void testarListarTodos() {
        servico.listarTodos();

        Mockito.verify(repositorio).findAll();
    }

}
