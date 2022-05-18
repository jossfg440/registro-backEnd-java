package ec.gob.como.archivo.operacion;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import java.io.Reader;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.util.ResourceUtils;

public class ManipulaJsonFile implements TipoBeneficioArchivo {

	@Override
	public String buscarBeneficio() {
		
		JSONParser parser = new JSONParser();
		String beneficio ;
		try {
		
			File json = ResourceUtils.getFile("classpath:sk_formato.json");
			Reader jsonReader = new FileReader(json);
			Object obj = parser.parse(jsonReader);
			JSONObject jsonObject = (JSONObject) obj;
			JSONArray skFormatoList = (JSONArray) jsonObject.get("sk_formato");
			
			
			if (skFormatoList.size() > 0 ) {
				//beneficio =  skFormatoList.get(0);
				JSONObject beneficioRecuperado = (JSONObject) skFormatoList.get(0);
				beneficio = (String) beneficioRecuperado.get("beneficio");
			    skFormatoList.remove(0);
			    jsonObject.put("sk_formato" , skFormatoList);
			    
			    try (
			    
			    	FileWriter file = new FileWriter("classpath:sk_formato.json")) {
		            file.write(jsonObject.toJSONString());
		            file.flush();
		            
		        } catch (IOException e) {
		            e.printStackTrace();
		        }
			    return beneficio;
			  
			} else {
				return "No existe beneficio";
			}
            
		} catch (FileNotFoundException e) {
		
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ParseException e) {
			
			e.printStackTrace();
		}
		
		return "";
	}

	

}
