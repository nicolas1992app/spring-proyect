package com.example.spring.proyect.controller;

import com.example.spring.proyect.bd.entities.UsuarioEntity;
import com.example.spring.proyect.dto.UsuariosDto;
import com.example.spring.proyect.service.UsuariosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/usuario")
@Slf4j
public class UsuariosController {

    @Autowired
    UsuariosService usuariosService;

    @GetMapping("/obtener/{id}")
    public ResponseEntity<UsuariosDto> obtenerPorId (@PathVariable Integer id) {
        return new ResponseEntity<>(usuariosService.obtenePorId(id), HttpStatus.OK);
    }

    @GetMapping("/obtener/ordenados")
    public  ResponseEntity<List<UsuarioEntity>> obtenerOrdenados (@Valid Integer id) {
        List<UsuarioEntity> listaUsuarios;
        listaUsuarios= usuariosService.getPaginadoOrdenado();
        return new ResponseEntity<>(listaUsuarios, HttpStatus.OK);
    }
}
