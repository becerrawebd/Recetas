package com.app.recetas.repositories;

import com.app.recetas.models.Receta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface RecetaRepository extends JpaRepository<Receta,Long> {
}
