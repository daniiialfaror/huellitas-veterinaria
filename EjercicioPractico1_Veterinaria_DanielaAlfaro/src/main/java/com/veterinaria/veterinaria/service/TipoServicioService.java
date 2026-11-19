/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.veterinaria.veterinaria.service;

/**
 *
 * @author dania
 */
import com.veterinaria.veterinaria.domain.TipoServicio;
import com.veterinaria.veterinaria.repository.TipoServicioRepository;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public class TipoServicioService {

    private final TipoServicioRepository tipoServicioRepository;

    public TipoServicioService(TipoServicioRepository tipoServicioRepository) {
        this.tipoServicioRepository = tipoServicioRepository;
    }

    public List<TipoServicio> listarTiposServicio() {
        return tipoServicioRepository.findAll();
    }

    public TipoServicio buscarTipoServicio(Long id) {
        return tipoServicioRepository.findById(id).orElse(null);
    }

    public void guardarTipoServicio(TipoServicio tipoServicio) {
        tipoServicioRepository.save(tipoServicio);
    }

    public void eliminarTipoServicio(Long id) {
        tipoServicioRepository.deleteById(id);
    }
}
