package com.example.handleexceptions.handleexceptions.controllers;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.example.handleexceptions.handleexceptions.exceptions.UserNotFoundException;
import com.example.handleexceptions.handleexceptions.models.Error;

// Mapea excepciones a métodos de controladores anotados con @ExceptionHandler
@RestControllerAdvice
public class ErrorHandlerExceptionController {

  // mapea la excepción ArithmeticException a este método
  @ExceptionHandler({ ArithmeticException.class })
  public ResponseEntity<Error> divisionByZero(Exception e) {

    Error error = new Error("Division by zero", e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date());

    return ResponseEntity.internalServerError().body(error);
  }

  @ExceptionHandler(NumberFormatException.class)
  public ResponseEntity<Map<String, String>> numberFormatException(NumberFormatException e) {

    Map<String, String> error = new HashMap<>();

    error.put("date", new Date().toString());
    error.put("error", "numero invalido");
    error.put("message", e.getMessage());
    error.put("status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }

  @ExceptionHandler({ NullPointerException.class, HttpMessageNotWritableException.class, UserNotFoundException.class })
  public ResponseEntity<Map<String, String>> userNotFoundException(Exception e) {

    Map<String, String> error = new HashMap<>();

    error.put("date", new Date().toString());
    error.put("error", "Usuario o role no existe");
    error.put("message", e.getMessage());
    error.put("status", String.valueOf(HttpStatus.INTERNAL_SERVER_ERROR.value()));

    return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
  }

  @ExceptionHandler(NoHandlerFoundException.class)
  public ResponseEntity<Error> notFoundException(NoHandlerFoundException e) {
    Error error = new Error("Not found", e.getMessage(), HttpStatus.NOT_FOUND.value(), new Date());
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(error);
  }

}
