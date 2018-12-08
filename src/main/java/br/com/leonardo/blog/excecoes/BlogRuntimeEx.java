package br.com.leonardo.blog.excecoes;

/**
 * Exceção onde o sistema não se pode recuperar.
 */
public class BlogRuntimeEx extends RuntimeException {

    public BlogRuntimeEx(String mensagem) {
        super(mensagem);
    }
}
