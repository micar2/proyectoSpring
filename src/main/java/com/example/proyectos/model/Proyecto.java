package com.example.proyectos.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document
public class Proyecto {
    @Id
    private String id;
    private String nombre;
    private boolean completado;

}
