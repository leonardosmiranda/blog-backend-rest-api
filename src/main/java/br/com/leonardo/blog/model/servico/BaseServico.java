package br.com.leonardo.blog.model.servico;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementação dos métodos básicos de serviço.
 */
@Service
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
        return (T) getRepositorioBase().findById(id);
    }

    @Override
    public List<T> listarTodos() {
        return getRepositorioBase().findAll();
    }

    private JpaRepository getRepositorioBase() {
        return (JpaRepository) repositorio;
    }
}
