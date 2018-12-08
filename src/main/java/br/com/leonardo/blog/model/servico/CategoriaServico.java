package br.com.leonardo.blog.model.servico;

import br.com.leonardo.blog.model.repositorio.CategoriaRepositorio;
import br.com.leonardo.blog.model.entidade.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CategoriaServico extends BaseServico<Categoria, CategoriaRepositorio> implements IServico<Categoria>  {

    @Autowired
    public CategoriaServico(CategoriaRepositorio repositorio) {
        super(repositorio);
    }
}
