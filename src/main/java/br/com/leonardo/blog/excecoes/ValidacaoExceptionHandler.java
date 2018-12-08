package br.com.leonardo.blog.excecoes;

import br.com.leonardo.blog.view.dto.DetalheErroDTO;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
@RestController
public class ValidacaoExceptionHandler extends ResponseEntityExceptionHandler {
    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
                                                                  HttpHeaders headers, HttpStatus status,
                                                                  WebRequest request) {
        List<DetalheErroDTO> erros = new ArrayList<>();

        for (ObjectError erro : ex.getBindingResult().getAllErrors()) {
            erros.add(new DetalheErroDTO(LocalDateTime.now(), "Erro de Validação",
                    erro.getDefaultMessage()));
        }

        return new ResponseEntity(erros, HttpStatus.BAD_REQUEST);
    }

}
