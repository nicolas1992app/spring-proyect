package com.example.spring.proyect.dto;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import lombok.Data;


@Data
public class EntradaDto {
    
    @NotNull
    private String nombre;
}
