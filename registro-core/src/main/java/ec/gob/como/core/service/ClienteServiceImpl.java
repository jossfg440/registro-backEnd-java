package ec.gob.como.core.service;


import ec.gob.como.domain.data.ClienteDto;
import ec.gob.como.domain.port.ClientePersistenciaPort;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class ClienteServiceImpl implements ClienteService {

	private final ClientePersistenciaPort clientePersistenciaPort;
	
	
	
	public ClienteServiceImpl(ClientePersistenciaPort clientePersistenciaPort) {
		
		this.clientePersistenciaPort = clientePersistenciaPort;
	}

	@Override
	public void addCliente(ClienteDto clienteDto) {
		clientePersistenciaPort.addCliente(clienteDto);
		
	}

	@Override
	@Transactional
	public void removeCliente(ClienteDto clienteDto) {
		clientePersistenciaPort.removeCliente(clienteDto);
		
	}

	@Override
	public void updateCliente(ClienteDto clienteDto) {
		clientePersistenciaPort.updateCliente(clienteDto);
		
	}

	@Override
	public List<ClienteDto> getAllClientes() {
		
		return clientePersistenciaPort.getAllClientes();
	}

	@Override
	public ClienteDto getClienteByNombre(String nombre) {
		
		return clientePersistenciaPort.getClienteByNombre(nombre);
	}

}
