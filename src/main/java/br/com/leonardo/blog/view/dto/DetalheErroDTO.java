package br.com.leonardo.blog.view.dto;

import java.time.LocalDateTime;

/**
 * DTO de detalhes de erro.
 */
public class DetalheErroDTO {

    private LocalDateTime data;
    private String mensagem;
    private String detalhe;

    public DetalheErroDTO(LocalDateTime data, String mensagem, String detalhe) {
        this.data = data;
        this.mensagem = mensagem;
        this.detalhe = detalhe;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }

    public String getDetalhe() {
        return detalhe;
    }

    public void setDetalhe(String detalhe) {
        this.detalhe = detalhe;
    }
}
