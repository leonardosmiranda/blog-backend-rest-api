package br.com.leonardo.blog.model.entidade;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidade que representa uma tag de um artigo.
 */
@Entity
@Table(name = "autorizacoes")
public class Tag {
    @Id
    @SequenceGenerator(name="seq_tags",sequenceName="seq_tags", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_tags")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @NotEmpty(message = "O nome da Tag deve ser informado")
    @Column(name="nome", nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "tags")
    private Set<Artigo> artigos = new HashSet<>();

    /**
     * Construtor Padrão.
     */
    public Tag() {}

    /**
     * Construtor.
     *
     * @param nome o nome da tag
     */
    public Tag(String nome) { this.nome = nome; }

    /**
     * Construtor.
     *
     * @param id o id da tag
     * @param nome o nome da tag
     */
    public Tag(Long id, String nome) {
        this.nome = nome;
        this.id = id;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Set<Artigo> getArtigos() { return artigos; }

    public void setArtigos(Set<Artigo> artigos) { this.artigos = artigos; }
}
