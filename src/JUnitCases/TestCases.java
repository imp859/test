package JUnitCases;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import assignment1.InventoryModel;
public class TestCases {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Test
	public void assertQuantityGreaterthanZero(){
		int expected = 1;
		InventoryModel mod = new InventoryModel();
		int actual = mod.setQuantity(4);
		assertEquals(expected, actual);
		actual = mod.setQuantity(0);
		assertNotSame(expected, actual);
		actual = mod.setQuantity(0, 0);
		assertNotSame(expected, actual);
	}
	
	@Test
	public void assertUniquePartNumbers(){
		int expected = 1;
		String s = "test";
		/*test to make sure no part numbers are the same*/
		InventoryModel mod = new InventoryModel();
		int actual = mod.setPartName("partNumber");
		actual = mod.setPartName("test");
		assertEquals(expected, actual);
		actual = mod.setPartName("test");
		assertNotSame(expected, actual);
		actual = mod.setPartName("test", 0);
		assertNotSame(expected, actual);
	}
	@Test
	public void assertCorrectParameterLength(){
		int expected = 1;
		InventoryModel mod= new InventoryModel();
		String longString = " ", mediumString = " ", validString = "valid";
		/*strings made to be sizes of 255, 20, and less than 20*/
		for(int i = 0; i < 256; i++){
			if(i < 20){
				mediumString = mediumString.concat("a");
			}
			longString = longString.concat("a");
		}
		
		/*check method without rows*/
		int actual = mod.setPartName(longString);
		assertNotSame(expected, actual);
		actual = mod.setPartNum(mediumString);
		assertNotSame(expected, actual);
		actual = mod.setPartNum(validString);
		assertEquals(expected, actual);
		actual = mod.setPartName(validString);
		assertEquals(expected, actual);
		actual = mod.setVendor(longString);
		assertNotSame(expected, actual);
		actual = mod.setVendor(validString);
		assertEquals(expected, actual);
		
		/*check method with rows*/
		actual = mod.setPartName(longString, 0);
		assertNotSame(expected, actual);
		actual = mod.setPartNum(mediumString, 0);
		assertNotSame(expected, actual);
		
		actual = mod.setPartNum(validString, 0);
		assertEquals(expected, actual);		
		actual = mod.setVendor(longString, 0);
		assertNotSame(expected, actual);
		actual = mod.setVendor(validString, 0);
		assertEquals(expected, actual);
	
	}
	
}
