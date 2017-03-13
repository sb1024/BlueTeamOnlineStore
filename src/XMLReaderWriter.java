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
			
			// store element
			Element store = doc.createElement("Store");
			doc.appendChild(store);
	        Attr storeName = doc.createAttribute("name");
	        storeName.setValue(oStore.getStoreName());
	        store.setAttributeNode(storeName);
	        Attr storeLogo = doc.createAttribute("logo");
	        storeLogo.setValue(oStore.getStoreLogo().getFilePath());
	        
	        // department elements
	        ArrayList <Department> DH = oStore.getDepartments();
	        for(int x=0; x < DH.size(); x++){
	        	Element department = doc.createElement("Department"); 
		        Attr departmentName = doc.createAttribute("name");
		        departmentName.setValue(DH.get(0).getName());
		        department.setAttributeNode(departmentName);
		        store.appendChild(department);
		        ArrayList <Product> PL = DH.get(x).getProductList();
		        
		        // product elements in department
		        for(int y=0; y < PL.size(); y++){
		        	Element product = doc.createElement("Product");
		        	Attr productName = doc.createAttribute("name");
		        	productName.setValue(PL.get(y).getName());
		        	product.setAttributeNode(productName);
		        	department.appendChild(product);
		        	
		        	// elements in product
		        	Element price = doc.createElement("price");
		        	price.appendChild(doc.createTextNode(Double.toString(PL.get(y).getPrice())));
		        	product.appendChild(price);
		        	
		        	Element desc = doc.createElement("description");
		        	desc.appendChild(doc.createTextNode(PL.get(y).getDesc()));
		        	product.appendChild(desc);
		        	
		        	Element sale = doc.createElement("sale");
		        	sale.appendChild(doc.createTextNode(Boolean.toString(PL.get(y).getSale())));
		        	product.appendChild(sale);
		        	
		        	//Element image = doc.createElement("image");
		        	//sale.appendChild(doc.createTextNode(PL.get(y).getImage().getFilePath()));
		        	//product.appendChild(image);
		        }
	        }
	        
	        // order element
	        Element order = doc.createElement("order");
	        
	         
	         // write the content into xml file
	         TransformerFactory transformerFactory =
	         TransformerFactory.newInstance();
	         Transformer transformer =
	         transformerFactory.newTransformer();
	         DOMSource source = new DOMSource(doc);
	         StreamResult result =
	         new StreamResult(new File("Z:\\Store.xml"));
	         transformer.transform(source, result);
	         // Output to console for testing
	         /*StreamResult consoleResult =
	         new StreamResult(System.out);
	         transformer.transform(source, consoleResult);*/
	         
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	public static Store loadStore(){
		try{
			File inputFile = new File("Z:\\Store.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
		
			Store s = new Store();
		
			NodeList dList = doc.getElementsByTagName("Department");
			for(int x=0; x < dList.getLength(); x++){
				Element dE = (Element) dList.item(x);
				Department d = new Department(dE.getAttribute("name"));
			
				NodeList pList = doc.getElementsByTagName("Product");
				for(int y=0; y < pList.getLength(); y++){
					Element pE = (Element) pList.item(y);
					double price = Double.parseDouble(pE.getElementsByTagName("price").item(0).getTextContent());
					String name = pE.getAttribute("name");
					String desc = pE.getElementsByTagName("desc").item(0).getTextContent();
					boolean sale = Boolean.parseBoolean(pE.getElementsByTagName("sale").item(0).getTextContent());
					ParsedImageIcon image = new ParsedImageIcon(pE.getElementsByTagName("image").item(0).getTextContent());
					Product p = new Product(price, name, desc, sale, null, image);
					d.addProduct(p);
				}
				s.addDepartment(d);
				System.out.println(d.getName());
			}
		
			return(s);
		}catch(Exception e){
			return(null);
		}
	}
	
	public void saveStore(Store oStore){
		// very basic version, will update later
		createStore(oStore);
	}
	
	public void addOrder(){
		
	}
	
	public static void main(String[] args){
		createStore(createStore());
		Store testStore = loadStore();
		//System.out.println(testStore.getDepartments().get(0).getName());
		/*System.out.println(testStore.getStoreDescription());
		System.out.println(testStore.getStoreName());
		System.out.println(testStore.getStoreLogo());
		
		ArrayList <Department> arris = testStore.getDepartments();
		for(int x=0; x<arris.size(); x++){
			Department Partment = arris.get(x);
			System.out.println(Partment.getName());
			System.out.println(Partment.getImage());
			ArrayList <Product> ducts = Partment.getProductList();
			for(int y=0; y<ducts.size();y++){
				Product pro = ducts.get(y);
				System.out.println(pro.getName());
				System.out.println(pro.getDesc());
				System.out.println(pro.getSale());
				System.out.println(pro.getPrice());
			}
		}*/
	}
	
	public static Store createStore(){
		String storeName = "Generic Store";
		ParsedImageIcon storeLogo = new ParsedImageIcon("logo.png", 256, 256);
		String storeDescription = "A generic store. All values should be changed";
		
		
		ArrayList<Department> departments = new ArrayList();
		Department genericDepartment = new Department("Electronics");
		ParsedImageIcon departmentLogo = new ParsedImageIcon("departmentLogo.png", 300, 300);
		genericDepartment.setImage(departmentLogo);
		Product genericProduct = new Product(10.0, "Phone", "A lovely new phone", false, genericDepartment, null);
		genericDepartment.addProduct(genericProduct);
		
		departments.add(genericDepartment);
		
		ArrayList<Order> orders = new ArrayList();
		
		return new Store(storeName, storeDescription, departments, orders, storeLogo);


	}
	
}

/*KNOWN PROBLEMS:
 * XML DOES NOT SAVE THE DEPARTMENT IMAGE
 * 		-THERE IS NO IMAGE IN CONSTRUCTORS
 * XML DOES NOT SAVE ORDERS
 * XML DOES NOT SAVE IMAGE WIDTH / HEIGHT
 *
 */
