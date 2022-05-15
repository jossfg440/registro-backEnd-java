package ec.gob.como.jpa.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import static javax.persistence.GenerationType.IDENTITY;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "CLIENTE")
@Data
public class ClienteEntity {
	 	@Id
	    @GeneratedValue(strategy = IDENTITY)
	    @Column
	    private String nombre;
	 	
	 	@Column
	 	private String email;
	 	@Column
	 	private String telefono;
	 	@Column
	 	private String tipoBeneficio;
	 	@Column
	 	private String beneficio;

}
