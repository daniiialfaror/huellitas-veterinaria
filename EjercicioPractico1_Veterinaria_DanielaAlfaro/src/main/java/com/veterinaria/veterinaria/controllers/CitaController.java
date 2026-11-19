/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.controllers;

/**
 *
 * @author dania
 */
import com.veterinaria.veterinaria.domain.Cita;
import com.veterinaria.veterinaria.domain.Servicio;
import com.veterinaria.veterinaria.service.CitaService;
import com.veterinaria.veterinaria.service.ServicioService;
import java.time.LocalDate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@RequestMapping("/citas")
public class CitaController {
    private final CitaService citaService;
    private final ServicioService servicioService;
    public CitaController(CitaService citaService,
                          ServicioService servicioService) {
        this.citaService = citaService;
        this.servicioService = servicioService;
    }
    @GetMapping
    public String listarCitas(Model model) {
        model.addAttribute("citas", citaService.listarCitas());
        return "citas/listado";
    }
    @GetMapping("/nueva")
    public String nuevaCita(Model model) {
        model.addAttribute("cita", new Cita());
        model.addAttribute("servicios", servicioService.listarServicios());
        return "citas/formulario";
    }
    @PostMapping("/guardar")
    public String guardarCita(
            @RequestParam String nombreMascota,
            @RequestParam String nombrePropietario,
            @RequestParam String fecha,
            @RequestParam Long servicioId) {
        Cita cita = new Cita();
        cita.setNombreMascota(nombreMascota);
        cita.setNombrePropietario(nombrePropietario);
        cita.setFecha(LocalDate.parse(fecha));
        Servicio servicio = servicioService.buscarServicio(servicioId);
        cita.setServicio(servicio);
        citaService.guardarCita(cita);
        return "redirect:/citas";
    }
}