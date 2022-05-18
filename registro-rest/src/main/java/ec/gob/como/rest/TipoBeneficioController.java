package ec.gob.como.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



public interface TipoBeneficioController {
	
	@GetMapping("/buscar_beneficio/{tipoBeneficio}")
    ResponseEntity<String> getBuscarBeneficio(@PathVariable String tipoBeneficio);

}
