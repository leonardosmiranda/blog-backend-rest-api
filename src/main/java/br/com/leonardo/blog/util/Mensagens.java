package br.com.leonardo.blog.util;

import br.com.leonardo.blog.model.dominio.IEnumComLabel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;

import javax.annotation.PostConstruct;
import java.util.Locale;

public class Mensagens {
    private static ResourceBundleMessageSource MESSAGE_SOURCE;

    @Autowired
    private ResourceBundleMessageSource resourceBundle;

    /**
     * Cria uma referencia estatica ao message source, para que a internacionalizacao das enums
     * possa ser invocada por objetos que nao possam ter o componente {@link Mensagens} injetado
     * (objetos que nao sao beans spring, como DTOs, por exemplo).
     */
    @PostConstruct
    public void init() {
        MESSAGE_SOURCE = resourceBundle;
    }

    /**
     * Obtem uma mensagem internacionalizada a partir de sua chave
     *
     * @param chave A chave da mensagem
     * @param args  Os argumentos para montagem da mensagem
     * @return A mensagem montada
     */
    public String obterMensagem(String chave, Object... args) {
        Locale locale = LocaleContextHolder.getLocale();
        return MESSAGE_SOURCE.getMessage(chave, args, locale);
    }

    /**
     * Obtem o label de uma enumeracao
     * @param e O valor da enumeracao
     * @param <E> O tipo da enumeracao
     * @return O label internacionalizado da enumeracao
     */
    public static <E extends Enum<E>> String obterLabelEnum(IEnumComLabel<E> e) {
        Locale locale = LocaleContextHolder.getLocale();
        String chaveMsg = "enum." + e.getClass().getSimpleName() + "." + ((Enum) e).name();
        return MESSAGE_SOURCE.getMessage(chaveMsg, null, locale);
    }
}
