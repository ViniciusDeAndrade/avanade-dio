package br.com.avanade.dio.apis.advice;

import br.com.avanade.dio.apis.exception.ApplicationException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.ProblemDetail;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @Autowired
    private MessageSource messageSource;


    @ExceptionHandler(ApplicationException.class)
    public ResponseEntity<ProblemDetail> nada() {
        return null;
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> fieldErrorHandler(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(null);
    }

}
