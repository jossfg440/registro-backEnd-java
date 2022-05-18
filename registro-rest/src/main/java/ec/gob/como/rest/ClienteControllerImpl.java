package ec.gob.como.rest;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import ec.gob.como.core.service.ClienteService;

import ec.gob.como.domain.data.ClienteDto;
import ec.gob.como.domain.exception.ClienteNoExisteException;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
public class ClienteControllerImpl implements ClienteController {

	private final ClienteService clienteService;
	
	
	public ClienteControllerImpl(ClienteService clienteService) {
	
		this.clienteService = clienteService;
	}

	@Override
	public ResponseEntity<Void> addCliente(ClienteDto clienteDto) {
		 
		/*
		 String uri = "http://localhost:8080/buscar_beneficio/"+clienteDto.getTipoBeneficio();
		 RestTemplate restTemplate = new RestTemplate();
		 String beneficioEncontrado = restTemplate.getForObject(uri, String.class);
		 if ( beneficioEncontrado !="No existe beneficio" ) {
			
		 } */
		 clienteService.addCliente(clienteDto);
		return new ResponseEntity<>(HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<String> removeCliente(ClienteDto clienteDto) {
		clienteService.removeCliente(clienteDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<String> updateCliente(ClienteDto clienteDto) {
		clienteService.updateCliente(clienteDto);
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@Override
	public ResponseEntity<ClienteDto> getClienteByNombre(String nombre) {
		try {
			return new ResponseEntity<>(clienteService.getClienteByNombre(nombre),HttpStatus.OK);
		}catch(ClienteNoExisteException ex) {
			log.error("Error!",ex);
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);	
		}
		
	}

	@Override
	public ResponseEntity<List<ClienteDto>> getCliente() {
		
		return new ResponseEntity<>(clienteService.getAllClientes(),HttpStatus.OK);
	}

}
