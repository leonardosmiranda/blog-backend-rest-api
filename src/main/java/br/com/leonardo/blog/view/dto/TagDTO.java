package br.com.leonardo.blog.view.dto;

/**
 * Objeto de retorno da API que representa uma tag.
 */
public class TagDTO {
    private Long id;
    private String nome;

    public TagDTO(Long id, String nome) {
        this.id = id;
        this.nome = nome;
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
}
