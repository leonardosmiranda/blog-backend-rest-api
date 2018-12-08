package br.com.leonardo.blog.model.servico;

import br.com.leonardo.blog.excecoes.BlogRuntimeEx;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementação dos métodos básicos de serviço.
 */
public class BaseServico<T, S> implements IServico<T> {

    protected S repositorio;

    public BaseServico(S repositorio) {
        this.repositorio = repositorio;
    }

    @Override
    public T inserir(T t) {
        return (T) getRepositorioBase().save(t);
    }

    @Override
    public T atualizar(T t) {
        return (T) getRepositorioBase().save(t);
    }

    @Override
    public void excluir(Object id) {
        getRepositorioBase().deleteById(id);
    }

    @Override
    public T buscarPorId(Object id) {
        Optional<T> t = getRepositorioBase().findById(id);

        if (t.isPresent()) {
            return t.get();
        }

        throw new BlogRuntimeEx("O objeto informado não pode ser encontrado.");
    }

    @Override
    public List<T> listarTodos() {
        return getRepositorioBase().findAll();
    }

    private JpaRepository getRepositorioBase() {
        return (JpaRepository) repositorio;
    }
}
