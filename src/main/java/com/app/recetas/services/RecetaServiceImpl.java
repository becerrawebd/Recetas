package com.app.recetas.services;

import com.app.recetas.models.Receta;
import com.app.recetas.repositories.RecetaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class RecetaServiceImpl implements RecetaService{
    @Autowired
    private RecetaRepository recetaRepository;
    @Override
    public void crearReceta(Receta receta) {
        recetaRepository.save(receta);
    }

    @Override
    public List<Receta> obtenerRecetas(Integer pagina, Integer cantidadResultados) {
        Pageable pageable = Pageable
                .ofSize(cantidadResultados)
                .withPage(pagina);
        return recetaRepository.findAll(pageable).toList();
    }
}
