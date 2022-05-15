package ec.gob.como.core.service;

import java.util.List;

import ec.gob.como.domain.data.ClienteDto;

public interface ClienteService {
	void addCliente(ClienteDto clienteDto);
	void removeCliente(ClienteDto clienteDto);
	void updateCliente(ClienteDto clienteDto);
	List<ClienteDto> getAllClientes();
	ClienteDto getClienteByNombre(String nombre);

}
