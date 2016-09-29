package Store;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Stack;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;




public class ConfirmWindow 
{





private JLabel lblProduct, lblColor, lblQuantity, lblPrice, 
				lblPurchaseTotal,lbSubtotal,lbHstAmount,lbShipping,lbTotal,lblast;

private  JTextField txSubtotal = new JTextField();
private JTextField txHstAmount = new JTextField();
private JTextField txShipping = new JTextField();
private JTextField txTotal = new JTextField();
private Purchase editpurchase;
protected static JFrame cwin;

private JButton btCheckout,bteditOrder,btcontinueShopping;

private static JList<String> lstOrder = new JList<String>();


	ConfirmWindow()
	{
	
			// Set the layout manager
			String subtotal = String.format("$%.2f",Global.subtotal);
			String Hst = String.format("$%.2f",Global.customer.calculateHst() );
			String total = String.format("$%.2f", Global.customer.calculateTotal());
			String shipping = String.format("$%.2f",Global.customer.calculateShipping());
			
			
		
			cwin = new JFrame("Confirm Purchase");
			cwin.setSize(530, 600);
			cwin.setLocationRelativeTo(null);
			cwin.getContentPane().setBackground(null);
			cwin.setResizable(false);
			
			//Initialize labels for the list box
			lblProduct = new JLabel("Product");
			lblColor = new JLabel("Color");
			lblQuantity = new JLabel("Quantity");
			lblPrice = new JLabel("Price");
			lblPurchaseTotal = new JLabel("Item Total");
			lbSubtotal = new JLabel("Subtotal:");
			lbHstAmount = new JLabel("HST Amount:");
			lbShipping = new JLabel("Shipping:");
			lbTotal = new JLabel("Total:");
			lblast = new JLabel("Select a Purchase to edit");
			txSubtotal = new JTextField(subtotal);
			txHstAmount = new JTextField(Hst);
			txShipping = new JTextField(shipping);
			txTotal = new JTextField(total);
			btCheckout = new JButton("Checkout");
			bteditOrder = new JButton("Edit Order");
			btcontinueShopping = new JButton("Continue Shopping");
			
			
			
			
			btcontinueShopping.addActionListener(new ActionListener()
				{	
					public void actionPerformed(ActionEvent e)
					{
						cwin.setVisible(false);
						ShoppingWindow.win.setVisible(true);
					}
				}
			);
			
			bteditOrder.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						cwin.setVisible(false);
						editpurchase = new Purchase();
						EditPurchaseWindow ep = new EditPurchaseWindow(lstOrder.getSelectedIndex(),editpurchase);
					}
				}		
			);
			
			
			
			btCheckout.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						cwin.setVisible(false);
						BillingWindow b = new BillingWindow();
		
					}
				}
			);
			
			
			
			
			displayOrder();
			
		
		
			
			lstOrder.setPreferredSize(new Dimension(500, 300));
			Font font = new Font(Font.MONOSPACED, Font.PLAIN, 12);
			lstOrder.setFont(font);
			lstOrder.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
			lstOrder.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			
			txSubtotal.setPreferredSize(new Dimension(110,25));
			txHstAmount.setPreferredSize(new Dimension(110,25));
			txShipping.setPreferredSize(new Dimension(110,25));
			txTotal.setPreferredSize(new Dimension(110,25));
			
			
			//Add all components to the frame
			cwin.add(lblProduct);
			cwin.add(lblColor);
			cwin.add(lblQuantity);
			cwin.add(lblPrice);
			cwin.add(lblPurchaseTotal);
			cwin.add(lbSubtotal);
			cwin.add(lbHstAmount);
			cwin.add(lbShipping);
			cwin.add(lbTotal);
			cwin.add(lstOrder);
			cwin.add(txSubtotal);
			cwin.add(txHstAmount);
			cwin.add(txShipping);
			cwin.add(txTotal);
			cwin.add(lblast);
			cwin.add(btCheckout);
			cwin.add(bteditOrder);
			cwin.add(btcontinueShopping);
			cwin.setLayout(ShoppingWindow.layout);
		
			//Set the west and north positions of all components
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lblProduct, 10, SpringLayout.WEST, cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lblProduct, 10, SpringLayout.NORTH, cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lblColor, 150, SpringLayout.WEST, cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lblColor, 10, SpringLayout.NORTH, cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lblQuantity, 250, SpringLayout.WEST, cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lblQuantity, 10, SpringLayout.NORTH, cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lblPrice, 350, SpringLayout.WEST, cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lblPrice, 10, SpringLayout.NORTH, cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lblPurchaseTotal, 440, SpringLayout.WEST, cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lblPurchaseTotal, 10, SpringLayout.NORTH,cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lstOrder, 10, SpringLayout.WEST, cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lstOrder, 30, SpringLayout.NORTH, cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lbSubtotal, 350, SpringLayout.WEST,cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lbSubtotal, 320, SpringLayout.WEST,cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lbHstAmount, 380, SpringLayout.WEST,cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lbHstAmount, 320, SpringLayout.WEST,cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lbShipping, 410, SpringLayout.WEST,cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lbShipping, 320, SpringLayout.WEST,cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lbTotal, 440, SpringLayout.WEST,cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lbTotal, 320, SpringLayout.WEST,cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, txSubtotal, 350, SpringLayout.WEST,cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, txSubtotal, 400, SpringLayout.WEST,cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, txHstAmount, 380, SpringLayout.WEST,cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, txHstAmount, 400, SpringLayout.WEST,cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, txShipping, 410, SpringLayout.WEST,cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, txShipping, 400, SpringLayout.WEST,cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, txTotal, 440, SpringLayout.WEST,cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, txTotal, 400, SpringLayout.WEST,cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lblast, 505, SpringLayout.WEST, cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lblast, 40, SpringLayout.WEST, cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, btCheckout, 500, SpringLayout.WEST, cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, btCheckout, 430, SpringLayout.WEST,cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, bteditOrder, 500, SpringLayout.WEST, cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, bteditOrder, 190, SpringLayout.WEST,cwin.getContentPane());
			
			ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, btcontinueShopping, 500, SpringLayout.WEST,cwin.getContentPane());
			ShoppingWindow.layout.putConstraint(SpringLayout.WEST, btcontinueShopping, 280, SpringLayout.WEST,cwin.getContentPane());
			
		
			cwin.setVisible(true);
	}

private static void displayOrder()
{
	String[] result = new String[Global.cart.size()];
	for(int i = 0; i < (Global.cart.size()) ; i++)
	{
		result[i] = (Global.cart.get(i).toString())+"\n";
	}
	lstOrder.setListData(result);	
}


}//End of class
