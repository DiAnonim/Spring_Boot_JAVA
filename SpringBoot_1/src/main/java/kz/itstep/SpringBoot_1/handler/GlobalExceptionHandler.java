package kz.itstep.SpringBoot_1.handler;

import kz.itstep.SpringBoot_1.exceptions.ProductNotFoundException;
import kz.itstep.SpringBoot_1.exceptions.UserExistException;
import kz.itstep.SpringBoot_1.exceptions.UserNotFoundException;
import kz.itstep.SpringBoot_1.exceptions.messages.CustomExceptionMessage;
import kz.itstep.SpringBoot_1.resource.ProductResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        return ResponseEntity.badRequest().body(
                new CustomExceptionMessage(LocalDateTime.now(),
                        ex.getBindingResult().getAllErrors().get(0).getDefaultMessage(),
                        400));
    }

    @ExceptionHandler(ProductNotFoundException.class)
    public ResponseEntity<?> handleProductNotFoundException(ProductNotFoundException ex) {
        CustomExceptionMessage exceptionMessage = new CustomExceptionMessage(
                LocalDateTime.now(),
                ex.getMessage(),
                404
        );
        return ResponseEntity.status(404).body(exceptionMessage);
    }

    @ExceptionHandler(UserNotFoundException.class)
    public ResponseEntity<?> handleUserNotFoundException(UserNotFoundException ex) {
        CustomExceptionMessage exceptionMessage = new CustomExceptionMessage(
                LocalDateTime.now(),
                ex.getMessage(),
                404
        );
        return ResponseEntity.status(404).body(exceptionMessage);
    }

    @ExceptionHandler(UserExistException.class)
    public ResponseEntity<?> handleUserExistException(UserExistException ex) {
        CustomExceptionMessage exceptionMessage = new CustomExceptionMessage(
                LocalDateTime.now(),
                ex.getMessage(),
                409
        );
        return ResponseEntity.status(409).body(exceptionMessage);
    }
}
