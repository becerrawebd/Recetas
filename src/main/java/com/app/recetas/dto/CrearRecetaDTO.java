package com.app.recetas.dto;

import lombok.Data;

@Data
public class CrearRecetaDTO {
    private String nombre;
    private String ingredientes;
    private String preparacion;
}
