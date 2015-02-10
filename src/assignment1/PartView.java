package assignment1;


import java.awt.Color;
import java.awt.Panel;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PartView extends JFrame {

	private JLabel partName;
	private JLabel partNum;
	private JLabel vendor;
	private JLabel quantity;

	private JPanel prtView;

	private JTextField partNameText;
	private JTextField partNumText;
	private JTextField vendorText;
	private JTextField quantityText;
	
	private JButton save;
	private JButton delete;
	
	private String partNumString, partNameString, partVendorString;
	private int partQuantity;
	
	public PartView() {
		prtView = new JPanel();
		add(prtView);
		prtView.setBackground(Color.WHITE);
		partNum = new JLabel("Part Number: ");
		prtView.add(partNum);
		partNumText = new JTextField("Enter Part Number");
		prtView.add(partNumText);

		partName = new JLabel("Part Name: ");
		prtView.add(partName);
		partNameText = new JTextField("Enter Part Name");
		prtView.add(partNameText);

		vendor = new JLabel("Vendor: ");
		prtView.add(vendor);
		vendorText = new JTextField("Enter Vendor");
		prtView.add(vendorText);
		
		quantity = new JLabel("Quantity: ");
		prtView.add(quantity);
		quantityText = new JTextField("Enter Quantity: ");
		prtView.add(quantityText);
		
		save = new JButton("SAVE");
		prtView.add(save);
		delete = new JButton("DELETE");
	}
	
	public PartView(String num, String name, String ven, int quant){
		partNumString = num;
		partNameString = name;
		partVendorString = ven;
		partQuantity = quant;
		prtView = new JPanel();
		add(prtView);
		prtView.setBackground(Color.WHITE);
		partNum = new JLabel("Part Number: ");
		prtView.add(partNum);
		partNumText = new JTextField(num);
		prtView.add(partNumText);

		partName = new JLabel("Part Name: ");
		prtView.add(partName);
		partNameText = new JTextField(name);
		prtView.add(partNameText);

		vendor = new JLabel("Vendor: ");
		prtView.add(vendor);
		vendorText = new JTextField(ven);
		prtView.add(vendorText);
		
		quantity = new JLabel("Quantity: ");
		prtView.add(quantity);
		String qString = Integer.toString(quant);
		quantityText = new JTextField(qString);
		prtView.add(quantityText);
		
		save = new JButton("SAVE");
		prtView.add(save);
		delete = new JButton("DELETE");
		prtView.add(delete);
	}

	public void partViewRegisterListeners(InventoryController c) {
		partNumText.addActionListener(c);
		partNameText.addActionListener(c);
		vendorText.addActionListener(c);
		quantityText.addActionListener(c); 
		save.addActionListener(c);
		delete.addActionListener(c);
	}
	
	public JButton getSave(){
		return this.save;
	}

	public JTextField getPartNum() {
		return this.partNumText;
	}

	public JTextField getPartName() {
		return this.partNameText;
	}

	public JTextField getVendor() {
		return this.vendorText;
	}
	
	public JTextField getQuantity(){
		return this.quantityText;
	}
}
