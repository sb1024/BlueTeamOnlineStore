
public class Order {

	// variables
	private int orderNumber;
	private String firstName;
	private String surName;
	private String address;
	private String city;
	private String state;
	private int zip;
	private long phoneNum;
	private long ccNum;
	private int expDate;
	private double totalPrice;
	private ShoppingCart orderedItems;
	
	// constructor
	Order(int inputOrderNumber, String inputFirstName, String inputSurName, String inputAddress, String inputCity, String inputState, int inputZip, long inputPhoneNum, 
	long inputCcNum, int inputExpDate, double inputTotalPrice, ShoppingCart inputOrderedItems){
		orderNumber = inputOrderNumber;
		firstName = inputFirstName;
		surName = inputSurName;
		address = inputAddress;
		city = inputCity;
		state = inputState;
		zip = inputZip;
		phoneNum = inputPhoneNum;
		ccNum = inputCcNum;
		expDate = inputExpDate;
		totalPrice = inputTotalPrice;
		orderedItems = inputOrderedItems;
	}
	
	// get methods
	public int getOrderNumber(){
		return orderNumber;
	}
	public String getFirstName(){
		return firstName;
	}
	public String getSurName(){
		return surName;
	}
	public String getAddress(){
		return address;
	}
	public String getCity(){
		return city;
	}
	public String getState(){
		return state;
	}
	public int getZip(){
		return zip;
	}
	public long getPhoneNum(){
		return phoneNum;
	}
	public long getCcNum(){
		return ccNum;
	}
	public int getExpDate(){
		return expDate;
	}
	public double getTotalPrice(){
		return totalPrice;
	}
	public ShoppingCart getOrderedItems(){
		return orderedItems;
	}
	
	// set methods
	public void setOrderNumber(int inputOrderNumber){
		orderNumber = inputOrderNumber;
	}
	public void setFirstName(String inputFirstName){
		firstName = inputFirstName;
	}
	public void setSurName(String inputSurName){
		surName = inputSurName;
	}
	public void setAddress(String inputAddress){
		address = inputAddress;
	}
	public void setCity(String inputCity){
		city = inputCity;
	}
	public void setState(String inputState){
		state = inputState;
	}
	public void setZip(int inputZip){
		zip = inputZip;
	}
	public void setPhoneNum(long inputPhoneNum){
		phoneNum = inputPhoneNum;
	}
	public void setCcNum(long inputCcNum){
		ccNum = inputCcNum;
	}
	public void setExpDate(int inputExpDate){
		expDate = inputExpDate;
	}
	public void setTotalPrice(double inputTotalPrice){
		totalPrice = inputTotalPrice;
	}
	public void setOrderedItems(ShoppingCart inputOrderedItems){
		orderedItems = inputOrderedItems;
	}
}
