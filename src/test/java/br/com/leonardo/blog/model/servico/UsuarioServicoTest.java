package br.com.leonardo.blog.model.servico;

import br.com.leonardo.blog.model.entidade.Usuario;
import br.com.leonardo.blog.model.repositorio.UsuarioRepositorio;
import br.com.leonardo.blog.model.repositorio.UsuarioRepositorio;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

/**
 * Classe de Testes do serviço de usuário.
 */
@RunWith(MockitoJUnitRunner.class)
public class UsuarioServicoTest {

    @Mock
    private UsuarioRepositorio repositorio;

    @InjectMocks
    private UsuarioServico servico;

    @Test
    public void inserir() {

        Usuario objeto = new Usuario();

        servico.inserir(objeto);

        Mockito.verify(repositorio).save(objeto);
    }

    @Test
    public void atualizar() {
        Usuario objeto = new Usuario();

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
