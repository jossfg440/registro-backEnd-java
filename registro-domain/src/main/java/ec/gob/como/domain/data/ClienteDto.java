package ec.gob.como.domain.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Builder
@Data
@NoArgsConstructor
public class ClienteDto {

	private String nombre;
    private String email;
    private String telefono;
    private String tipoBeneficio;
    private String beneficio;
}
