package br.com.leonardo.blog.model.entidade;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

/**
 * Entidade com as propriedade comuns.
 */
@Embeddable
public class EntidadeBase {
    @Column(name="criado_em")
    @NotNull
    @CreatedDate
    protected LocalDateTime criadoEm;

    @Column(name="alterado_em")
    @NotNull
    @LastModifiedDate
    protected LocalDateTime alteradoEm;

    public LocalDateTime getCriadoEm() {
        return criadoEm;
    }

    public void setCriadoEm(LocalDateTime criadoEm) {
        this.criadoEm = criadoEm;
    }

    public LocalDateTime getAlteradoEm() {
        return alteradoEm;
    }

    public void setAlteradoEm(LocalDateTime alteradoEm) {
        this.alteradoEm = alteradoEm;
    }
}
