package br.com.leonardo.blog.model.entidade;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

/**
 * Entidade que repersenta uma categoria.
 */
@Entity
@Table(name = "categorias")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"base"}, allowGetters = true)
public class Categoria {

    @Id
    @SequenceGenerator(name="seq_categorias",sequenceName="seq_categorias", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_categorias")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @NotEmpty
    @Column(name="nome", nullable = false)
    private String nome;

    @Embedded
    private EntidadeBase base;

    /**
     * Construtor Padrão.
     */
    public Categoria() {}

    /**
     * Construtor por nome.
     *
     * @param nome o nome da categoria
     */
    public Categoria(String nome) { this.nome = nome; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public EntidadeBase getBase() { return base; }

    public void setBase(EntidadeBase base) { this.base = base; }
}
