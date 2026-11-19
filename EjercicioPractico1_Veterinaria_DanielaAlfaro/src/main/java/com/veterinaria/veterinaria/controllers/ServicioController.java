/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.controllers;

/**
 *
 * @author dania
 */
import com.veterinaria.veterinaria.domain.Servicio;
import com.veterinaria.veterinaria.domain.TipoServicio;
import com.veterinaria.veterinaria.repository.ServicioRepository;
import com.veterinaria.veterinaria.repository.TipoServicioRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class ServicioController {
    private final ServicioRepository servicioRepository;
    private final TipoServicioRepository tipoServicioRepository;
    public ServicioController(
            ServicioRepository servicioRepository,
            TipoServicioRepository tipoServicioRepository) {
        this.servicioRepository = servicioRepository;
        this.tipoServicioRepository = tipoServicioRepository;
    }
    @GetMapping("/servicios")
    public String listarServicios(Model model) {
        model.addAttribute("servicios", servicioRepository.findAll());
        return "servicios/listado";
    }
    @GetMapping("/servicios/nuevo")
    public String nuevoServicio(Model model) {
        model.addAttribute("servicio", new Servicio());
        model.addAttribute("tiposServicio", tipoServicioRepository.findAll());
        return "servicios/formulario";
    }
    @GetMapping("/servicios/editar/{id}")
    public String editarServicio(@PathVariable Long id, Model model) {
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Servicio no encontrado: " + id));
        model.addAttribute("servicio", servicio);
        model.addAttribute("tiposServicio", tipoServicioRepository.findAll());
        return "servicios/formulario";
    }
    @PostMapping("/servicios/guardar")
    public String guardarServicio(
            @ModelAttribute Servicio servicio,
            RedirectAttributes redirectAttributes) {
        servicioRepository.save(servicio);
        redirectAttributes.addFlashAttribute(
                "mensaje", "Servicio guardado correctamente.");
        return "redirect:/servicios";
    }
    @GetMapping("/servicios/eliminar/{id}")
    public String eliminarServicio(
            @PathVariable Long id,
            RedirectAttributes redirectAttributes) {
        Servicio servicio = servicioRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException(
                        "Servicio no encontrado: " + id));
        servicioRepository.delete(servicio);
        redirectAttributes.addFlashAttribute(
                "mensaje", "Servicio eliminado correctamente.");
        return "redirect:/servicios";
    }
}