package com.app.recetas.services;

import com.app.recetas.models.Receta;

public interface RecetaService {
    void crearReceta(String nombre, String ingredientes, String preparacion);
}
