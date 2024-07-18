package com.matricula.matricula.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalError extends ResponseEntityExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleModelDefaultException(Exception ex, WebRequest req) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(),
                req.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(NotFountException.class)
    public ResponseEntity<ErrorResponse> NotFountException(NotFountException ex, WebRequest req) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(),
                req.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
            HttpHeaders headers, HttpStatusCode status, WebRequest req) {
        ErrorResponse errorResponse = new ErrorResponse(LocalDateTime.now(), ex.getMessage(),
                req.getDescription(false));

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}
