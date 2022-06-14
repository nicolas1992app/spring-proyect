package com.example.spring.proyect.service;

import com.example.spring.proyect.dto.EntradaDto;
import com.example.spring.proyect.dto.SalidaDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class UtilidadService {

    public SalidaDto saludar(EntradaDto entrada){
        SalidaDto salida = new SalidaDto();
        salida.setSaludo("hola "+ entrada.getNombre());
        log.info(salida.getSaludo());
        log.info("salida");
        return salida;
    }
}
