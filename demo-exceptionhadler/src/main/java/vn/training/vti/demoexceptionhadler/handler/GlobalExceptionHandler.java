package vn.training.vti.demoexceptionhadler.handler;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import vn.training.vti.demoexceptionhadler.exception.ObjectNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalStateException.class)
    public ResponseEntity<?> handleException(IllegalStateException exception){
        return ResponseEntity.badRequest().body(exception.getMessage());
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<?> handleException(){
        return ResponseEntity.notFound().build();
    }

    @ExceptionHandler(ObjectNotFoundException.class)
    public ResponseEntity<?> handleException(ObjectNotFoundException exp){
        return ResponseEntity.badRequest().body(exp.getErrorMessages());
    }

}
