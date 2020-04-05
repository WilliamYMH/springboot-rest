package com.proyecto.ereservation.repository;

import java.util.Date; 
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.proyecto.ereservation.model.Reserva;

public interface ReservaRepository extends JpaRepository<Reserva, String> {
	@Query("Select r from Reserva r where r.fechaIngreso = :fechaIngreso and r.fechaSalida=:fechaSalida")
	public List<Reserva> findByDate(@Param("fechaIngreso") Date fechaIngreso, @Param("fechaSalida") Date fechaSalida);
}
