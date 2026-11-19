/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.service;

/**
 *
 * @author dania
 */
import com.veterinaria.veterinaria.domain.Servicio;
import com.veterinaria.veterinaria.repository.ServicioRepository;
import java.util.List;
import org.springframework.stereotype.Service;
@Service
public class ServicioService {
    private final ServicioRepository servicioRepository;
    public ServicioService(ServicioRepository servicioRepository) {
        this.servicioRepository = servicioRepository;
    }
    public List<Servicio> listarServicios() {
        return servicioRepository.findAll();
    }
    public Servicio buscarServicio(Long id) {
        return servicioRepository.findById(id).orElse(null);
    }
    public void guardarServicio(Servicio servicio) {
        servicioRepository.save(servicio);
    }
    public void eliminarServicio(Long id) {
        servicioRepository.deleteById(id);
    }
}