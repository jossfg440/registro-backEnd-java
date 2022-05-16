package ec.gob.como.core.service;

import org.springframework.stereotype.Service;

import ec.gob.como.domain.port.TipoBeneficioArchivoPort;

@Service
public class TipoBeneficioServiceImpl implements TipoBeneficioService {

	private final TipoBeneficioArchivoPort tipoBeneficioArchivoPort;
	
	
	


	public TipoBeneficioServiceImpl(TipoBeneficioArchivoPort tipoBeneficioArchivoPort) {
		this.tipoBeneficioArchivoPort = tipoBeneficioArchivoPort;
	}


	@Override
	public String buscarBeneficio(String tipoBeneficio) {
	 
		return tipoBeneficioArchivoPort.buscarBeneficio(tipoBeneficio);
	}

}
