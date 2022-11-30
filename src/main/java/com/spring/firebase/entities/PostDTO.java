package com.spring.firebase.entities;

import lombok.Data;
//ahorramos los get y set con lombok
@Data

public class PostDTO {
    private String id;
    private String apellido;
    private String direccion;
    private String nombre;
    private String telefono;
}
