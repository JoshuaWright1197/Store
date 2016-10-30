package Store;

import java.util.ArrayList;

public class Customer {
	
	private String firstName, lastName,Address , city , province, postalCode ,email , paymentMethod;
	private static double HST_RATE,SHIPPING_FEE;
	
	Customer()
	{
		firstName = "";
		lastName = "";
		Address = "";
		city = "";
		province = "";
		email = "";
		postalCode = "";
		paymentMethod = "";
		HST_RATE = 0.13;
		SHIPPING_FEE = 25.0;
		Global.subtotal = 0;
		Global.cart = new ArrayList<Purchase>();
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getProvince() {
		return province;
	}
	public void setProvince(String province) {
		this.province = province;
	}
	public String getPostalCode() {
		return postalCode;
	}
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPaymentMethod() {
		return paymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		this.paymentMethod = paymentMethod;
	}
	public static double getHST_RATE() {
		return HST_RATE;
	}
	public static void setHST_RATE(double hST_RATE) {
		HST_RATE = hST_RATE;
	}
	public static double getSHIPPING_FEE() {
		return SHIPPING_FEE;
	}
	public static void setSHIPPING_FEE(double sHIPPING_FEE) {
		SHIPPING_FEE = sHIPPING_FEE;
	}




	public void addToCart(String product,String Color,int Quantity,double Price)
	{
		Purchase purchase = new Purchase(product,Color,Quantity,Price);
		Global.cart.add(purchase);
		calculateSubtotal();
		
	}
	public void removeFromCart()
	{
		System.out.print(Global.cart.get(Global.cart.size()-1).toString());
		Global.cart.remove(Global.cart.size()-1);
		calculateSubtotal();
	}
	public void clearCart()
	{
		Global.cart.clear();
	}
	public void elditCart(int index , Purchase editedPurchase)
	{
		Global.cart.remove(index);
		Global.cart.add(index, editedPurchase);
	}
	public void calculateSubtotal()
	{
		Global.subtotal = 0;
		for(int i = 0; i < Global.cart.size();i++)
		{
			Global.subtotal += Global.cart.get(i).calculatePurchase();
		}
	}
	public double  calculateHst()
	{
		return  Global.subtotal *HST_RATE;
	}
	public double calculateShipping()
	{
		if(Global.subtotal <= 75)
		{
			return SHIPPING_FEE;
		}
		else if(Global.subtotal > 75 && Global.subtotal <= 200)
		{
			return SHIPPING_FEE*2;
		}
		else if(Global.subtotal > 200 && Global.subtotal <= 550)
		{
			return SHIPPING_FEE*3;
		}
		else
		{
			return SHIPPING_FEE *4;
		}
	}
	public double calculateTotal()
	{
		return calculateShipping() + Global.subtotal + calculateHst();
	}
	public String toString()
	{
		String Result = String.format("     *****Customer Invoice*****\n\n"
				+ "Name:  %s\n"
				+ "Address:  %s\n"
				+ "City:  %s\n"
				+ "Postal Code:  %s\n"
				+ "Email Address:  %s\n\n"
				+ "Subtotal:  $%.2f\n"
				+ "HST Amount:  $%.2f\n"
				+ "Shipping:  $%.2f\n"
				+ "Total:  $%.2f\n\n"
				+ "     Thank you for your order.\n"
				+ "     An invoice will be sent to your email!\n",(firstName+" "+lastName),Address,(city+" "+province)
				,postalCode,email,Global.subtotal,calculateHst(),calculateShipping(),calculateTotal() );
		
		return Result;
	}
	
	
	
}
