package br.com.leonardo.blog.model.servico;

import br.com.leonardo.blog.model.entidade.Autorizacao;
import br.com.leonardo.blog.model.entidade.Categoria;
import br.com.leonardo.blog.model.repositorio.AutorizacaoRepositorio;
import br.com.leonardo.blog.model.repositorio.CategoriaRepositorio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Classe de Testes do serviço de categoria.
 */
@RunWith(MockitoJUnitRunner.class)
public class CategoriaServicoTest {

    @Mock
    private CategoriaRepositorio repositorio;

    @InjectMocks
    private CategoriaServico servico;

    @Test
    public void inserir() {

        Categoria objeto = new Categoria();

        servico.inserir(objeto);

        Mockito.verify(repositorio).save(objeto);
    }

    @Test
    public void atualizar() {
        Categoria objeto = new Categoria();

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
        servico.buscarPorId(1L);

        Mockito.verify(repositorio).findById(1L);
    }

    @Test
    public void testarListarTodos() {
        servico.listarTodos();

        Mockito.verify(repositorio).findAll();
    }

}
