package com.example.spring.proyect.service;

import com.example.spring.proyect.bd.entities.UsuarioEntity;
import com.example.spring.proyect.bd.repository.UsuarioRepository;
import com.example.spring.proyect.dto.UsuariosDto;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class UsuariosService {

    @Autowired
    UsuarioRepository usuarioRepository;

    public UsuariosDto obtenePorId(Integer id){
        Optional<UsuarioEntity> opt = usuarioRepository.findById(id);
        if (opt.isPresent()){
            log.info(opt.get().toString());
            UsuarioEntity usuario = opt.get();
            usuario.setFechaRegistro(new Date());

            usuarioRepository.save(usuario);
        }else {
            log.info("no encontre usuario");
        }
        UsuariosDto usuario = new UsuariosDto();
        usuario.setId(opt.get().getId());
        usuario.setEstatus(opt.get().getEstatus());
        usuario.setNombre(opt.get().getNombre());
        usuario.setEmail(opt.get().getEmail());
        usuario.setFecharegistro(opt.get().getFechaRegistro());
        usuario.setUsername(opt.get().getUsername());
        usuario.setPassword(opt.get().getPassword());
        return usuario;
    }

    public List<UsuarioEntity> getPaginadoOrdenado(){

        Page<UsuarioEntity> page = usuarioRepository.findAll(PageRequest.of(0, 5, Sort.by("nombre").ascending()));

        return page.getContent();

    }


}
