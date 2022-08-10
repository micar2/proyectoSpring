package com.example.proyectos.controller;

import com.example.proyectos.model.Proyecto;
import com.example.proyectos.repo.ProyectoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin//para angular
@RestController
@RequestMapping("/proyectos")
public class ProyectoController {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @GetMapping("")
    List<Proyecto> index() {
        return proyectoRepository.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("")
    Proyecto create(@RequestBody Proyecto proyecto){

        return proyectoRepository.save(proyecto);
    }

    @PutMapping("{id}")
    Proyecto update(@PathVariable String id,@RequestBody Proyecto proyecto ){
        Proyecto proyctoId = proyectoRepository.findById(id).orElseThrow(RuntimeException::new);
        proyctoId.setNombre(proyecto.getNombre());
        proyctoId.setCompletado(proyecto.isCompletado());
        return proyectoRepository.save(proyctoId);
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    @DeleteMapping("{id}")
    void delete(@PathVariable String id){
        Proyecto proyectoId = proyectoRepository.findById(id).orElseThrow(RuntimeException::new);
        proyectoRepository.delete(proyectoId);
    }


}
