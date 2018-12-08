package br.com.leonardo.blog.model.entidade;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "autorizacoes")
public class Autorizacao {

    @Id
    @SequenceGenerator(name="seq_autorizacoes",sequenceName="seq_autorizacoes", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_autorizacoes")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @NotEmpty
    @Column(name="nome", nullable = false)
    private String nome;

    @ManyToMany(mappedBy = "autorizacoes")
    private Set<Usuario> usuarios = new HashSet<>();

    /**
     * Construtor Padrão.
     */
    public Autorizacao() {}

    /**
     * Contrutor.
     *
     * @param nome o nome da autorização
     */
    public Autorizacao(String nome) { this.nome = nome; }

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public Set<Usuario> getUsuarios() { return usuarios; }

    public void setUsuarios(Set<Usuario> usuarios) { this.usuarios = usuarios; }

}
