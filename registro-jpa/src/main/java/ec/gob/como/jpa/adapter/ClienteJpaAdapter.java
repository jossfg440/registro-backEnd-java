package ec.gob.como.jpa.adapter;

import lombok.SneakyThrows;
import ec.gob.como.archivo.operacion.ManipulaJsonFile;
import ec.gob.como.archivo.operacion.ManipulaXmlFile;
import ec.gob.como.domain.data.ClienteDto;
import ec.gob.como.domain.port.ClientePersistenciaPort;
import ec.gob.como.jpa.model.ClienteEntity;
import ec.gob.como.jpa.repository.ClienteRepository;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Objects;

import java.util.stream.Collectors;

@Service
public class ClienteJpaAdapter implements ClientePersistenciaPort {

	private ClienteRepository clienteRepository;
	
	public ClienteJpaAdapter(ClienteRepository clienteRepository) {
	
		this.clienteRepository = clienteRepository;
	}

	@Override
	public void addCliente(ClienteDto clienteDto) {
		final ClienteEntity clienteEntity = getClienteEntity(clienteDto);
		clienteRepository.save(clienteEntity);
		
	}

	@Override
	public void removeCliente(ClienteDto clienteDto) {
		clienteRepository.deleteAllByNombre(clienteDto.getNombre());
		
	}

	@Override
	public void updateCliente(ClienteDto clienteDto) {
		final ClienteEntity buscandoPorNombre = clienteRepository.findByNombre(clienteDto.getNombre());
		if(Objects.nonNull(buscandoPorNombre)) {
			buscandoPorNombre.setNombre(clienteDto.getNombre());
			clienteRepository.save(buscandoPorNombre);
		} else {
			final ClienteEntity buscandoPorTipoBeneficio = clienteRepository.findByTipoBeneficio(clienteDto.getTipoBeneficio()) ;
			if (Objects.nonNull(buscandoPorTipoBeneficio)) {
				buscandoPorTipoBeneficio.setTipoBeneficio(clienteDto.getTipoBeneficio());
				clienteRepository.save(buscandoPorTipoBeneficio);
			}
		}
	}

	@Override
	public List<ClienteDto> getAllClientes() {
		
		return clienteRepository.findAll()
				.stream().map(this::getClientes)
				.collect(Collectors.toList());
				
	}

	@SneakyThrows
	@Override
	public ClienteDto getClienteByNombre(String nombre) {
		
		return getClientes(clienteRepository.findByNombre(nombre));
	}
	
	private ClienteEntity getClienteEntity(ClienteDto clienteDto){
		
		/*
		String beneficio="";
		if (clienteDto.getTipoBeneficio().equals("SK")) {
			ManipulaJsonFile fila = new ManipulaJsonFile();
			beneficio =fila.buscarBeneficio();
			
		} else if (clienteDto.getTipoBeneficio().equals("TH")) {
			ManipulaXmlFile fila = new ManipulaXmlFile();
			beneficio =fila.buscarBeneficio();
			
		}*/
		
		return ClienteEntity.builder()
					.nombre(clienteDto.getNombre())
					.email(clienteDto.getEmail())
					.telefono(clienteDto.getTelefono())
					.tipoBeneficio(clienteDto.getTipoBeneficio())
					.beneficio(clienteDto.getBeneficio())
					.build();
		
		
	}
	
	private ClienteDto getClientes(ClienteEntity clienteEntity) {
		return ClienteDto.builder()
				.nombre(clienteEntity.getNombre())
				.email(clienteEntity.getEmail())
				.telefono(clienteEntity.getTelefono())
				.tipoBeneficio(clienteEntity.getTipoBeneficio())
				.beneficio(clienteEntity.getBeneficio())
				.build();
	}
	
	

}
