package assignment1;
import java.util.ArrayList;

public class InventoryModel {

	private ArrayList<String> partNumber;
	private ArrayList<String> partName;
	private ArrayList<String> vendor;
	private ArrayList<Integer> quantity;
	private ArrayList<String> unitOfQ;
	private int count;

	public InventoryModel() {
		partNumber = new ArrayList<>();
		partName = new ArrayList<>();
		vendor = new ArrayList<>();
		quantity = new ArrayList<>();
		unitOfQ = new ArrayList<>();
		count = 0;
	}
	
	public int setPartNum(String s) {
		int flag = 0;
		if (s.length() > 20) {
			return flag;
		}
		
		this.partNumber.add(s);
		return flag = 1;

	}

	public int setPartNum(String s, int row) {
		int flag = 0;
		if (s.length() > 20) {
			return flag;
		}
		
		this.partNumber.set(row, s);
		return flag = 1;

	}

	public String getPartNum() {
		return this.partNumber.get(count);
	}

	public String getPartNum(int n) {
		return this.partNumber.get(n);
	}

	public int setVendor(String s) {
		int flag = 0;
		if (s.length() > 255) {
			return flag;
		}
		
		this.vendor.add(s);
		return flag = 1;

	}

	public int setVendor(String s, int row) {
		int flag = 0;
		if (s.length() > 255) {
			return flag;
		}
		
		this.vendor.set(row, s);
		return flag = 1;
	}

	public String getVendor() {
		return this.vendor.get(count);
	}

	public String getVendor(int n) {
		return this.vendor.get(n);
	}

	public int setPartName(String s) {
		int flag = 0;
		if (s.length() > 255) {
			return flag;
		}
		for (int i = 0; i < partName.size(); i++) {
			if (s.equals(partName.get(i))) {
				return flag;
			}
		}
		this.partName.add(s);
		return flag = 1;
	}

	public int setPartName(String s, int row) {
		int flag = 0;
		if (s.length() > 255) {
			return flag;
		}
		for (int i = 0; i < partName.size(); i++) {
			if (s.equals(partName.get(i))) {
				return flag;
			}
		}
		this.partName.set(row, s);
		return flag = 1;
	}

	public String getPartName() {
		return this.partName.get(count);
	}

	public String getPartName(int n) {
		return this.partName.get(n);
	}

	public int setQuantity(int num) {
		int flag = 0;
		if (num <= 0) {
			return flag;
		}
		this.quantity.add(num);
		return flag = 1;
	}

	public int setQuantity(int num, int row) {
		int flag = 0;
		if (num <= 0) {
			return flag;
		}
		this.quantity.set(row, num);
		return flag = 1;
	}

	public int getQuantity() {
		return this.quantity.get(count);
	}

	public int getQuantity(int n) {
		return this.quantity.get(n);
	}

	
	public int setUnitOfQuantity(String s) {
		int flag = 0;
		if (s == null) {
			this.unitOfQ.add("Unknown");
			return flag = 1;
		} else if (s.equalsIgnoreCase("unknown")) {
			return flag;
		} else {
			this.unitOfQ.add(s);
			return flag = 1;
		}
	}

	public int setUnitOfQuantity(String s, int row) {
		int flag = 0;
		if (s == null) {
			this.unitOfQ.set(row, "Unknown");
			return flag = 1;
		} else if (s.equalsIgnoreCase("unknown")) {
			return flag;
		} else {
			this.unitOfQ.set(row, s);
			return flag = 1;
		}
	}

	public String getUnitOfQuantity() {
		return this.unitOfQ.get(count);
	}

	public String getUnitOfQuantity(int n) {
		return this.unitOfQ.get(n);
	}


	public int getCount() {
		return count;
	}

	public void incrementCount() {
		count++;
	}

	public void deleteElements(int row) {
		partNumber.set(row, null);
		partName.set(row, null);
		vendor.set(row, null);
		quantity.set(row, null);
	}
}
