package com.example.spring.proyect.dto;

import lombok.Data;

import javax.persistence.Column;
import java.util.Date;

@Data
public class UsuariosDto {

    private Integer id;

    private String nombre;

    private String email;

    private String username;

    private String password;

    private Integer estatus;

    private Date fecharegistro;

}
