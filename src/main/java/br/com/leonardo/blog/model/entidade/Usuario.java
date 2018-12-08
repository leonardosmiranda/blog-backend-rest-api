package br.com.leonardo.blog.model.entidade;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

/**
 * Entidade que representa um usuário.
 */
@Entity
@Table(name = "usuarios")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"base"}, allowGetters = true)
public class Usuario {

    @Id
    @SequenceGenerator(name = "seq_usuarios", sequenceName = "seq_usuarios", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_usuarios")
    @Column(name = "id", unique = true, nullable = false)
    private Long id;


    @NotEmpty
    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @NotEmpty
    @Column(name = "nome", nullable = false)
    private String nome;

    @NotEmpty
    @Column(name = "senha", nullable = false)
    @JsonIgnore
    private String senha;

    @ManyToMany(cascade = { CascadeType.ALL }, fetch = FetchType.LAZY)
    @JoinTable(
            name = "permissoes",
            joinColumns = { @JoinColumn(name = "usuario_id") },
            inverseJoinColumns = { @JoinColumn(name = "autorizacao_id") }
    )
    Set<Autorizacao> autorizacoes = new HashSet<>();


    @Embedded
    private EntidadeBase base;

    /**
     * Construtor Padrão.
     */
    public Usuario() {}

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public Set<Autorizacao> getAutorizacoes() { return autorizacoes; }

    public void setAutorizacoes(Set<Autorizacao> autorizacoes) { this.autorizacoes = autorizacoes; }

    public EntidadeBase getBase() { return base; }

    public void setBase(EntidadeBase base) { this.base = base; }
}