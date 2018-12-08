package br.com.leonardo.blog.excecoes;

import br.com.leonardo.blog.view.dto.DetalheErroDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;

@ControllerAdvice
@RestController
public class RuntimeExceptionHandler {

    @ExceptionHandler(value = { RuntimeException.class })
    protected ResponseEntity<Object> handleConflict( RuntimeException ex, WebRequest request) {
        return new ResponseEntity(new DetalheErroDTO(LocalDateTime.now(),
                "Erro ao executar a operação desejada",
                ex.getLocalizedMessage()), HttpStatus.BAD_REQUEST);
    }
}
