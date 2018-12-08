package br.com.leonardo.blog.model.servico;

import java.util.List;

/**
 * Interface com métodos básicos de serviços.
 *
 * @param <T> O tipo da entidade que o serviço irá tratar
 */
public interface IServico<T> {

    public T inserir(T  t);
    public T atualizar(T t);
    public void excluir(Object id);
    public T buscarPorId(Object id);
    public List<T> listarTodos();
}
