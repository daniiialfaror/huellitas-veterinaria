/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.controllers;

/**
 *
 * @author dania
 */
import com.veterinaria.veterinaria.domain.TipoServicio;
import com.veterinaria.veterinaria.repository.TipoServicioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
@Controller
@RequestMapping("/tipos-servicio")
public class TipoServicioController {
    private final TipoServicioRepository tipoServicioRepository;
    public TipoServicioController(
            TipoServicioRepository tipoServicioRepository) {
        this.tipoServicioRepository = tipoServicioRepository;
    }
    @GetMapping
    public String listarTiposServicio(Model model) {
        model.addAttribute(
                "tiposServicio",
                tipoServicioRepository.findAll());
        return "tipos-servicio/listado";
    }
}