package br.com.leonardo.blog.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.time.LocalDateTime;

/**
 * Entidade que representa um artigo do blog.
 */
@Entity
@Table(name = "artigos")
@EntityListeners(AuditingEntityListener.class)
@JsonIgnoreProperties(value = {"dataCriacao", "dataAlteracao"}, allowGetters = true)
public class Artigo {

    @Id
    @SequenceGenerator(name="seq_artigos",sequenceName="seq_artigos", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE,generator="seq_artigos")
    @Column(name="id", unique=true, nullable=false)
    private Long id;

    @NotEmpty
    @Column(name="titulo", nullable = false)
    private String titulo;

    @NotEmpty
    @Column(name="texto", nullable = false)
    private String texto;

    @ManyToOne
    @JoinColumn(name="categoria_id", nullable=false)
    private Categoria categoria;

    @Column(name="data_criacao", nullable = false)
    @CreatedDate
    private LocalDateTime dataCriacao;

    @Column(name="data_alteracao", nullable = false)
    @LastModifiedDate
    private LocalDateTime dataAlteracao;



}
