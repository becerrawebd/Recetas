package com.app.recetas.controller;
import com.app.recetas.dto.CrearRecetaDTO;
import com.app.recetas.models.Receta;
import com.app.recetas.services.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Date;

@Controller
public class HomeController {
    @Autowired
    private RecetaService recetaService;
    @GetMapping("/")
    public String saludar(){
        return "saludo";
    }
    @GetMapping("/nuevaReceta")
    public String formularioCrearReceta(Model model){
        CrearRecetaDTO recetaDTO = new CrearRecetaDTO();
        model.addAttribute("receta", recetaDTO);
        return "crearReceta";
    }
    @PostMapping("/nuevaReceta")
    public String crearNuevaReceta(@ModelAttribute CrearRecetaDTO recetaDTO){
        Receta receta = Receta.builder()
                .nombre(recetaDTO.getNombre())
                .ingredientes(recetaDTO.getIngredientes())
                .preparacion(recetaDTO.getPreparacion())
                .date(new Date())
                .build();
        recetaService.crearReceta(receta);
        return "saludo";
    }
}
