package br.com.leonardo.blog.model.servico;

import br.com.leonardo.blog.model.repositorio.TagRepositorio;
import br.com.leonardo.blog.model.entidade.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TagServico extends BaseServico<Tag, TagRepositorio> implements IServico<Tag>  {

    @Autowired
    public TagServico(TagRepositorio repositorio) {
        super(repositorio);
    }
}
