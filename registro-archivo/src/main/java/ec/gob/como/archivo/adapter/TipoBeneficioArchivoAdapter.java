package ec.gob.como.archivo.adapter;

import org.springframework.stereotype.Service;

import ec.gob.como.archivo.operacion.ManipulaJsonFile;
import ec.gob.como.archivo.operacion.ManipulaXmlFile;

import ec.gob.como.domain.port.TipoBeneficioArchivoPort;

@Service
public class TipoBeneficioArchivoAdapter implements TipoBeneficioArchivoPort{

	
	private ManipulaJsonFile manipulaJsonFile;
	private ManipulaXmlFile manipulaXmlFile;
	
	public  TipoBeneficioArchivoAdapter() {
		
	}
	
	public  TipoBeneficioArchivoAdapter(ManipulaJsonFile manipulaJsonFile,ManipulaXmlFile manipulaXmlFile) {
		
		this.manipulaJsonFile = manipulaJsonFile;
		this.manipulaXmlFile = manipulaXmlFile;
		
	}
	
    public TipoBeneficioArchivoAdapter(ManipulaJsonFile manipulaJsonFile) {
		
		this.manipulaJsonFile = manipulaJsonFile;
		
		
	}
    
   public TipoBeneficioArchivoAdapter(ManipulaXmlFile manipulaXmlFile) {
		
		this.manipulaXmlFile = manipulaXmlFile;
		
	}
	

	@Override
	public String buscarBeneficio(String tipoBeneficio) {
		if (tipoBeneficio.endsWith("SK")) {
			ManipulaJsonFile fila = new ManipulaJsonFile();
			return fila.buscarBeneficio();
		} else {
			ManipulaXmlFile fila = new ManipulaXmlFile();
			return fila.buscarBeneficio();
		}
	
	}

}
