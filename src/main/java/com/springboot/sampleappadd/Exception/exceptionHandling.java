package com.springboot.sampleappadd.Exception;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@ControllerAdvice
public class exceptionHandling {
    @ExceptionHandler(RuntimeException.class)
    private ResponseEntity<String> customException(RuntimeException ex){
        System.out.println(" Error is "+ex.getMessage());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(ex.getMessage());
    }

    @ExceptionHandler(NoResourceFoundException.class)
    private ResponseEntity<String> customExceptionNotFound(NoResourceFoundException ex){
        System.out.println(" Error is "+ex.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }


}
