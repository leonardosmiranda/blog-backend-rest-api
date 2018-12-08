package br.com.leonardo.blog.model.servico;

import br.com.leonardo.blog.model.entidade.Artigo;
import br.com.leonardo.blog.model.repositorio.ArtigoRepositorio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Classe de Testes do serviço de artigo.
 */
@RunWith(MockitoJUnitRunner.class)
public class ArtigoServicoTest {

    @Mock
    private ArtigoRepositorio repositorio;

    @InjectMocks
    private ArtigoServico servico;

    @Test
    public void inserir() {

        Artigo artigo = new Artigo();

        servico.inserir(artigo);

        Mockito.verify(repositorio).save(artigo);
    }

    @Test
    public void atualizar() {
        Artigo artigo = new Artigo();

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
        servico.buscarPorId(1L);

        Mockito.verify(repositorio).findById(1L);
    }

    @Test
    public void testarListarTodos() {
        servico.listarTodos();

        Mockito.verify(repositorio).findAll();
    }

}
