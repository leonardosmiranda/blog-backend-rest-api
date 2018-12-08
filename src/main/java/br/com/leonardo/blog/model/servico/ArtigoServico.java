package br.com.leonardo.blog.model.servico;

import br.com.leonardo.blog.model.entidade.Artigo;
import br.com.leonardo.blog.model.repositorio.ArtigoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ArtigoServico extends BaseServico<Artigo, ArtigoRepositorio> implements IServico<Artigo>  {

    public ArtigoServico(ArtigoRepositorio repositorio) {
        super(repositorio);
    }
}
