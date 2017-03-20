
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
			Element store = doc.createElement("store");
			doc.appendChild(store);
			
	        Attr storeName = doc.createAttribute("name");
	        storeName.setValue(oStore.getStoreName());
	        store.setAttributeNode(storeName);
	        
	        Element storeLogo = doc.createElement("logo");
	        storeLogo.appendChild(doc.createTextNode(oStore.getStoreLogo().getFilePath()));
	        store.appendChild(storeLogo);
	        
	        Element storeDesc = doc.createElement("storeDescription");
	        storeDesc.appendChild(doc.createTextNode(oStore.getStoreDescription()));
	        store.appendChild(storeDesc);
	        
	        // department elements
	        ArrayList <Department> DL = oStore.getDepartments();
	        for(int x=0; x < DL.size(); x++){
	        	Element department = doc.createElement("department"); 
		        Attr departmentName = doc.createAttribute("name");
		        departmentName.setValue(DL.get(0).getName());
		        department.setAttributeNode(departmentName);
		        store.appendChild(department);
		        
		        ArrayList <Product> PL = DL.get(x).getProductList();
		        
		        // product elements in department
		        for(int y=0; y < PL.size(); y++){
		        	Element product = doc.createElement("product");
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
		        	
		        	Element image = doc.createElement("image");
		        	try{
		        		image.appendChild(doc.createTextNode(PL.get(y).getImage().getFilePath()));
		        	}catch(Exception e){
		        		image.appendChild(doc.createTextNode("noImage.jpg"));
		        	}
		        	product.appendChild(image);
		        }
	        }
	        
	        // order element
	        ArrayList <Order> OL = oStore.getOrders();
	        for(int x=0; x < OL.size(); x++){
	        	Element order = doc.createElement("order");
	        	Attr orderNum = doc.createAttribute("orderNumber");
	        	orderNum.setValue(Integer.toString(OL.get(x).getOrderNumber()));
	        	order.setAttributeNode(orderNum);
	        	store.appendChild(order);
	        	
	        	Element firstName = doc.createElement("firstName");
	        	firstName.appendChild(doc.createTextNode(OL.get(x).getFirstName()));
	        	order.appendChild(firstName);
	        	
	        	Element surName = doc.createElement("surName");
	        	surName.appendChild(doc.createTextNode(OL.get(x).getSurName()));
	        	order.appendChild(surName);
	        	
	        	Element address = doc.createElement("address");
	        	address.appendChild(doc.createTextNode(OL.get(x).getAddress()));
	        	order.appendChild(address);
	        	
	        	Element city = doc.createElement("city");
	        	city.appendChild(doc.createTextNode(OL.get(x).getCity()));
	        	order.appendChild(city);
	        	
	        	Element state = doc.createElement("state");
	        	state.appendChild(doc.createTextNode(OL.get(x).getState()));
	        	order.appendChild(state);
	        	
	        	Element zip = doc.createElement("zipCode");
	        	zip.appendChild(doc.createTextNode(Integer.toString(OL.get(x).getZip())));
	        	order.appendChild(zip);
	        	
	        	Element phone = doc.createElement("phoneNumber");
	        	phone.appendChild(doc.createTextNode(Long.toString((OL.get(x).getPhoneNum()))));
	        	order.appendChild(phone);
	        	
	        	Element ccNum = doc.createElement("creditCardNumber");
	        	ccNum.appendChild(doc.createTextNode(Long.toString((OL.get(x).getCcNum()))));
	        	order.appendChild(ccNum);
	        	
	        	Element expDate = doc.createElement("expirationDate");
	        	expDate.appendChild(doc.createTextNode(Integer.toString(OL.get(x).getExpDate())));
	        	order.appendChild(expDate);
	        	
	        	Element total = doc.createElement("totalPrice");
	        	total.appendChild(doc.createTextNode(Double.toString(OL.get(x).getTotalPrice())));
	        	order.appendChild(total);
	        	
	        	ArrayList <ProductOrder> POL = OL.get(x).getOrderedItems().getProductOrders();
	        	for(int y=0; y < POL.size(); y++){
	        		
	        		Product p = POL.get(y).getProduct();
	        		
		        	Element product = doc.createElement("oProduct");
		        	Attr productName = doc.createAttribute("name");
		        	productName.setValue(p.getName());
		        	product.setAttributeNode(productName);
		        	order.appendChild(product);
		        	
		        	// elements in product
		        	Element quantity = doc.createElement("quantity");
		        	quantity.appendChild(doc.createTextNode(Integer.toString(POL.get(y).getQuantity())));
		        	product.appendChild(quantity);
		        	
		        	Element price = doc.createElement("price");
		        	price.appendChild(doc.createTextNode(Double.toString(p.getPrice())));
		        	product.appendChild(price);
		        	
		        	Element desc = doc.createElement("description");
		        	desc.appendChild(doc.createTextNode(p.getDesc()));
		        	product.appendChild(desc);
		        	
		        	Element sale = doc.createElement("sale");
		        	sale.appendChild(doc.createTextNode(Boolean.toString(p.getSale())));
		        	product.appendChild(sale);
		        	
		        	Element image = doc.createElement("image");
		        	try{
		        		image.appendChild(doc.createTextNode(p.getImage().getFilePath()));
		        	}catch(Exception e){
		        		image.appendChild(doc.createTextNode("noImage.jpg"));
		        	}
		        	product.appendChild(image);
		        	
		        	
	        	}
	        }
	         
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
			// loads file title Store.xml, parses information into store
			File inputFile = new File("Z:\\Store.xml");
			DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
			Document doc = dBuilder.parse(inputFile);
			doc.getDocumentElement().normalize();
			
			NodeList sList = doc.getElementsByTagName("store");
			Element sE = (Element) sList.item(0);
			Store s = new Store();
			s.setStoreName(sE.getAttribute("name"));
			s.setStoreDescription(sE.getElementsByTagName("storeDescription").item(0).getTextContent());
			s.setStoreLogo(new ParsedImageIcon(sE.getElementsByTagName("logo").item(0).getTextContent()));
		
			NodeList dList = doc.getElementsByTagName("department");
			// for loop defining each department in store
			for(int x=0; x < dList.getLength(); x++){
				Element dE = (Element) dList.item(x);
				Department d = new Department(dE.getAttribute("name"));
			
				NodeList pList = doc.getElementsByTagName("product");
				// for loop defining each product in department
				for(int y=0; y < pList.getLength(); y++){
					Element pE = (Element) pList.item(y);
					
					double price = Double.parseDouble(pE.getElementsByTagName("price").item(0).getTextContent());
					
					String name = pE.getAttribute("name");
					
					String desc = pE.getElementsByTagName("description").item(0).getTextContent();
					
					boolean sale = Boolean.parseBoolean(pE.getElementsByTagName("sale").item(0).getTextContent());
					
					ParsedImageIcon image = new ParsedImageIcon(pE.getElementsByTagName("image").item(0).getTextContent());
					
					Product p = new Product(price, name, desc, sale, null, image);
					
					d.addProduct(p);
				}
				s.addDepartment(d);
			}
			
			NodeList oList = doc.getElementsByTagName("order");
			for(int x=0; x < oList.getLength(); x++){
				Element oE = (Element) oList.item(x);
				
				int orderNumber = Integer.parseInt(oE.getAttribute("orderNumber"));
				
				String firstName = oE.getElementsByTagName("firstName").item(0).getTextContent();
				
				String surName = oE.getElementsByTagName("surName").item(0).getTextContent();
				
				String address = oE.getElementsByTagName("address").item(0).getTextContent();
				
				String city = oE.getElementsByTagName("city").item(0).getTextContent();
				
				String state = oE.getElementsByTagName("state").item(0).getTextContent();
				
				int zip = Integer.parseInt(oE.getElementsByTagName("zipCode").item(0).getTextContent());
				
				long phoneNum = Long.parseLong(oE.getElementsByTagName("phoneNumber").item(0).getTextContent());
				
				long ccNum = Long.parseLong(oE.getElementsByTagName("creditCardNumber").item(0).getTextContent());
				
				int expDate = Integer.parseInt(oE.getElementsByTagName("expirationDate").item(0).getTextContent());
				
				double totalPrice = Double.parseDouble(oE.getElementsByTagName("totalPrice").item(0).getTextContent());
				
				ArrayList <ProductOrder> pOAL = new ArrayList(0);
				NodeList oPList = doc.getElementsByTagName("oProduct");
				for(int y=0; y < oList.getLength(); y++){
					Element oPE = (Element) oPList.item(y);
					
					double price = Double.parseDouble(oPE.getElementsByTagName("price").item(0).getTextContent());
					String name = oPE.getAttribute("name");
					String desc = oPE.getElementsByTagName("description").item(0).getTextContent();
					boolean sale = Boolean.parseBoolean(oPE.getElementsByTagName("sale").item(0).getTextContent());
					ParsedImageIcon image = new ParsedImageIcon(oPE.getElementsByTagName("image").item(0).getTextContent());
					Product p = new Product(price, name, desc, sale, null, image);
					
					int quantity = Integer.parseInt(oPE.getElementsByTagName("quantity").item(0).getTextContent());
					
					ProductOrder pO = new ProductOrder(p,quantity);
					pOAL.add(pO);
				}
				
				ShoppingCart SC = new ShoppingCart(pOAL);
				Order o = new Order(orderNumber, firstName, surName, address, city, state, zip, phoneNum, ccNum, expDate, totalPrice, SC);
				s.addOrder(o);
			}
		
			return(s);
		}catch(Exception e){
			e.printStackTrace();
			return(null);
		}
	}
	
	public void saveStore(Store oStore){
		// rewrites store of same name
		createStore(oStore);
	}
	
	public static void main(String[] args){
		createStore(createStore());
		Store testStore = loadStore();
		ArrayList<Order> o = testStore.getOrders();
		System.out.println(o.get(0).getAddress());
		System.out.println(o.get(0).getCcNum());
		System.out.println(o.get(0).getCity());
		System.out.println(o.get(0).getExpDate());
		System.out.println(o.get(0).getFirstName());
		System.out.println(o.get(0).getSurName());
		System.out.println(o.get(0).getOrderNumber());
		System.out.println(o.get(0).getPhoneNum());
		System.out.println(o.get(0).getState());
		System.out.println(o.get(0).getTotalPrice());
		System.out.println(o.get(0).getZip());


		/*System.out.println(testStore.getStoreName());
		System.out.println(testStore.getStoreDescription());
		System.out.println(testStore.getStoreLogo().getFilePath());
		System.out.println(testStore.getDepartments().get(0).getProductList().get(0).getName());
		System.out.println(testStore.getDepartments().get(0).getName());
		System.out.println(testStore.getStoreDescription());
		System.out.println(testStore.getStoreName());
		System.out.println(testStore.getStoreLogo().getFilePath());
		
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
		ShoppingCart cart = new ShoppingCart();
		cart.addProductOrder(genericProduct, 2);
		Long l1 = Long.valueOf("4436903231");
		Long l2 = Long.valueOf("11111111111");
		orders.add(new Order(102, "John", "Doe", "4520 Lain Lane", "Some City", "New York", 51034, l1, l2, 2233, 20.0, cart));
		return new Store(storeName, storeDescription, departments, orders, storeLogo);


	}
	
}

/*KNOWN PROBLEMS:
 * XML DOES NOT SAVE THE DEPARTMENT IMAGE
 * XML DOES NOT SAVE IMAGE WIDTH / HEIGHT
 * 
 * 
 */

