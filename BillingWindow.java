package Store;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.UIManager;




public class BillingWindow {

	
	
	private JFrame bwin;
	private JLabel lblname,lbfname,lbaddress,lbcity,lbprovince,lbpostalcode,lbemail,lbpayment,lbleft,lbright;
	private JTextField txlname,txfname,txaddress,txcity,txprovince,txpostalcode,txemail;
	private JTextArea invoice;
	private JButton btcontinue,btexit;
	private JRadioButton rmastercard,rvisa;
	private ButtonGroup group;
	private JPanel leftpanel , rightpanel;
	
	BillingWindow()
	{
		
		bwin = new JFrame("Billing Window");
		
		lbfname = new JLabel("Firstname:");
		lblname = new JLabel("Lastname:");
		lbaddress = new JLabel("Address:");
		lbcity = new JLabel("City:");
		lbprovince = new JLabel("Province:");
		lbpostalcode = new JLabel("PostalCode");
		lbemail = new JLabel("Email Address:");
		lbpayment = new JLabel("Method of Payment:");
		lbleft = new JLabel("Fill in all fields to complete your checkout");
		lbright = new JLabel("Cusotmer Invoice");
		Font font2 = new Font(Font.MONOSPACED, Font.BOLD, 14);
		invoice = new JTextArea(16,40);
		invoice.setFont(font2);
		
		txfname = new JTextField();
		txlname = new JTextField();
		txaddress = new JTextField();
		txcity = new JTextField();
		txprovince = new JTextField();
		txpostalcode = new JTextField();
		txemail = new JTextField();
		
		Font font = new Font(Font.DIALOG, Font.BOLD, 14);
		
		Dimension txsize = new Dimension(220,25);
		
		btcontinue = new JButton("Continue");
		btexit = new JButton("Exit");
		
		rmastercard = new JRadioButton("MasterCard");
		rvisa  = new JRadioButton("Visa",true);
		
		group = new ButtonGroup();
		
		leftpanel = new JPanel();
		rightpanel = new JPanel();
		
		bwin.setSize(785,427);
		bwin.setDefaultCloseOperation(bwin.EXIT_ON_CLOSE);
		bwin.setLocationRelativeTo(null);
		bwin.setResizable(false);
		bwin.setLayout(ShoppingWindow.layout);
		
		txfname.setPreferredSize(txsize);
		txlname.setPreferredSize(txsize);
		txaddress.setPreferredSize(txsize);
		txprovince.setPreferredSize(txsize);
		txpostalcode.setPreferredSize(txsize);
		txcity.setPreferredSize(txsize);
		txemail.setPreferredSize(txsize);
		
		leftpanel.setPreferredSize(new Dimension(380,375));
		rightpanel.setPreferredSize(new Dimension(380,375));
		
		lbleft.setFont(font);
		lbright.setFont(font);
		
		leftpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		rightpanel.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		invoice.setBorder(BorderFactory.createLineBorder(Color.BLACK, 1));
		
		group.add(rmastercard);
		group.add(rvisa);
		
		btexit.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					System.exit(1);
	
				}
			}
		);
		
		btcontinue.addActionListener(new ActionListener()
			{
				public void actionPerformed(ActionEvent e) 
				{
					
					Global.customer.setFirstName(txfname.getText());
					Global.customer.setLastName(txlname.getText());
					Global.customer.setAddress(txaddress.getText());
					Global.customer.setCity((txcity.getText()));
					Global.customer.setProvince(txprovince.getText());
					Global.customer.setPostalCode(txpostalcode.getText());
					Global.customer.setEmail(txemail.getText());
					invoice.setText(Global.customer.toString());
					bwin.revalidate();	
				}
			}
		);
		
		
		bwin.add(rmastercard);
		bwin.add(rvisa);
		
		bwin.add(lbleft);
		bwin.add(lbright);

		bwin.add(btcontinue);
		bwin.add(btexit);
		
		bwin.add(invoice);
	
		bwin.add(lbfname);
		bwin.add(lblname);
		bwin.add(lbaddress);
		bwin.add(lbcity);
		bwin.add(lbprovince);
		bwin.add(lbpostalcode);
		bwin.add(lbemail);
		bwin.add(lbpayment);
		
		bwin.add(txfname);
		bwin.add(txlname);
		bwin.add(txcity);
		bwin.add(txprovince);
		bwin.add(txaddress);
		bwin.add(txemail);
		bwin.add(txpostalcode);
		
		bwin.add(leftpanel);
		bwin.add(rightpanel);
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lbleft, 50, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lbleft, 1, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lbright, 490, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lbright, 1, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, leftpanel, 5, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, leftpanel, 20, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, rightpanel, 395, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, rightpanel, 20, SpringLayout.NORTH, bwin.getContentPane());
		
		
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lbfname, 20, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lbfname, 40, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lblname, 20, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lblname, 80, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lbaddress, 20, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lbaddress, 120, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lbcity, 20, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lbcity, 160, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lbprovince, 20, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lbprovince, 200, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lbpostalcode, 20, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lbpostalcode, 240, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lbemail, 20, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lbemail, 280, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, lbpayment, 20, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, lbpayment, 320, SpringLayout.NORTH, bwin.getContentPane());
		
		
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, txfname, 160, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, txfname, 35, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, txlname, 160, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, txlname, 75, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, txaddress, 160, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, txaddress, 115, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, txcity, 160, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, txcity, 155, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, txprovince, 160, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, txprovince, 195, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, txpostalcode, 160, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, txpostalcode, 235, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, txemail, 160, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, txemail, 275, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, rmastercard, 160, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, rmastercard, 320, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, rvisa, 250, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, rvisa, 320, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, btcontinue, 300, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, btcontinue, 355, SpringLayout.NORTH, bwin.getContentPane());
		
		
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, invoice, 408, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, invoice, 30, SpringLayout.NORTH, bwin.getContentPane());
		
		ShoppingWindow.layout.putConstraint(SpringLayout.WEST, btexit, 700, SpringLayout.WEST, bwin.getContentPane());
		ShoppingWindow.layout.putConstraint(SpringLayout.NORTH, btexit, 355, SpringLayout.NORTH, bwin.getContentPane());
		
		
		
		
	
		
		bwin.setVisible(true);
		
	}	
	
}

