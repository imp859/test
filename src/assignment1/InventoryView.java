package assignment1;
import java.awt.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;

public class InventoryView extends JFrame {

	private final static String ADD = "Add Inventory";
	private final static String DELETE = "Delete Inventory";
	private final static String EDIT = "Edit Inventory";
	private final static String VIEW = "View Inventory";

	private PartView otherView;

	private JScrollPane scrollPane;
	private JTable mainPartList;
	private DefaultTableModel dtm;

	private JButton addButton, editButton;
	private JPanel westPanel, centerPanel;

	public InventoryView() {
		super("Inventory View");
		/* choices for user */
		addButton = new JButton(ADD);
		editButton = new JButton(EDIT);
		dtm = new DefaultTableModel(new Object[] { "Part #", "Part Name",
				"Vendor", "Quantity" }, 0);

		mainPartList = new JTable(dtm);
		mainPartList.getTableHeader().setReorderingAllowed(false);
		mainPartList
				.setSelectionMode((ListSelectionModel.MULTIPLE_INTERVAL_SELECTION));
		scrollPane = new JScrollPane(mainPartList);
		scrollPane.setBounds(5, 5, 320, 115);
		westPanel = new JPanel();
		add(westPanel, BorderLayout.WEST);
		westPanel.setLayout(new BoxLayout(westPanel, BoxLayout.Y_AXIS));
		westPanel.setBackground(Color.CYAN);
		westPanel.add(addButton);
		westPanel.add(editButton);
		/* center panel to see inventory */
		centerPanel = new JPanel();
		add(centerPanel, BorderLayout.CENTER);
		centerPanel.setBackground(Color.WHITE);
		centerPanel.add(scrollPane);
	}

	public void addAnotherRow(String prtNum, String prtName, String Ven,
			int quant) {
		//DefaultTableModel tempDtm = (DefaultTableModel) mainPartList.getModel();
		dtm.addRow(new Object[] { prtNum, prtName, Ven, quant });
	}

	public void editRow(String prtNum, String prtName, String Ven, int quant) {
		mainPartList.setValueAt(prtNum, getTable(), 0);
		mainPartList.setValueAt(prtName, getTable(), 1);
		mainPartList.setValueAt(Ven, getTable(), 2);
		mainPartList.setValueAt(quant, getTable(), 3);
	}

	public void deleteRow(int row) {
		((DefaultTableModel) mainPartList.getModel()).removeRow(row);
	}

	public void registerListeners(InventoryController c) {
		addButton.addActionListener(c);
		editButton.addActionListener(c);
	}

	public void openNewView(InventoryController c) {
		otherView = new PartView();
		otherView.partViewRegisterListeners(c);
		otherView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		otherView.setSize(400, 300);
		otherView.setVisible(true);
	}

	public void openEditView(InventoryController c, String name, String num,
			String ven, int quant) {
		otherView = new PartView(name, num, ven, quant);
		otherView.partViewRegisterListeners(c);
		otherView.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
		otherView.setSize(400, 300);
		otherView.setVisible(true);
	}

	public int getTable() {
		return mainPartList.getSelectedRow();
	}

	public JTextField getPartViewNum() {
		return otherView.getPartNum();
	}

	public JTextField getPartViewName() {
		return otherView.getPartName();
	}

	public JTextField getPartViewVendor() {
		return otherView.getVendor();
	}

	public JTextField getPartViewQuantity() {
		return otherView.getQuantity();
	}

	public JButton getPartViewSave() {
		return otherView.getSave();
	}

	public void invalidPartNum() {
		JOptionPane.showMessageDialog(otherView.getPartNum(),
				"Part Num cannot be longer than 20 seconds");
	}

	public void invalidPartName() {
		JOptionPane
				.showMessageDialog(otherView.getPartName(),
						"Part Name cannot be more than 250 characters\n and Part Name must be unique");
	}

	public void invalidVendor() {
		JOptionPane.showMessageDialog(otherView.getVendor(),
				"Vendor cannot be more than 255 characters long");
	}

	public void invalidQuantity() {
		JOptionPane.showMessageDialog(otherView.getQuantity(),
				"Quantity must be greater than or equal to 1");
	}

	public void invalidSave() {
		JOptionPane.showMessageDialog(otherView.getSave(),
				"One of the fields was not entered correctly");
	}
}

