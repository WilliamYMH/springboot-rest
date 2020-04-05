/** 
 * 
 */
package com.proyecto.ereservation.model;


import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * Class client
 * @author Nocsabe
 *
 */

@Data
@Entity
@Table(name="client")
@NamedQuery(name="findByIdentificacion", query="Select c from Client c where c.identificacion = ?1")
public class Client {
	@Id
	@GeneratedValue(generator = "system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	String id_client;
	String nombre;
	String apellido;
	String identificacion;
	String direccion;
	String telefono;
	String email;
	String ciudad;
	@OneToMany(mappedBy = "client")
	Set<Reserva> reservas;
	
}
