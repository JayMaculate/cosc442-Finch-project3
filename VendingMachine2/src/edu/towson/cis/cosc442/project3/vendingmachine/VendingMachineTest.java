package edu.towson.cis.cosc442.project3.vendingmachine;

import static org.junit.Assert.*;
import org.junit.*;

public class VendingMachineTest {

	public VendingMachine testVend;
	
	@Before
	public void setUp() {
		testVend = new VendingMachine();
	}
	
	@After
	public void tearDown() {
		testVend = null;
	}
	
	
	/**
	 * Tests the add Item if it is empty
	 */
	@Test
	public void addItemEmptyTest() {
		VendingMachineItem vendMachineItem = new VendingMachineItem("Starburst",0.10);
		//adds a new object at slot A
		testVend.addItem(vendMachineItem, "A");
		assertEquals(vendMachineItem, testVend.getItem("A"));
	}
	
	
	/**
	 * Tests to see if the second item will be added even thought the slot is already occupied. 
	 * Should throw the occupied exception
	 */
	@Test (expected = Exception.class)
	public void addItemOccupiedTest() {
		VendingMachineItem vendMachineItem = new VendingMachineItem("Starburst",0.10);
		VendingMachineItem vendMachineItem2 = new VendingMachineItem("Snickers",0.05);
		testVend.addItem(vendMachineItem, "A");
		testVend.addItem(vendMachineItem2, "A");
		//This will not give the expected value instead it will give the first item
		assertNotEquals(vendMachineItem2, testVend.getItem("A"));
	}
	
	@Test (expected = Exception.class)
	public void addItemOccupiedTest2() {
		VendingMachineItem vendMachineItem = new VendingMachineItem("Starburst",0.10);
		VendingMachineItem vendMachineItem2 = new VendingMachineItem("Snickers",0.05);
		testVend.addItem(vendMachineItem, "B");
		testVend.addItem(vendMachineItem2, "B");
		//This will not give the expected value instead it will give the first item
		assertNotEquals(vendMachineItem2, testVend.getItem("B"));
	}
	
	@Test (expected = Exception.class)
	public void addItemOccupiedTest3() {
		VendingMachineItem vendMachineItem = new VendingMachineItem("Starburst",0.10);
		VendingMachineItem vendMachineItem2 = new VendingMachineItem("Snickers",0.05);
		testVend.addItem(vendMachineItem, "C");
		testVend.addItem(vendMachineItem2, "C");
		//This will not give the expected value instead it will give the first item
		assertNotEquals(vendMachineItem2, testVend.getItem("C"));
	}
	
	@Test (expected = Exception.class)
	public void addItemOccupiedTest4() {
		VendingMachineItem vendMachineItem = new VendingMachineItem("Starburst",0.10);
		VendingMachineItem vendMachineItem2 = new VendingMachineItem("Snickers",0.05);
		testVend.addItem(vendMachineItem, "D");
		testVend.addItem(vendMachineItem2, "D");
		//This will not give the expected value instead it will give the first item
		assertNotEquals(vendMachineItem2, testVend.getItem("D"));
	}
	
	@Test (expected = Exception.class)
	public void addItemOccupiedTest5() throws Exception{
		VendingMachineItem vendMachineItem = new VendingMachineItem("Starburst",0.10);
		VendingMachineItem vendMachineItem2 = new VendingMachineItem("Snickers",0.05);
		testVend.addItem(vendMachineItem, "E");
		testVend.addItem(vendMachineItem2, "E");
		//This will not give the expected value instead it will give the first item
		assertNotEquals(vendMachineItem2, testVend.getItem("E"));
	}
	
	
	/**
	 * Test to remove Item if the slot is occupied
	 */
	@Test
	public void removeItemFullTest() {
		VendingMachineItem vendMachineItem = new VendingMachineItem("Starburst",0.10);
		testVend.addItem(vendMachineItem,"A");
		testVend.removeItem("A");
		assertNotSame(vendMachineItem,testVend.getItem("A"));
	}
	
	/**
	 * Try's to remove the item if the slot is empty
	 * Exception throw is expected
	 */
	@Test (expected = Exception.class)
	public void removeItemEmptyTest() {
		testVend.removeItem("A");
	}
	
	/**
	 * Test to make sure the amount inserted is positive.
	 * 
	 */
	@Test
	public void posMoneyTest() {
		testVend.insertMoney(1.0);
		assertEquals(1.0,testVend.getBalance(),0);
	}
	
	/**
	 * Test to make sure negative values receive an exception thrown
	 */
	@Test (expected = Exception.class)
	public void negMoneyTest() {
		testVend.insertMoney(-1.0);
		//assertNotEqual(1.0,testVend.getBalance(),0);
	}
	
	/**
	 * Balance test.
	 */
	@Test
	public void balanceTest() {
		testVend.insertMoney(3.0);
		assertEquals(3.0, testVend.getBalance(),0);
	}
	
	/**
	 * Positive Balance and Full slot Test
	 * Expectation is to be true
	 */
	@Test
	public void purchaseOccSlotPosBalTest() {
		VendingMachineItem vendMachineItem = new VendingMachineItem("Starburst",0.10);
		testVend.addItem(vendMachineItem, "A");
		testVend.balance = 3.0;
		assertTrue(testVend.makePurchase("A"));
	}
	
	/**
	 * Negative Balance and Full slot Test
	 * Expectation to be false
	 */
	@Test
	public void purchaseOccSlotNegBalTest() {
		testVend.balance = -3.0;
		assertFalse(testVend.makePurchase("A"));
	}
	
	/**
	 * Test Empty Slot and Positive Balance
	 * Expected to be false
	 */
	@Test
	public void purchaseEmptyPosBal() {
		assertFalse(testVend.makePurchase("A"));
	}
	
	/**
	 * Return change test.
	 * Expected to return change
	 */
	@Test
	public void returnChangeTest() {
		testVend.balance = 3.0;
		assertEquals(3.0, testVend.getBalance(),0);
	}
	
	@Test
	public void returnChangeTest2() {
		testVend.balance = 2.0;
		assertEquals(2.0, testVend.returnChange(),0);
	}
}