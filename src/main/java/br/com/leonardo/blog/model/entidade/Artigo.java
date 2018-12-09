package br.com.leonardo.blog.model.entidade;

import br.com.leonardo.blog.model.dominio.EStatusArtigo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidade que representa um artigo do blog.
 */
@Entity
@Table(name = "artigos")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"base"}, allowGetters = true)
public class Artigo {

    @Id
    @SequenceGenerator(name="seq_artigos",sequenceName="seq_artigos", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_artigos")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @NotEmpty(message = "O Título do artigo deve ser preenchido")
    @Column(name="titulo", nullable = false)
    private String titulo;

    @NotEmpty(message = "O Texto do Artigo deve ser preenchido")
    @Column(name="texto", nullable = false)
    private String texto;

    @NotNull(message = "A Categoria do Artigo deve ser preenchida")
    @ManyToOne
    @JoinColumn(name="categoria_id", nullable=false)
    private Categoria categoria;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "artigo_tag",
            joinColumns = { @JoinColumn(name = "artigo_id") },
            inverseJoinColumns = { @JoinColumn(name = "tag_id") }
    )
    private Set<Tag> tags = new HashSet<>();

    @NotNull(message = "O Status do Artigo deve ser preenchido")
    @Enumerated
    @Column(name="status")
    private EStatusArtigo status;

    @Embedded
    private EntidadeBase base = new EntidadeBase();

    /**
     * Construtor Padrão.
     */
    public Artigo() {}

    /**
     * Construtor.
     *
     * @param titulo o título do artigo
     * @param texto o texto do artigo
     * @param categoria a categoria do artigo
     * @param tags As autorizacoes do artigo
     */
    public Artigo(String titulo, String texto, Categoria categoria, Set<Tag> tags) {
        this.titulo = titulo;
        this.texto = texto;
        this.categoria = categoria;
        this.tags = tags;
        this.status = EStatusArtigo.RASCUNHO;
    }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getTexto() { return texto; }

    public void setTexto(String texto) { this.texto = texto; }

    public Categoria getCategoria() { return categoria; }

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }

    public Set<Tag> getTags() { return tags; }

    public void setTags(Set<Tag> tags) { this.tags = tags; }

    public EStatusArtigo getStatus() { return status; }

    public void setStatus(EStatusArtigo status) { this.status = status; }

    public EntidadeBase getBase() { return base; }

    public void setBase(EntidadeBase base) { this.base = base; }
}
