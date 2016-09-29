package Store;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComboBox.KeySelectionManager;



import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpringLayout;
import javax.swing.UIManager;



public class ShoppingWindow
{
	


	// Declare instance fields, references to GUI objects
	private JLabel lbChair, lbOfficeChair, lbdesk, lbbedFrame , lbdresser;
	protected static Integer [] quantity = {1,2,3,4,5} ;
	protected static String[] chairColors = {"Brown","Black","White"};
	protected static String[] officeChairColors = {"Black"};
	protected static String[] deskColors = {"Black","White","Red","Blue"};
	protected static String[] bedFrameColors = {"Black","White"};
	protected static String[] dresserColors = {"Brown","Black","White"};
	private JMenuBar menuebar;
	
	private JMenuItem exitItem,howtouseitem,shippingitem,rPolicyitem,abouttem,editcart,clearcart;
	private JMenu Fliemenu,editmenu,helpmenu;
	private buildbottompanel bottompanel = new buildbottompanel();;
	protected static JFrame win = new JFrame("Welcome to the iDeal Store Online Shopping System");
	protected static SpringLayout layout = new SpringLayout();
	
	public ShoppingWindow()
	{
	
		Global.customer = new Customer();
		win.setLayout(layout);
		win.getContentPane().setBackground(Color.WHITE);
		win.setSize(1077, 540);
		win.setResizable(false);
		win.setLocationRelativeTo(null);
		win.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		//Initialize labels for the list box
		lbChair = new JLabel("Chair");
		lbOfficeChair = new JLabel("Office Chair");
		lbdesk = new JLabel("Desk");
		lbbedFrame = new JLabel("Bed Frame");
		lbdresser = new JLabel("Dresser");
		
	
		
		win.add(lbChair);
		win.add(lbOfficeChair);
		win.add(lbdesk);
		win.add(lbbedFrame);
		win.add(lbdresser);
		
		buildchaepChairPanel panelchair = new buildchaepChairPanel();
		buildBedFramePanel panelbedframe = new buildBedFramePanel();
		buildDresserpanel paneldresser = new buildDresserpanel();
		buildtablepanel paneltable = new buildtablepanel();
		buildofficechairpanel paneloffciechair = new buildofficechairpanel();
		win.add(paneloffciechair);
		win.add(paneltable);
		win.add(paneldresser);
		win.add(panelbedframe);
		win.add(panelchair);
		
		
		
		
		win.add(bottompanel);
		
		buildmenue menue = new buildmenue();
		
		layout.putConstraint(SpringLayout.WEST, lbChair, 10, SpringLayout.WEST, win.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lbChair, 10, SpringLayout.NORTH, win.getContentPane());
		
		layout.putConstraint(SpringLayout.WEST, lbbedFrame, 220, SpringLayout.WEST, win.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lbbedFrame, 10, SpringLayout.NORTH, win.getContentPane());
		
		layout.putConstraint(SpringLayout.WEST, lbdresser, 440, SpringLayout.WEST, win.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lbdresser, 10, SpringLayout.NORTH, win.getContentPane());
		
		layout.putConstraint(SpringLayout.WEST, lbdesk, 655, SpringLayout.WEST, win.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lbdesk, 10, SpringLayout.NORTH, win.getContentPane());
		
		layout.putConstraint(SpringLayout.WEST, lbOfficeChair, 865, SpringLayout.WEST, win.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, lbOfficeChair, 10, SpringLayout.NORTH, win.getContentPane());
	
		layout.putConstraint(SpringLayout.NORTH, panelchair, 30, SpringLayout.WEST,win.getContentPane());
		layout.putConstraint(SpringLayout.WEST, panelchair, 1, SpringLayout.WEST,win.getContentPane());
		
		layout.putConstraint(SpringLayout.NORTH, panelbedframe, 30, SpringLayout.WEST,win.getContentPane());
		layout.putConstraint(SpringLayout.WEST, panelbedframe, 215, SpringLayout.WEST,win.getContentPane());
		
		layout.putConstraint(SpringLayout.NORTH, paneldresser, 30, SpringLayout.WEST,win.getContentPane());
		layout.putConstraint(SpringLayout.WEST, paneldresser, 430, SpringLayout.WEST,win.getContentPane());
		
		layout.putConstraint(SpringLayout.WEST, paneltable, 645, SpringLayout.WEST, win.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, paneltable, 30, SpringLayout.NORTH, win.getContentPane());
		
		layout.putConstraint(SpringLayout.WEST, paneloffciechair, 860, SpringLayout.WEST, win.getContentPane());
		layout.putConstraint(SpringLayout.NORTH, paneloffciechair, 30, SpringLayout.NORTH, win.getContentPane());
		
		layout.putConstraint(SpringLayout.NORTH, bottompanel, 430, SpringLayout.WEST,win.getContentPane());
		
		// Set up methods for the frame
		
		win.setVisible(true);
		
		
	}
	

	
	private class buildmenue
	{
		buildmenue()
		{
			menuebar = new JMenuBar();
			buildFilemenue();
			buildEditmenue();
			buildHelpmenue();
			
			menuebar.add(Fliemenu);
			menuebar.add(editmenu);
			menuebar.add(helpmenu);
			
			
			win.setJMenuBar(menuebar);
		}
		
