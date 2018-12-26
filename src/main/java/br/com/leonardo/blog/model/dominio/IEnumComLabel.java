package br.com.leonardo.blog.model.dominio;

import br.com.leonardo.blog.util.Mensagens;

public interface IEnumComLabel<E extends Enum<E>> {

    default String getLabel() {
        return Mensagens.obterLabelEnum(this);
    }
}