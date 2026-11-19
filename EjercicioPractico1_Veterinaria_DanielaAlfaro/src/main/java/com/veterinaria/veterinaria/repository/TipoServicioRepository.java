/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.veterinaria.veterinaria.repository;

/**
 *
 * @author dania
 */
import com.veterinaria.veterinaria.domain.TipoServicio;
import org.springframework.data.jpa.repository.JpaRepository;
public interface TipoServicioRepository extends JpaRepository<TipoServicio, Long> {
}
