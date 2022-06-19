package com.example.spring.proyect.controller;

import com.example.spring.proyect.dto.EntradaDto;
import com.example.spring.proyect.dto.SalidaDto;
import com.example.spring.proyect.service.UtilidadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/utilidades")
public class Controller {

    @Autowired
    private UtilidadService utilidadService;

   @GetMapping("/hello")
    public String hello () {
        return "hola mundo";
    }

    @PostMapping("/saludo")
    public ResponseEntity<SalidaDto> saludo (@Valid @RequestBody EntradaDto entrada) {
        return new ResponseEntity<>(utilidadService.saludar(entrada), HttpStatus.OK);
    }

}
