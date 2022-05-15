package ec.gob.como.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import ec.gob.como.jpa.model.ClienteEntity;

public interface ClienteRepository extends JpaRepository<ClienteEntity, String> {
	
	void deleteAllByNombre(String nombre);
	ClienteEntity findByNombre(String nombre);
	ClienteEntity findByTipoBeneficio(String tipoBeneficio);
}