		private void buildFilemenue()
		{
			Fliemenu = new JMenu("Flie");
			exitItem = new JMenuItem("Exit");
			
			exitItem.addActionListener(new ActionListener()		
				{
					public void actionPerformed(ActionEvent e) 
					{
						System.exit(1);
					}
				}
			);
			
			Fliemenu.add(exitItem);
			
		}	
		private void buildEditmenue()
		{
			editmenu = new JMenu("Edit");
			editcart = new JMenuItem("Edit Cart");
			clearcart = new JMenuItem("Clear Cart");
			
			clearcart.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e)
					{
						Global.cart.clear();
						Global.customer.calculateSubtotal();
						bottompanel.txSubtotal.setText("$"+Global.subtotal);
					}
				}			
			);
			
			editcart.addActionListener(new ActionListener()	
				{
					public void actionPerformed(ActionEvent e) 
					{
						ConfirmWindow conwin = new ConfirmWindow();
						win.setVisible(false);
					}
				}
			);
			
			editmenu.add(editcart);
			editmenu.add(clearcart);
			
			
		}
		private void buildHelpmenue()
		{
			helpmenu = new JMenu("Flie");
			howtouseitem = new JMenuItem("How To use");
			shippingitem = new JMenuItem("Shipping");
			rPolicyitem = new JMenuItem("Return Policy");
			abouttem = new JMenuItem("About");
			
			helpmenu.add(howtouseitem);
			helpmenu.add(shippingitem);
			helpmenu.add(rPolicyitem);
			helpmenu.add(abouttem);
		}
	
	}
	
	
	private class buildchaepChairPanel extends JPanel
	{
		
		private JButton btddcart,btremove,btmore;
		private JTextArea description;
		private JComboBox colorbox = new JComboBox(chairColors);
		private	JComboBox<Integer>Quantitybox = new JComboBox<>(quantity);
		private ImageIcon chaepchairimgae;
		private JLabel imglabel;
		private BufferedImage image;
		private JPanel sub1 ,sub2;
			
		buildchaepChairPanel()
		{		
			btddcart = new JButton("Add To Cart");
			btremove = new JButton("Remove");
			btmore = new JButton("More...");
			description = new JTextArea(5,17);
			description.setText("Desciprtion goes here");
			description.setEditable(false);
			sub1 = new JPanel();
			sub2 = new JPanel();
			
			ImageIcon icon = new ImageIcon("C:\\Users\\joshw\\OneDrive\\school\\Java Fundimentals\\$$eclips"
					+ " workspace\\Prcaice\\src\\Store\\CheapChair.jpg");
			imglabel = new JLabel(icon);
			
			
			btddcart.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						Global.customer.addToCart("Chair",(String)colorbox.getSelectedItem(),
						(Integer)Quantitybox.getSelectedItem(),29.99);
						bottompanel.txSubtotal.setText("$"+Global.subtotal);
					}
				}
			);
			
			btremove.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 		
					{
						Global.customer.removeFromCart();
						bottompanel.txSubtotal.setText("$"+Global.subtotal);
					}
				}
			);
			
			btmore.addActionListener(new ActionListener()	
				{
					public void actionPerformed(ActionEvent e) 
					{
						// TODO Auto-generated method stub
					}
				}		
			);
			
			
			this.add(imglabel);
			this.add(description);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			
			sub1.add(colorbox);
			sub1.add(Quantitybox);
			sub1.add(btmore);
			
			sub2.add(btddcart);
			sub2.add(btremove);
			
			this.add(sub1);
			this.add(sub2);
			sub1.setBackground(Color.WHITE);
			sub2.setBackground(Color.WHITE);
			this.setBackground(Color.WHITE);
			
			this.setPreferredSize(new Dimension(210,400));
		}// end constructor			
	}
	
	private class buildBedFramePanel extends JPanel
	{
		
		private JButton btddcart,btremove,btmore;
		private JComboBox colorbox , Quantitybox;
		private String[] colors = {"Brown","Black","White"};
		private JTextArea description;
		private ImageIcon chaepchairimgae;
		private JLabel imglabel;
		private BufferedImage image;
		private JPanel sub1 ,sub2;
		
		buildBedFramePanel()
		{
				
			btddcart = new JButton("Add To Cart");
			btremove = new JButton("Remove");
			btmore = new JButton("More...");
			colorbox = new JComboBox(bedFrameColors);
			Quantitybox = new JComboBox(quantity);
			description = new JTextArea(5,17);
			description.setText("Desciprtion goes here");
			description.setEditable(false);
			sub1 = new JPanel();
			sub2 = new JPanel();
			
			ImageIcon icon = new ImageIcon("C:\\Users\\joshw\\OneDrive\\school\\Java Fundimentals\\$$eclips"
					+ " workspace\\Prcaice\\src\\Store\\bedframe.jpg");
			
			imglabel = new JLabel(icon);
			
			this.add(imglabel);
			this.add(imglabel);
			this.add(description);
			
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			
			
			btddcart.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						Global.customer.addToCart("Bed Frame",(String)colorbox.getSelectedItem(),
						(Integer)Quantitybox.getSelectedItem(),119.99);
						bottompanel.txSubtotal.setText("$"+Global.subtotal);
					}
				}
			);
			
			btremove.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 		
					{
						Global.customer.removeFromCart();
						bottompanel.txSubtotal.setText("$"+Global.subtotal);
					}
				}
			);
			
			btmore.addActionListener(new ActionListener()	
				{
					public void actionPerformed(ActionEvent e) 
					{
						// TODO Auto-generated method stub
					}
				}		
			);
		
		
			sub1.add(colorbox);
			sub1.add(Quantitybox);
			sub1.add(btmore);
			
			sub2.add(btddcart);
			sub2.add(btremove);
			
			this.add(sub1);
			this.add(sub2);
			sub1.setBackground(Color.WHITE);
			sub2.setBackground(Color.WHITE);
			this.setBackground(Color.WHITE);
			
			
			this.setPreferredSize(new Dimension(210,400));
			
		}
				
	}

	private class buildDresserpanel extends JPanel
	{
		
		private JButton btddcart,btremove,btmore;
		private JComboBox colorbox , Quantitybox;
		private String[] colors = {"Brown","Black","White"};
		private JTextArea description;
		private ImageIcon chaepchairimgae;
		private JLabel imglabel;
		private BufferedImage image;
		private JPanel sub1 ,sub2;
		
		buildDresserpanel()
		{
			btddcart = new JButton("Add To Cart");
			btremove = new JButton("Remove");
			btmore = new JButton("More...");
			colorbox = new JComboBox(dresserColors);
			Quantitybox = new JComboBox(quantity);
			description = new JTextArea(5,17);
			description.setText("Desciprtion goes here");
			description.setEditable(false);
			sub1 = new JPanel();
			sub2 = new JPanel();
			
			ImageIcon icon = new ImageIcon("C:\\Users\\joshw\\OneDrive\\school\\Java Fundimentals\\$$eclips"
					+ " workspace\\Prcaice\\src\\Store\\dresser.jpg");
			imglabel = new JLabel(icon);
			
			this.add(imglabel);
			this.add(description);
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			
			btddcart.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						Global.customer.addToCart("Dresser",(String)colorbox.getSelectedItem(),
						(Integer)Quantitybox.getSelectedItem(),44.99);
						bottompanel.txSubtotal.setText("$"+Global.subtotal);
					}
				}
			);
		
			btremove.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 		
					{
						Global.customer.removeFromCart();
						bottompanel.txSubtotal.setText("$"+Global.subtotal);
					}
				}
			);
			
			btmore.addActionListener(new ActionListener()	
				{
					public void actionPerformed(ActionEvent e) 
					{
						// TODO Auto-generated method stub
					}
				}		
			);
			
			sub1.add(colorbox);
			sub1.add(Quantitybox);
			sub1.add(btmore);
			
			sub2.add(btddcart);
			sub2.add(btremove);
			
			this.add(sub1);
			this.add(sub2);
			sub1.setBackground(Color.WHITE);
			sub2.setBackground(Color.WHITE);
			this.setBackground(Color.WHITE);
			
			
			this.setPreferredSize(new Dimension(210,400));
		}
				
		
	}
	
	private class buildtablepanel extends JPanel
	{
		
		private JButton btddcart,btremove,btmore;
		private JComboBox colorbox , Quantitybox;
		private String[] colors = {"Brown","Black","White"};
		private JTextArea description;
		private ImageIcon chaepchairimgae;
		private JLabel imglabel;
		private BufferedImage image;
		private JPanel sub1 ,sub2;
		
		buildtablepanel()
		{
				
			btddcart = new JButton("Add To Cart");
			btremove = new JButton("Remove");
			btmore = new JButton("More...");
			colorbox = new JComboBox(deskColors);
			Quantitybox = new JComboBox(quantity);
			description = new JTextArea(5,17);
			description.setText("Desciprtion goes here");
			description.setEditable(false);
			sub1 = new JPanel();
			sub2 = new JPanel();
			
			ImageIcon icon = new ImageIcon("C:\\Users\\joshw\\OneDrive\\school\\Java Fundimentals\\$$eclips"
					+ " workspace\\Prcaice\\src\\Store\\table.jpg");
			imglabel = new JLabel(icon);
			
			this.add(imglabel);
			this.add(description);
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			
			btddcart.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						Global.customer.addToCart("Desk",(String)colorbox.getSelectedItem(),
						(Integer)Quantitybox.getSelectedItem(),19.99);
						bottompanel.txSubtotal.setText("$"+Global.subtotal);
					}
				}
			);
		
			btremove.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 		
					{
						Global.customer.removeFromCart();
						bottompanel.txSubtotal.setText("$"+Global.subtotal);
					}
				}
			);
		
			btmore.addActionListener(new ActionListener()	
				{
					public void actionPerformed(ActionEvent e) 
					{
						// TODO Auto-generated method stub
					}
				}		
			);
			
			sub1.add(colorbox);
			sub1.add(Quantitybox);
			sub1.add(btmore);
			
			sub2.add(btddcart);
			sub2.add(btremove);
			
			this.add(sub1);
			this.add(sub2);
			sub1.setBackground(Color.WHITE);
			sub2.setBackground(Color.WHITE);
			this.setBackground(Color.WHITE);
			
			
			this.setPreferredSize(new Dimension(210,400));
		
		}
				
	}
	
	private class buildofficechairpanel extends JPanel
	{
		
		private JButton btddcart,btremove,btmore;
		private JComboBox colorbox , Quantitybox;
		private String[] colors = {"Brown","Black","White"};
		private JTextArea description;
		private ImageIcon chaepchairimgae;
		private JLabel imglabel;
		private BufferedImage image;
		private JPanel sub1 ,sub2;
		
		buildofficechairpanel()
		{		
			btddcart = new JButton("Add To Cart");
			btremove = new JButton("Remove");
			btmore = new JButton("More...");
			colorbox = new JComboBox(officeChairColors);
			Quantitybox = new JComboBox(quantity);
			description = new JTextArea(5,17);
			description.setText("Desciprtion goes here");
			description.setEditable(false);
			sub1 = new JPanel();
			sub2 = new JPanel();
			
			ImageIcon icon = new ImageIcon("C:\\Users\\joshw\\OneDrive\\school\\Java Fundimentals\\$$eclips"
					+ " workspace\\Prcaice\\src\\Store\\officechair.jpg");
			imglabel = new JLabel(icon);
			
			this.add(imglabel);
			this.add(description);
			this.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
			
			btddcart.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						Global.customer.addToCart("Office Chair",(String)colorbox.getSelectedItem(),
						(Integer)Quantitybox.getSelectedItem(),69.99);
						bottompanel.txSubtotal.setText("$"+Global.subtotal);
					}
				}
			);
		
			btremove.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 		
					{
						Global.customer.removeFromCart();
						bottompanel.txSubtotal.setText("$"+Global.subtotal);
					}
				}
			);
			
			btmore.addActionListener(new ActionListener()	
				{
					public void actionPerformed(ActionEvent e) 
					{
						// TODO Auto-generated method stub
					}
				}		
			);
			
			sub1.add(colorbox);
			sub1.add(Quantitybox);
			sub1.add(btmore);
			
			sub2.add(btddcart);
			sub2.add(btremove);
			
			this.add(sub1);
			this.add(sub2);
			sub1.setBackground(Color.WHITE);
			sub2.setBackground(Color.WHITE);
			this.setBackground(Color.WHITE);
			
			
			this.setPreferredSize(new Dimension(210,400));
		}
			
	}
	
	private class buildbottompanel extends JPanel
	{
		private JLabel lbSubtotal;
		private JTextField txSubtotal;
		private JButton btConfirmOrder;
		
		buildbottompanel()
		{
			Font font = new Font(Font.SANS_SERIF, Font.BOLD, 24);
			
			lbSubtotal = new JLabel("Subtotal");
			txSubtotal = new JTextField("$0.0");
			btConfirmOrder = new JButton("Confirm Order");
			txSubtotal.setEditable(false);
			lbSubtotal.setFont(font);
			btConfirmOrder.setFont(font);
			txSubtotal.setColumns(20);
			
			this.add(lbSubtotal);
			this.add(txSubtotal);
			this.add(btConfirmOrder);
			
			btConfirmOrder.addActionListener(new ActionListener()
				{
					public void actionPerformed(ActionEvent e) 
					{
						win.setVisible(false);
						ConfirmWindow CW = new ConfirmWindow();
					}
				}
			);
			
			this.setBackground(Color.CYAN);	
			
			FlowLayout layout = new FlowLayout();
			this.setLayout(layout);
			
			txSubtotal.setPreferredSize(new Dimension(110,25));
			
			this.setPreferredSize(new Dimension(1080,150));
		}
			
	}
	
	
	private static void setLookAndFeel()
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


	
}
