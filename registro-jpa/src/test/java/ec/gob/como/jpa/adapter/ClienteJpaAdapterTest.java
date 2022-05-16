package ec.gob.como.jpa.adapter;

import ec.gob.como.domain.data.ClienteDto;
import ec.gob.como.domain.port.ClientePersistenciaPort;
import ec.gob.como.jpa.model.ClienteEntity;
import ec.gob.como.jpa.repository.ClienteRepository;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.only;
import static org.mockito.Mockito.verify;

import java.util.logging.Logger;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;


@SpringBootTest(classes = {
        ClienteJpaAdapter.class,
        ClientePersistenciaPort.class})
public class ClienteJpaAdapterTest {
	private static final String TEST_NOMBRE ="Jose";
	private static final String TEST_NOMBRE_2="Luis Perez";
	private static final String TEST_CORREO="j@com.com";
	private static final String TEST_TELEFONO="3434343";
	private static final String TEST_TIPO_BENEFICIO="SK";
	private static final String TEST_BENEFICIO="Descuento1";
	private static Logger log = Logger.getLogger("Test");

	@Autowired
	 private ClientePersistenciaPort clientePersistenciaPort;
	
	@MockBean
	private ClienteRepository mockClienteRepository;
	
	@Captor
	private ArgumentCaptor<ClienteEntity> clienteEntityArgumentCaptor;

	@Test
	void givenCliente_whenAddCliente_thenEntityIsPortedToRepository() {
		final ClienteDto testClienteDto = ClienteDto.builder()
				.nombre(TEST_NOMBRE_2)
				.email(TEST_CORREO)
				.telefono(TEST_TELEFONO)
				.tipoBeneficio(TEST_TIPO_BENEFICIO)
				.beneficio(TEST_BENEFICIO)
				.build();
		clientePersistenciaPort.addCliente(testClienteDto);
		
		verify(mockClienteRepository, only()).save(clienteEntityArgumentCaptor.capture());
		final ClienteEntity clienteEntity = clienteEntityArgumentCaptor.getValue();
		assertThat(clienteEntity.getNombre()).isEqualTo(TEST_NOMBRE_2);
		assertThat(clienteEntity.getTipoBeneficio()).isEqualTo(TEST_TIPO_BENEFICIO);
		
		log.info(clienteEntity.getNombre());
	}


}
