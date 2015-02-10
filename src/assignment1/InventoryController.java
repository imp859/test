package assignment1;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class InventoryController implements ActionListener {

	private InventoryView inOpt;
	private InventoryModel inMod;

	private int editFlag;
	private int numFlag, nameFlag, vendorFlag, quantityFlag, unitOfQFlag;

	public InventoryController(InventoryView otherView,
			InventoryModel otherModel) {
		this.inOpt = otherView;
		this.inMod = otherModel;
		numFlag = 0;
		nameFlag = 0;
		vendorFlag = 0;
		quantityFlag = 0;
		editFlag = 0;
		unitOfQFlag = 0;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String s;
		if (e.getActionCommand().equals("Add Inventory")) {
			inOpt.openNewView(this);
			editFlag = 0;
			vendorFlag = 0;
			quantityFlag = 0;
			nameFlag = 0;
			numFlag = 0;
			unitOfQFlag = 0;
		} else if (e.getActionCommand().equals("Edit Inventory")) {
			int row = inOpt.getTable();
			if (row >= 0) {
				inOpt.openEditView(this, inMod.getPartNum(row),
						inMod.getPartName(row), inMod.getVendor(row),
						inMod.getQuantity(row));
				editFlag = 1;
			}
		} else if (e.getActionCommand()
				.equals(inOpt.getPartViewNum().getText())) {
			if (editFlag == 0) {
				s = e.getActionCommand();
				numFlag = inMod.setPartNum(s);
				if (numFlag == 0) {
					inOpt.invalidPartNum();
				}
			} else {
				s = e.getActionCommand();
				numFlag = inMod.setPartNum(s, inOpt.getTable());
				if (numFlag == 0) {
					inOpt.invalidPartNum();
					System.out.println(inMod.getPartNum(inOpt.getTable()));
				}
			}
		} else if (e.getActionCommand().equals(
				inOpt.getPartViewName().getText())) {
			if (editFlag == 0) {
				s = e.getActionCommand();
				nameFlag = inMod.setPartName(s);
				if (nameFlag == 0) {
					inOpt.invalidPartName();
				}
			} else {
				s = e.getActionCommand();
				nameFlag = inMod.setPartName(s, inOpt.getTable());
				if (nameFlag == 0) {
					inOpt.invalidPartName();
				}
			}
		} else if (e.getActionCommand().equals(
				(inOpt.getPartViewVendor().getText()))) {
			if (editFlag == 0) {
				if (e.getActionCommand() == null
						&& e.getActionCommand().isEmpty()) {
					s = "N/A";
					vendorFlag = inMod.setVendor(s);
					vendorFlag = 0;
				} else {
					s = e.getActionCommand();
					vendorFlag = inMod.setVendor(s);
					if (vendorFlag == 0) {
						inOpt.invalidVendor();
					}
				}
			} else {
				if (e.getActionCommand() == null
						&& e.getActionCommand().isEmpty()) {
					s = "N/A";
					vendorFlag = inMod.setVendor(s, inOpt.getTable());
					vendorFlag = 0;
				} else {
					s = e.getActionCommand();
					vendorFlag = inMod.setVendor(s, inOpt.getTable());
					if (vendorFlag == 0) {
						inOpt.invalidVendor();
					}
				}
			}
		} else if (e.getActionCommand().equals(
				inOpt.getPartViewQuantity().getText())) {
			if (editFlag == 0) {
				s = e.getActionCommand();
				int quantity = Integer.parseInt(s);
				quantityFlag = inMod.setQuantity(quantity);
				if (quantityFlag == 0) {
					inOpt.invalidQuantity();
					System.out.println(inMod.getQuantity(inMod.getCount()));
				}
			} else {
				s = e.getActionCommand();
				int quantity = Integer.parseInt(s);
				quantityFlag = inMod.setQuantity(quantity, inOpt.getTable());
				if (quantityFlag == 0) {
					inOpt.invalidQuantity();
					System.out.println(inMod.getQuantity(inOpt.getTable()));
				}
			}
		} else if (e.getActionCommand().equals(
				inOpt.getPartViewUnitofQuantity().getText())) {
			if (editFlag == 0) {
				if (e.getActionCommand() == null
						&& e.getActionCommand().isEmpty()) {
					s = e.getActionCommand();
					unitOfQFlag = inMod.setUnitOfQuantity(s);
					unitOfQFlag = 0;
				} else {
					s = e.getActionCommand();
					unitOfQFlag = inMod.setUnitOfQuantity(s);
					if (unitOfQFlag == 0) {
						inOpt.invalidVendor();
					}
				}
			} else {
				if (e.getActionCommand() == null
						&& e.getActionCommand().isEmpty()) {
					s = e.getActionCommand();
					unitOfQFlag = inMod.setUnitOfQuantity(s, inOpt.getTable());
					vendorFlag = 0;
				} else {
					s = e.getActionCommand();
					unitOfQFlag = inMod.setUnitOfQuantity(s, inOpt.getTable());
					if (unitOfQFlag == 0) {
						inOpt.invalidVendor();
					}
				}
			}
		} else if (e.getActionCommand().equals("SAVE")) {
			if (editFlag == 0) {
				if (numFlag == 0 || nameFlag == 0 || quantityFlag == 0) {
					inOpt.invalidSave();
				} else {
					if (vendorFlag == 0) {
						inMod.setVendor("N/A");
						if(unitOfQFlag == 0){
							inMod.setUnitOfQuantity(null);
						}
						inMod.incrementIDField();
						inOpt.addAnotherRow(inMod.getPartNum(),
								inMod.getPartName(), inMod.getVendor(),
								inMod.getQuantity(), inMod.getIDField(), inMod.getUnitOfQuantity());
						inMod.incrementCount();
					} else {
						 if(unitOfQFlag ==0){
                                                        inMod.setUnitOfQuantity(null)
                                                }
						inMod.incrementIDField();
						inOpt.addAnotherRow(inMod.getPartNum(),
								inMod.getPartName(), inMod.getVendor(),
								inMod.getQuantity(), inMod.getIDField(), inMod.getUnitofQuantity());
						inMod.incrementCount();
					}
					numFlag = nameFlag = quantityFlag = vendorFlag = editFlag = unitOfQFlag = 0;
				}
			} else if (editFlag == 1) {
				if (numFlag == 0 || nameFlag == 0 || quantityFlag == 0) {
					inOpt.invalidSave();
				} else {
					if (vendorFlag == 0) {
						inMod.setVendor("N/A", inOpt.getTable());
					}
					if(unitOfQFlag == 0){
                                                inMod.setUnitOfQuantity(null, inOpt.getTable());
                                        }
					inMod.incremenetIDField();				
					inOpt.editRow(inMod.getPartNum(inOpt.getTable()),
							inMod.getPartName(inOpt.getTable()),
							inMod.getVendor(inOpt.getTable()),
							inMod.getQuantity(inOpt.getTable()), inMod.getIDField(), inMod.getUnitOfQuantity(inOpt.getTable()));
				}
			}
		} else if (e.getActionCommand().equals("DELETE")) {
			inMod.deleteElements(inOpt.getTable());
			inOpt.deleteRow(inOpt.getTable());
		}
	}
}
