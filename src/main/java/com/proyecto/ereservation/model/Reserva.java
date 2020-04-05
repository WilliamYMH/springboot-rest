/**
 * 
 */
package com.proyecto.ereservation.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.GenericGenerator;

import lombok.Data;

/**
 * @author Nocsabe
 *
 */
@Data
@Entity
@Table(name = "reserva")
public class Reserva {
	@Id
	@GeneratedValue(generator="system-uuid")
	@GenericGenerator(name = "system-uuid", strategy = "uuid2")
	String id_reserva;
	
	@Column(name = "fecha_ingreso")
	@Temporal(TemporalType.DATE)
	Date fechaIngreso;
	
	@Column(name = "fecha_salida")
	@Temporal(TemporalType.DATE)
	Date fechaSalida;
	
	int cantidadPersonas;
	String descripcion;
	
	@ManyToOne
	@JoinColumn(name = "id_client")
	Client client;
}
