/**
 * 
 */
package com.proyecto.ereservation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.proyecto.ereservation.model.Client;

/**
 * @author Nocsabe
 *
 */
public interface ClientRepository extends JpaRepository<Client, String> {
	public List<Client> findByApellido(String apellido);
	
	public Client findByIdentificacion(String identificacion);
}
