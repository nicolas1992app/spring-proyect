package com.example.spring.proyect.exception;

import com.example.spring.proyect.dto.SalidaDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.NoSuchElementException;

@Slf4j
@ControllerAdvice
public class AppExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<SalidaDto> handleException(Exception ex){
        SalidaDto respuesta = new SalidaDto();
        respuesta.setError(true);
        log.error("error: ", ex);
        return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<SalidaDto> handleNotValidException(MethodArgumentNotValidException ex){
        SalidaDto respuesta = new SalidaDto();
        respuesta.setError(true);
        respuesta.setDescripcion(ex.getMessage());
        log.error("argumento no válido: ", ex);
        return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    @ExceptionHandler
    public ResponseEntity<SalidaDto> handleHttpMessageNotReadableException(HttpMessageNotReadableException ex){
        SalidaDto respuesta = new SalidaDto();
        respuesta.setError(true);
        respuesta.setDescripcion(ex.getMessage());
        log.error("Unexpected character: ", ex);
        return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler
    public ResponseEntity<SalidaDto> handleNoSuchElementException(NoSuchElementException ex){
        SalidaDto respuesta = new SalidaDto();
        respuesta.setError(true);
        respuesta.setDescripcion("No encontró informacion para ese usuario: " + ex.getMessage());
        log.error("No encontró informacion para ese usuario: ", ex);
        return new ResponseEntity<>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
