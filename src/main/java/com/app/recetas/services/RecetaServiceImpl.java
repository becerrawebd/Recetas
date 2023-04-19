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
    public void crearReceta(Receta receta) {
        recetaRepository.save(receta);
    }
}
