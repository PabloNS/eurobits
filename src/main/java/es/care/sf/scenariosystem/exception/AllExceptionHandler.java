package es.care.sf.scenariosystem.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AllExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity handleExceptions(Exception e) {
        return new ResponseEntity(new ExceptionResponse(e.getLocalizedMessage()), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}