/*
 * Joshua Finch
 */
package edu.towson.cis.cosc442.project2.vendingmachine;

import static org.junit.Assert.*;
import org.junit.*;

public class VendingMachineItemTest {
	
	/** The test vend item. */
	public VendingMachineItem testVendItem = new VendingMachineItem("Starburst",0.10);
	
	public double price;
	
	@Before
	public void setUp() throws Exception {
	}
	
	@After
	public void tearDown() throws Exception{
		
	}
	
	/**
	 * Test the name to make sure it's Starburst.
	 */
	@Test
	public void testGetName() {
		//Should be incorrect
		assertEquals("Starburst",testVendItem.getName());
	}
	
	@Test
	public void testGetName2() {
		//Should b incorrect
		assertEquals("Starbrust",testVendItem.getName());
	}
	
	/**
	 * Test the name to make sure it's 0.10c.
	 */
	
	@Test
	public void testGetPrice() {
		//Should be correct
		assertEquals(0.10,testVendItem.getPrice(), 0.10);
	}
	
	@Test
	public void testGetPrice2() {
		//Should be incorrect
		assertEquals(0.01,testVendItem.getPrice(), 0.01);
	}
}
