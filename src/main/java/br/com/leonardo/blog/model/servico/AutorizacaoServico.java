package br.com.leonardo.blog.model.servico;

import br.com.leonardo.blog.model.entidade.Autorizacao;
import br.com.leonardo.blog.model.repositorio.AutorizacaoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AutorizacaoServico extends BaseServico<Autorizacao, AutorizacaoRepositorio> implements IServico<Autorizacao>  {

    @Autowired
    public AutorizacaoServico(AutorizacaoRepositorio repositorio) {
        super(repositorio);
    }
}
