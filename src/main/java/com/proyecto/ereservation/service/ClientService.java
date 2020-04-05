package com.proyecto.ereservation.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.proyecto.ereservation.model.Client;
import com.proyecto.ereservation.repository.ClientRepository;

@Service
@Transactional(readOnly = true)
public class ClientService {
	private final ClientRepository clientRepository;

	public ClientService(ClientRepository clientRepository) {
		this.clientRepository = clientRepository;
	}

	/**
	 * Metodo para guardar cliente
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Client create(Client cliente) {
		return this.clientRepository.save(cliente);
	}

	/**
	 * Metodo para actualizar cliente
	 * 
	 * @param cliente
	 * @return
	 */
	@Transactional
	public Client update(Client cliente) {
		return this.clientRepository.save(cliente);
	}

	/**
	 * Metodo para eliminar un cliente
	 * 
	 * @param cliente
	 */
	@Transactional
	public void delete(Client cliente) {
		this.clientRepository.delete(cliente);
	}

	/**
	 * Metodo para consultar un cliente por su identificacion
	 * 
	 * @param identificacion
	 * @return
	 */
	@Transactional
	public Client findByIdentificacion(String identificacion) {
		return this.clientRepository.findByIdentificacion(identificacion);
	}
	
	@Transactional
	public List<Client> findAll() {
		return this.clientRepository.findAll();
	}

}
