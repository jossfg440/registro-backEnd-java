package ec.gob.como.core.service;



import ec.gob.como.domain.port.TipoBeneficioArchivoPort;


import org.springframework.stereotype.Service;


@Service
public class TipoBeneficioServiceImpl implements TipoBeneficioService {

	
	private final TipoBeneficioArchivoPort tipoBeneficioArchivoPort;
	
	/*
	public TipoBeneficioServiceImpl() {
		this.tipoBeneficioArchivoPort = null;
	}*/
	
	
	public  TipoBeneficioServiceImpl(TipoBeneficioArchivoPort tipoBeneficioArchivoPort) {
		this.tipoBeneficioArchivoPort = tipoBeneficioArchivoPort;
	}


	@Override
	public String buscarBeneficio(String tipoBeneficio) {
	   return tipoBeneficioArchivoPort.buscarBeneficio(tipoBeneficio);
	}

}
