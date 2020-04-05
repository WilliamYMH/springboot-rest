package com.proyecto.ereservation.resources;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.proyecto.ereservation.model.Client;
import com.proyecto.ereservation.resources.vo.ClientVO;
import com.proyecto.ereservation.service.ClientService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;

/**
 * Clase que representa el servicio web de cliente
 * 
 * @author Nocsabe
 *
 */
@RestController
@RequestMapping("/api/cliente")
@Api(tags = "client")
public class ClientResource {

	private final ClientService clientService;

	public ClientResource(ClientService clientService) {
		this.clientService = clientService;
	}

	@PostMapping
	@ApiOperation(value = "crear cliente", notes = "Servicio para crear cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente creado correctamente"),
			@ApiResponse(code = 400, message = "Solicitud invalida") })
	public ResponseEntity<Client> createClient(@RequestBody ClientVO clientVo) {
		Client client = new Client();
		client.setIdentificacion(clientVo.getIdentificacion());
		client.setNombre(clientVo.getNombre());
		client.setEmail(clientVo.getEmail());
		client.setApellido(clientVo.getApellido());

		return new ResponseEntity<>(this.clientService.create(client), HttpStatus.CREATED);
	}

	@PutMapping("/{identificacion}")
	@ApiOperation(value = "actualizar cliente", notes = "Servicio para actualizar cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente actualizado correctamente"),
			@ApiResponse(code = 404, message = "Solicitud invalida") })
	public ResponseEntity<Client> updateClient(@PathVariable("identificacion") String identificacion,
			ClientVO clientVo) {
		Client client = this.clientService.findByIdentificacion(identificacion);

		if (client == null) {
			return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
		} else {
			client.setIdentificacion(clientVo.getIdentificacion());
			client.setNombre(clientVo.getNombre());
			client.setEmail(clientVo.getEmail());
			client.setApellido(clientVo.getApellido());
		}

		return new ResponseEntity<>(this.clientService.update(client), HttpStatus.OK);
	}

	@DeleteMapping("/{identificacion}")
	@ApiOperation(value = "eliminar cliente", notes = "Servicio para eliminar cliente")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Cliente eliminado correctamente"),
			@ApiResponse(code = 404, message = "Solicitud invalida") })
	public void removeClient(@PathVariable("identificacion") String identificacion) {
		Client client = this.clientService.findByIdentificacion(identificacion);
		if (client != null) {
			this.clientService.delete(client);
		}
	}

	@GetMapping
	@ApiOperation(value = "listar clientes", notes = "Servicio para listar todos los clientes")
	@ApiResponses(value = { @ApiResponse(code = 201, message = "Clientes listados correctamente"),
			@ApiResponse(code = 404, message = "clientes no encontrados") })
	public ResponseEntity<List<Client>> findAll() {

		return ResponseEntity.ok(this.clientService.findAll());
	}

}
