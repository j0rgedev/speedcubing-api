package com.george.speedcubingapi.exception;

import jakarta.validation.ConstraintViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerAdvice {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<CustomError> handleBusinessException(BusinessException e) {
        return new ResponseEntity<>(
                new CustomError(e.getHttpStatus().value(), e.getMessage()),
                e.getHttpStatus()
        );
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomError> handleException(Exception e) {
        return new ResponseEntity<>(
                new CustomError(500, "Internal server error"),
                HttpStatus.INTERNAL_SERVER_ERROR
        );
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<CustomError> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return new ResponseEntity<>(
                new CustomError(400, "Bad request. Check the documentation"),
                HttpStatus.BAD_REQUEST
        );
    }

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity<CustomError> handleConstraintViolationException(ConstraintViolationException e) {
        return new ResponseEntity<>(
                new CustomError(400, "Bad request. Check the documentation"),
                HttpStatus.BAD_REQUEST
        );
    }

}
