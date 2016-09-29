package Store;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SpringLayout;



public class EditPurchaseWindow {

	
	 
	private JLabel Product,Color,Quantity,Price;
	private JButton btdone;
	private JTextField txproduct,txprice;
	private Purchase EditedPurchase;
	private int i;
	private JComboBox<String> colorbox;
	private JComboBox<Integer>quantitybox;
	private JFrame ewin;
	
	
	EditPurchaseWindow( int  I,Purchase editedPurchase)
	{
		
		ewin = new JFrame("Edit Purchase");
		ewin.setSize(300, 250);
		ewin.getContentPane().setBackground(java.awt.Color.WHITE);
		ewin.setResizable(false);
		ewin.setLocationRelativeTo(null);
		
		
		EditedPurchase = new Purchase();
		EditedPurchase = editedPurchase;
		i = I;
		
		
		
		
		
		Product = new JLabel("Procduct");
		Color = new JLabel("Color");
		Quantity = new JLabel("Quantity");
		Price = new JLabel("Price");
		txproduct = new JTextField(Global.cart.get(i).getProduct());
		txprice = new JTextField("$"+Global.cart.get(i).getPrice());
		btdone = new JButton("Done");
		quantitybox = new JComboBox<Integer>(ShoppingWindow.quantity);
		
		
		btdone.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					EditedPurchase.setColor((String)colorbox.getSelectedItem());
					EditedPurchase.setQuantity((Integer)quantitybox.getSelectedItem());
					EditedPurchase.setProduct(Global.cart.get(i).getProduct());
					EditedPurchase.setPrice(Global.cart.get(i).getPrice());
					Global.customer.elditCart(i, EditedPurchase);
					ewin.setVisible(false);
					ConfirmWindow newone  = new ConfirmWindow();
				}
			}
		);
		
		
		txprice.setEditable(false);
		txproduct.setEditable(false);
		
		
		if(Global.cart.get(i).getProduct().equals("Chair"))
		{
			colorbox = new JComboBox<String>(ShoppingWindow.chairColors);
		}
		else if(Global.cart.get(i).getProduct().equals("Desk"))
		{
			colorbox = new JComboBox<String>(ShoppingWindow.deskColors);
		}
		else if(Global.cart.get(i).getProduct().equals("Dresser"))
		{
			colorbox = new JComboBox<String>(ShoppingWindow.dresserColors);
		}
		else if(Global.cart.get(i).getProduct().equals("Office Chair"))
		{
			colorbox = new JComboBox<String>(ShoppingWindow.officeChairColors);
		}
		else
		{
			colorbox = new JComboBox<String>(ShoppingWindow.bedFrameColors);
		}
		
		
		
		
		Font font = new Font(Font.DIALOG, Font.PLAIN, 16);
		
		Product.setFont(font);
		Color.setFont(font);
		Quantity.setFont(font);
		Price.setFont(font);
		
		ewin.add(colorbox);	
		ewin.add(quantitybox);
		ewin.add(btdone);
		ewin.add(txproduct);
		ewin.add(txprice);
		ewin.add(Product);
		ewin.add(Color);
		ewin.add(Quantity);
		ewin.add(Price);
		ewin.setLayout(ShoppingWindow.layout);
		
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, Product, 20, SpringLayout.NORTH,ewin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, Product, 20, SpringLayout.WEST,ewin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, txproduct, 20, SpringLayout.NORTH,ewin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, txproduct, 100, SpringLayout.WEST,ewin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, Color, 70, SpringLayout.NORTH,ewin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, Color, 20, SpringLayout.WEST,ewin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, colorbox, 70, SpringLayout.NORTH,ewin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, colorbox, 100, SpringLayout.WEST,ewin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, Quantity, 120, SpringLayout.NORTH,ewin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, Quantity, 20, SpringLayout.WEST,ewin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, quantitybox, 120, SpringLayout.NORTH,ewin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, quantitybox, 100, SpringLayout.WEST,ewin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, Price, 170, SpringLayout.NORTH,ewin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, Price, 20, SpringLayout.WEST,ewin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, txprice, 170, SpringLayout.NORTH,ewin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, txprice, 100, SpringLayout.WEST,ewin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, btdone, 170, SpringLayout.NORTH,ewin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, btdone, 200, SpringLayout.WEST,ewin.getContentPane());
		
		
		ewin.setVisible(true);	
		
		
	}
	
	
	
	
}
