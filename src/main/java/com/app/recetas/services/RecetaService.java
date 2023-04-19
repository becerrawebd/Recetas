package com.app.recetas.services;

import com.app.recetas.models.Receta;

import java.util.List;

public interface RecetaService {
    void crearReceta(Receta receta);

    List<Receta> obtenerRecetas(Integer pagina, Integer cantidadResultados);
}
