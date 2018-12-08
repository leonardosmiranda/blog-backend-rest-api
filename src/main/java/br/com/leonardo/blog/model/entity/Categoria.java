package br.com.leonardo.blog.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * Entidade que repersenta uma categoria.
 */
@Entity
@Table(name = "categorias")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"dataCriacao", "dataAlteracao"}, allowGetters = true)
public class Categoria {

    @Id
    @SequenceGenerator(name="seq_categorias",sequenceName="seq_categorias", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_categorias")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @NotEmpty
    @Column(name="nome", nullable = false)
    private String nome;


    @Column(name="data_criacao", nullable = false)
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name="data_alteracao", nullable = false)
    @LastModifiedDate
    private LocalDateTime dataAlteracao;

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

    public LocalDateTime getDataCriacao() { return dataCriacao; }

    public void setDataCriacao(LocalDateTime dataCriacao) { this.dataCriacao = dataCriacao; }

    public LocalDateTime getDataAlteracao() { return dataAlteracao; }

    public void setDataAlteracao(LocalDateTime dataAlteracao) { this.dataAlteracao = dataAlteracao; }
}
