
import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import java.io.*;

public class XMLReaderWriter {
	
	public void createStore(Store store){
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			
			//root element
			Element rootElement = doc.createElement("Store");
			doc.appendChild(rootElement);

	         //Stores element
	         Element supercar = doc.createElement("Stores");
	         rootElement.appendChild(supercar);

	         // setting attribute to element
	         Attr attr = doc.createAttribute("name");
	         attr.setValue("Test");
	         supercar.setAttributeNode(attr);

	         //Department element
	         Element carname = doc.createElement("Department");
	         Attr attrType = doc.createAttribute("name");
	         attrType.setValue("Other Test");
	         carname.setAttributeNode(attrType);
	         carname.appendChild(
	         doc.createTextNode("Ferrari 101"));
	         supercar.appendChild(carname);

	         Element carname1 = doc.createElement("carname");
	         Attr attrType1 = doc.createAttribute("type");
	         attrType1.setValue("sports");
	         carname1.setAttributeNode(attrType1);
	         carname1.appendChild(
	         doc.createTextNode("Ferrari 202"));
	         supercar.appendChild(carname1);
	         
	         // write the content into xml file
	         TransformerFactory transformerFactory =
	         TransformerFactory.newInstance();
	         Transformer transformer =
	         transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result =
	         new StreamResult(new File("Z:\\cars.xml"));
	         transformer.transform(source, result);
	         // Output to console for testing
	         StreamResult consoleResult =
	         new StreamResult(System.out);
	         transformer.transform(source, consoleResult);
	         
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public void loadStore(){
		
	}
	
	public void saveStore(Store store){
		
	}
	
	public void addOrder(Order order){
		
	}
}
