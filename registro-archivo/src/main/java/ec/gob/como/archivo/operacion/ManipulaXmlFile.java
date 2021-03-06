package ec.gob.como.archivo.operacion;


import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.springframework.util.ResourceUtils;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class ManipulaXmlFile implements TipoBeneficioArchivo{

	@Override
	public String buscarBeneficio() {
		String beneficio="" ;
		try {
		  File xmlFile = ResourceUtils.getFile("classpath:th_formato.xml");
		  DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
		  Document doc = builder.parse(xmlFile);
		  doc.getDocumentElement().normalize();
		  
		
		  Node beneficiosNode = doc.getElementsByTagName("beneficios").item(0);
		  NodeList list2 = beneficiosNode.getChildNodes();
		  for (int i = 0; i < list2.getLength(); i++) {
	           Node node = list2.item(i);
	           
	           //Remove "name" node
	            if ("beneficio".equals(node.getNodeName())) {
	               beneficio = node.getTextContent();
	        	   beneficiosNode.removeChild(node);
	        	   i = list2.getLength();
	        	   saveXMLContent(doc,xmlFile);
	            }  
	       }
		  
		  if (beneficio != "") {
			  return beneficio;
		  } else {
			  return "No existe beneficio";
		  }
		 
		  

		
		} catch (IOException | ParserConfigurationException | SAXException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	private static void saveXMLContent(Document document, File xmlFile) {
		try {
			TransformerFactory transformerFactory = TransformerFactory.newInstance();
			Transformer transformer = transformerFactory.newTransformer();
			transformer.setOutputProperty(OutputKeys.INDENT, "yes");
			DOMSource domSource = new DOMSource(document);
			StreamResult streamResult = new StreamResult(xmlFile);
			transformer.transform(domSource, streamResult);
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
		}
	}

}
