/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.service;

/**
 *
 * @author dania
 */
import com.veterinaria.veterinaria.domain.Cita;
import com.veterinaria.veterinaria.repository.CitaRepository;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class CitaService {
    private final CitaRepository citaRepository;
    public CitaService(CitaRepository citaRepository) {
        this.citaRepository = citaRepository;
    }
    public List<Cita> listarCitas() {
        return citaRepository.findAll();
    }
    public Cita buscarCita(Long id) {
        return citaRepository.findById(id).orElse(null);
    }
    public Cita guardarCita(Cita cita) {
        return citaRepository.save(cita);
    }
}