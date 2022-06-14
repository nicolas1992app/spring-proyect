package com.example.spring.proyect.exception;

import com.example.spring.proyect.dto.SalidaDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;


@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<SalidaDto> handleException(Exception ex){
        SalidaDto respuesta = new SalidaDto();
        respuesta.setError(true);
        return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
