/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.controllers;

/**
 *
 * @author dania
 */
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
@Controller
public class ContactoController {
    @GetMapping("/contacto")
    public String mostrarContacto() {
        return "contacto";
    }
    @PostMapping("/contacto")
    public String enviarContacto(
            @RequestParam String nombre,
            @RequestParam String correo,
            @RequestParam String nombreMascota,
            @RequestParam String mensaje,
            RedirectAttributes redirectAttributes) {
        redirectAttributes.addFlashAttribute(
                "mensajeExito",
                "¡Gracias, " + nombre + "! Recibimos tu consulta y pronto te atenderemos.");
        return "redirect:/contacto";
    }
}
