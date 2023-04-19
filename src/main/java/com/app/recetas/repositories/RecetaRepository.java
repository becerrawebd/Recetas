package com.app.recetas.repositories;

import com.app.recetas.models.Receta;
import org.springframework.data.repository.CrudRepository;

public interface RecetaRepository extends CrudRepository<Receta, Long> {
}
