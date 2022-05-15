package ec.gob.como.domain.port;

import java.util.List;

import ec.gob.como.domain.data.ClienteDto;

public interface ClientePersistenciaPort {
	void addCliente(ClienteDto clienteDto);
	void removeCliente(ClienteDto clienteDto);
	void updateCliente(ClienteDto clienteDto);
	List<ClienteDto> getAllClientes();
	ClienteDto getClienteByNombre(String nombre);
	

}
