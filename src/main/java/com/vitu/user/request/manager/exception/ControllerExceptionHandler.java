package com.vitu.user.request.manager.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<BasicError> resourceNotFoundExceptionHandler(NotFoundException notFoundException) {
        BasicError basicError = BasicError.builder()
                .code(HttpStatus.NOT_FOUND.value())
                .date(LocalDateTime.now())
                .message(notFoundException.getMessage())
                .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(basicError);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<BasicError> methodArgumentNotValidExceptionHandler(MethodArgumentNotValidException
                                                                                     methodArgumentNotValidException) {
        BasicError basicError = BasicError.builder()
                .code(HttpStatus.BAD_REQUEST.value())
                .date(LocalDateTime.now())
                .message(methodArgumentNotValidException.getMessage())
                .build();

        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(basicError);

    }
}
