package ec.gob.como.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.como.core.service.TipoBeneficioService;



@RestController
public class TipoBeneficioControllerImpl  implements TipoBeneficioController{

	private final TipoBeneficioService tipoBeneficioService;
	
	
	
	public TipoBeneficioControllerImpl(TipoBeneficioService tipoBeneficioService) {
		
		this.tipoBeneficioService = tipoBeneficioService;
	}



	@Override
	public ResponseEntity<String> getBuscarBeneficio(String tipoBeneficio) {
		
		return new ResponseEntity<>(tipoBeneficioService.buscarBeneficio(tipoBeneficio)
				,HttpStatus.OK);
	}

}
