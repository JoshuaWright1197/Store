package Store;

public class Purchase {
	private String Product;
	private String Color;
	private int Quantity;
	private double Price;
	
	Purchase()
	{
		Product = "";
		Color = "";
		Quantity = 0;
		Price = 0.0;;
	}

	Purchase(String product,String color,int quantity,double price)
	{
		Product = product;
		Color = color;
		Quantity = quantity;
		Price= price;
	}
	
	
	
	public String getProduct() {
		return Product;
	}

	public void setProduct(String product) {
		Product = product;
	}

	public String getColor() {
		return Color;
	}

	public void setColor(String color) {
		Color = color;
	}

	public int getQuantity() {
		return Quantity;
	}

	public void setQuantity(int quantity) {
		Quantity = quantity;
	}

	public double getPrice() {
		return Price;
	}

	public void setPrice(double price) {
		Price = price;
	}

	
	
	public double calculatePurchase()
	{
		return Quantity*Price;
	}
	
	@Override
	public String toString()
	{
		String result = String.format( "%-18s "
				+ "%-16s "
				+ "%-10d "
				+ "%-13.2f "
				+ "%.2f",Product,Color,Quantity,Price ,calculatePurchase());
		return result;
	}
	
	
	
	
	
	
}
