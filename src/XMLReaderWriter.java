
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
	        try{
	        	storeLogo.appendChild(doc.createTextNode(oStore.getStoreLogo().getFilePath()));
	        }catch(Exception e){
	        	storeLogo.appendChild(doc.createTextNode("null"));
	        }
	        store.appendChild(storeLogo);
	        
	        Element storeDesc = doc.createElement("storeDescription");
	        storeDesc.appendChild(doc.createTextNode(oStore.getStoreDescription()));
	        store.appendChild(storeDesc);
	        
	        // department elements
	        ArrayList <Department> DL = oStore.getDepartments();
	        for(int x=0; x < DL.size(); x++){
	        	Element department = doc.createElement("department"); 
		        Attr departmentName = doc.createAttribute("name");
		        departmentName.setValue(DL.get(x).getName());
		        department.setAttributeNode(departmentName);
		        store.appendChild(department);
		        
		        Element depImage = doc.createElement("departmentImage");
		        try{
		        	depImage.appendChild(doc.createTextNode(DL.get(x).getImage().getFilePath()));
		        }catch(Exception e){
		        	depImage.appendChild(doc.createTextNode("null"));
		        }
		        department.appendChild(depImage);
		        
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
	        	orderNum.setValue(Long.toString(OL.get(x).getOrderNumber()));
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
		        		image.appendChild(doc.createTextNode("null"));
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
			
			String lTest = sE.getElementsByTagName("logo").item(0).getTextContent();
			if(!lTest.equals("null")){
				s.setStoreLogo(new ParsedImageIcon(lTest));
			}
		
			NodeList dList = doc.getElementsByTagName("department");
			// for loop defining each department in store
			for(int x=0; x < dList.getLength(); x++){
				Element dE = (Element) dList.item(x);
				Department d = new Department(dE.getAttribute("name"));
				
				lTest = dE.getChildNodes().item(0).getTextContent();
				if(!lTest.equals("null")){
					d.setImage(new ParsedImageIcon(lTest));
				}
			
				NodeList pList = dE.getChildNodes();
				
				// for loop defining each product in department
				for(int y=1; y < pList.getLength(); y++){
					Element pE = (Element) pList.item(y);
					
					double price = Double.parseDouble(pE.getChildNodes().item(0).getTextContent());
					
					String name = pE.getAttribute("name");
					
					String desc = pE.getChildNodes().item(1).getTextContent();
					
					boolean sale = Boolean.parseBoolean(pE.getChildNodes().item(2).getTextContent());
					
					Product p;
					
					lTest = pE.getChildNodes().item(3).getTextContent();
					if(!lTest.equals("null")){
						ParsedImageIcon image = new ParsedImageIcon(lTest);
						p = new Product(price, name, desc, sale, null, image);
					}else{
						p = new Product(price, name, desc, sale, null, null);
					}
					
					d.addProduct(p);
				}
				s.addDepartment(d);
			}
			
			NodeList oList = doc.getElementsByTagName("order");
			for(int x=0; x < oList.getLength(); x++){
				Element oE = (Element) oList.item(x);
				
				int orderNumber = Integer.parseInt(oE.getAttribute("orderNumber"));
				
				String firstName = oE.getChildNodes().item(0).getTextContent();
				
				String surName = oE.getChildNodes().item(1).getTextContent();
				
				String address = oE.getChildNodes().item(2).getTextContent();
				
				String city = oE.getChildNodes().item(3).getTextContent();
				
				String state = oE.getChildNodes().item(4).getTextContent();
				
				int zip = Integer.parseInt(oE.getChildNodes().item(5).getTextContent());
				
				long phoneNum = Long.parseLong(oE.getChildNodes().item(6).getTextContent());
				
				long ccNum = Long.parseLong(oE.getChildNodes().item(7).getTextContent());
				
				int expDate = Integer.parseInt(oE.getChildNodes().item(8).getTextContent());
				
				double totalPrice = Double.parseDouble(oE.getChildNodes().item(9).getTextContent());
				
				ArrayList <ProductOrder> pOAL = new ArrayList(0);
				NodeList oPList = oE.getChildNodes();
				for(int y=10; y < oList.getLength(); y++){
					Element oPE = (Element) oPList.item(y);
					//Starts at first product in order(10) and continues
					double price = Double.parseDouble(oPE.getChildNodes().item(1).getTextContent());
					String name = oPE.getAttribute("name");
					String desc = oPE.getChildNodes().item(2).getTextContent();
					boolean sale = Boolean.parseBoolean(oPE.getChildNodes().item(3).getTextContent());
					Product p;
					
					lTest = oPE.getChildNodes().item(4).getTextContent();
					if(!lTest.equals("null")){
						ParsedImageIcon image = new ParsedImageIcon(oPE.getChildNodes().item(4).getTextContent());
						p = new Product(price, name, desc, sale, null, image);
					}else{
						p = new Product(price, name, desc, sale, null, null);
					}
					int quantity = Integer.parseInt(oPE.getChildNodes().item(0).getTextContent());
					
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
}

/*KNOWN PROBLEMS:
 * XML ONLY UNDER ONE NAME
 * CANT CHANGE WHICH XML IS LOADED
 * CAN ONLY SAVE 1 STORE AT A TIME
 *  Idea to fix these:
 * 	- Find where the save / load buttons are
 * 	- add in a JFileChooser to save/ load different files
 * 
 * STUFF TO DO TMRW:
 *  -123 Expdate becomes a string
 */

