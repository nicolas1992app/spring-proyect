package com.example.spring.proyect.cController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
   @GetMapping("hello")
    public String hello () {
        return "hola mundo";
    }
}
