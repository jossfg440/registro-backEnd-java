package ec.gob.como.test;

import java.util.Collections;
import java.util.List;

import ec.gob.como.core.service.ClienteService;
import ec.gob.como.core.service.ClienteServiceImpl;
import ec.gob.como.domain.data.ClienteDto;
import ec.gob.como.domain.port.ClientePersistenciaPort;

public class Main {
	public static void main(String[] args) {
		final ClienteService clienteService = new ClienteServiceImpl(createMockClientePersistenciaPort());
		final ClienteDto clienteDto = ClienteDto.builder()
				.tipoBeneficio("SK")
				.nombre("Lucia Paz")
				.build();
		clienteService.addCliente(clienteDto);
		clienteService.updateCliente(clienteDto);
		clienteService.removeCliente(clienteDto);
		final List<ClienteDto> allClienteDtos = clienteService.getAllClientes();
		final ClienteDto clienteDtoByNombre = clienteService.getClienteByNombre("Lucia Paz");
		
		assert allClienteDtos.size() == 1;
		
		final ClienteDto clienteDto1 = allClienteDtos.get(0);
		assert clienteDto1.getBeneficio()
				.equals("SK");
		assert clienteDtoByNombre.getBeneficio()
				.equals("SK");
		assert clienteDtoByNombre.getNombre()
				.equals("Luis Perez");
	
		
	}
	
	private static ClientePersistenciaPort createMockClientePersistenciaPort() {
		return new ClientePersistenciaPort() {

			@Override
			public void addCliente(ClienteDto clienteDto) {
				
				
			}

			@Override
			public void removeCliente(ClienteDto clienteDto) {
				
				
			}

			@Override
			public void updateCliente(ClienteDto clienteDto) {
				
				
			}

			@Override
			public List<ClienteDto> getAllClientes() {
				final ClienteDto clienteDto = ClienteDto.builder()
						.tipoBeneficio("SK")
						.nombre("Luis Perez")
						.build();
				return Collections.singletonList(clienteDto);
			}

			@Override
			public ClienteDto getClienteByNombre(String nombre) {
				
				return ClienteDto.builder()
						.tipoBeneficio("TH")
						.nombre("Alvaro Pixe")
						.build();
			}
			
		};
	}

}
