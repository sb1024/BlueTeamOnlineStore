import org.w3c.dom.*;
import javax.xml.parsers.*;
import javax.xml.transform.*;
import javax.xml.transform.dom.*;
import javax.xml.transform.stream.*;

import java.io.*;
import java.util.*;

public class XMLReaderWriter {
	
	public static void createStore(Store oStore){
		try{
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document doc = builder.newDocument();
			
			//store element
			Element store = doc.createElement("Store");
			doc.appendChild(store);
	        Attr storeName = doc.createAttribute("name");
	        storeName.setValue(oStore.getStoreName());
	        store.setAttributeNode(storeName);
	        Attr storeLogo = doc.createAttribute("logo");
	        storeLogo.setValue(oStore.getStoreLogo().getFilePath());
	        
	        //ArrayList <Element> EL = new ArrayList(5);
	        ArrayList <Department> DH = oStore.getDepartments();
	        for(int x=0; x < DH.size(); x++){
	        	Element department = doc.createElement("Department"); 
		        Attr departmentName = doc.createAttribute("name");
		        departmentName.setValue(DH.get(0).getName());
		        department.setAttributeNode(departmentName);
		        store.appendChild(department);
		        ArrayList <Product> PL = DH.get(x).getProductList();
		        
		        for(int y=0; y < PL.size(); y++){
		        	Element product = doc.createElement("product");
		        	Attr productName = doc.createAttribute("name");
		        	productName.setValue(PL.get(y).getName());
		        	product.setAttributeNode(productName);
		        	department.appendChild(product);
		        	
		        	Element price = doc.createElement("price");
		        	doc.createTextNode(Double.toString(PL.get(y).getPrice()));
		        	product.appendChild(price);
		        	
		        	Element desc = doc.createElement("description");
		        	doc.createTextNode(PL.get(y).getDesc());
		        	product.appendChild(price);
		        	
		        	Element sale = doc.createElement("sale");
		        	doc.createTextNode(Boolean.toString(PL.get(y).getSale()));
		        	product.appendChild(price);
		        	
		        	Element image = doc.createElement("image");
		        	doc.createTextNode(PL.get(y).getImage().getFilePath());
		        	product.appendChild(price);
		        }
	        }
	         
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
	
	public void saveStore(){
		
	}
	
	public void addOrder(){
		
	}
}
