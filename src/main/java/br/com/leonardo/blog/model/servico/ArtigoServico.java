package br.com.leonardo.blog.model.servico;

import br.com.leonardo.blog.model.entidade.Artigo;
import br.com.leonardo.blog.model.entidade.Categoria;
import br.com.leonardo.blog.model.entidade.Tag;
import br.com.leonardo.blog.model.repositorio.ArtigoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedHashSet;
import java.util.Set;

@Service
public class ArtigoServico extends BaseServico<Artigo, ArtigoRepositorio> implements IServico<Artigo>  {

    private CategoriaServico categoriaServico;
    private TagServico tagServico;

    @Autowired
    public ArtigoServico(ArtigoRepositorio repositorio, CategoriaServico categoriaServico, TagServico tagServico) {
        super(repositorio);
        this.categoriaServico = categoriaServico;
        this.tagServico = tagServico;
    }

    @Override
    public Artigo atualizar(Artigo artigo) {
        Categoria categoria = categoriaServico.buscarPorId(artigo.getCategoria().getId());
        artigo.setCategoria(categoria);

        criaTags(artigo);

        return super.atualizar(artigo);
    }

    @Override
    public Artigo inserir(Artigo artigo) {
        Categoria categoria = categoriaServico.buscarPorId(artigo.getCategoria().getId());
        artigo.setCategoria(categoria);

        criaTags(artigo);

        return super.inserir(artigo);
    }

    private void criaTags(Artigo artigo) {
        if (!artigo.getTags().isEmpty()) {
            Set<Tag> novasTags = new LinkedHashSet<>();
            for (Tag tag : artigo.getTags()) {
                if (tag.getId() != null) {
                    tag = tagServico.buscarPorId(tag.getId());
                }
                tag.getArtigos().add(artigo);
                novasTags.add(tag);
            }

            artigo.setTags(novasTags);
        }
    }
}
