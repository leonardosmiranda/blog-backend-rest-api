package br.com.leonardo.blog.view.dto;

import br.com.leonardo.blog.model.entidade.Artigo;
import br.com.leonardo.blog.model.entidade.Tag;

import java.util.ArrayList;
import java.util.List;

/**
 * Objeto de retorno da API que representa uma artigo.
 */
public class ArtigoDTO {

    private Long id;
    private String titulo;
    private String texto;
    private CategoriaDTO categoria;
    private String status;
    private List<TagDTO> tags = new ArrayList<>();

    public ArtigoDTO(Artigo artigo) {
        this.id = artigo.getId();
        this.titulo = artigo.getTitulo();
        this.texto = artigo.getTexto();
        this.categoria = new CategoriaDTO(artigo.getCategoria());
        this.status = artigo.getStatus().name();
        if (artigo.getTags() != null && !artigo.getTags().isEmpty()) {
            for (Tag tag : artigo.getTags()) {
                tags.add(new TagDTO(tag.getId(), tag.getNome()));
            }
        }
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public CategoriaDTO getCategoria() {
        return categoria;
    }

    public void setCategoria(CategoriaDTO categoria) {
        this.categoria = categoria;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public List<TagDTO> getTags() {
        return tags;
    }

    public void setTags(List<TagDTO> tags) {
        this.tags = tags;
    }
}
