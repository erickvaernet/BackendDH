package com.example.integradorV2;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static Logger logger= Logger.getLogger(GlobalExceptionHandler.class);
    @ExceptionHandler
    public ResponseEntity<?> allErrors(Exception ex, WebRequest req){
        logger.error(ex.getMessage());
        return  ResponseEntity.internalServerError()
                .body("Error: "+ex.getMessage());
    }
}
