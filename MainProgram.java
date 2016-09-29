package Store;

import javax.swing.UIManager;

public class MainProgram {

	 static void setLookAndFeel()
	{
		try
		{
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
		}
		catch (Exception e)
		{
			System.out.println(e.getMessage());
		}
	}// End of setLookAndFeel method
	public static void main(String[] args) {
		setLookAndFeel();
		ShoppingWindow win = new ShoppingWindow();

	}

}
