package br.com.leonardo.blog.model.servico;

import br.com.leonardo.blog.model.repositorio.UsuarioRepositorio;
import br.com.leonardo.blog.model.entidade.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsuarioServico extends BaseServico<Usuario, UsuarioRepositorio> implements IServico<Usuario>  {

    @Autowired
    public UsuarioServico(UsuarioRepositorio repositorio) {
        super(repositorio);
    }
}
