package br.com.leonardo.blog.view.dto;

import br.com.leonardo.blog.model.entidade.Categoria;

/**
 * Objeto de retorno da API que representa uma categoria.
 */
public class CategoriaDTO {
    private Long id;
    private String nome;
    private String criadoEm;
    private String alteradoEm;

    public CategoriaDTO(Long id, String nome, String criadoEm, String alteradoEm) {
        this.id = id;
        this.nome = nome;
        this.criadoEm = criadoEm;
        this.alteradoEm = alteradoEm;
    }

    public CategoriaDTO(Categoria categoria) {
        this.id = categoria.getId();
        this.nome = categoria.getNome();
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(String criadoEm) {
        this.criadoEm = criadoEm;
    }

    public String getAlteradoEm() {
        return alteradoEm;
    }

    public void setAlteradoEm(String alteradoEm) {
        this.alteradoEm = alteradoEm;
    }
}
