package com.app.recetas.controller;
import com.app.recetas.dto.CrearRecetaDTO;
import com.app.recetas.models.Receta;
import com.app.recetas.services.RecetaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private RecetaService recetaService;

    @GetMapping("/recetas")
    public String obtenerRecetas(@RequestParam(name = "pagina", required = false) Integer pagina, Model model){
        if(pagina == null){
            return "redirect:/recetas?pagina=0";
        }
        List<Receta> recetas = recetaService.obtenerRecetas(pagina, 20);
        model.addAttribute("recetas",recetas);
        return "recetas";
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
        return "redirect:/recetas?pagina=0";
    }
}
