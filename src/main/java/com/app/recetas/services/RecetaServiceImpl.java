package com.app.recetas.services;

import com.app.recetas.models.Receta;
import com.app.recetas.repositories.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class RecetaServiceImpl implements RecetaService{
    @Autowired
    private RecetaRepository recetaRepository;
    @Override
    public void crearReceta(String nombre, String ingredientes, String preparacion) {
        Receta receta = Receta.builder()
                .nombre(nombre)
                .ingredientes(ingredientes)
                .preparacion(preparacion)
                .date(new Date())
                .build();
        recetaRepository.save(receta);
    }
}
