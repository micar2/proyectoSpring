package com.example.proyectos.repo;

import com.example.proyectos.model.Proyecto;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ProyectoRepository extends MongoRepository<Proyecto,String> {


}
