package com.ipreptech.management.controllers;

import com.ipreptech.management.exceptions.StudentNotFoundException;
import com.ipreptech.management.models.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorController {

    @ExceptionHandler(StudentNotFoundException.class)
    public ResponseEntity<ErrorMessage> handleException(StudentNotFoundException e) {
        ErrorMessage error = ErrorMessage.builder()
            .status(HttpStatus.BAD_REQUEST.value())
            .message(e.getMessage())
            .timeStamp(System.currentTimeMillis())
            .build();
        return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorMessage> handleException(Exception e) {
        ErrorMessage error = ErrorMessage.builder()
            .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
            .message(e.getMessage() + "Unknown Error")
            .timeStamp(System.currentTimeMillis())
            .build();
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
