/**
 * 
 */
package edu.ncsu.csc316.rentals.rentaltest;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.rentals.rental.Day;
import edu.ncsu.csc316.rentals.rental.Rental;

/**
 * Test for the Day class
 * @author Ryan Buchanan
 *
 */
public class DayTest {  

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.Day#Day(int)}.
	 */
	@Test
	public void testDay() { 
		Day test1 = new Day(1);	
		assertTrue(test1.getDayNum() == 1);
		Day test2 = new Day(2);
		assertTrue(test2.getDayNum() == 2);
		Rental testRent1 = new Rental(85, test1, test2, "Chevrolet", "Tahoe");
		test1.addAdjacent(testRent1);
		assertTrue(test1.getAdjacent().getModel().equals("Tahoe"));
	}
	/**
	 * Tests the found weight and parent methods
	 */
	@Test
	public void testWeightandFoundandParent(){
		Day test1 = new Day(1);
		test1.setWeight(5);
		assertTrue(test1.getWeight() == 5);
		test1.setFound(true);
		assertTrue(test1.isFound());
		test1.setParent(new Day(27));
		assertTrue(test1.getParent().getDayNum() == 27);
		Day test2 = new Day(2);
		test2.setWeight(4);
		assertTrue(test2.getWeight() == 4);
		test2.setFound(true);
		assertTrue(test2.isFound());
		test2.setParent(new Day(27));
		assertTrue(test2.getParent().getDayNum() == 27);
		Day test3 = new Day(3);
		test3.setWeight(3);
		assertTrue(test3.getWeight() == 3);
		test3.setFound(true);
		assertTrue(test3.isFound());
		test3.setParent(new Day(27));
		assertTrue(test3.getParent().getDayNum() == 27);
		Day test4 = new Day(4);
		test4.setWeight(2);
		assertTrue(test4.getWeight() == 2);
		test4.setFound(true);
		assertTrue(test4.isFound());
		test4.setParent(new Day(27));
		assertTrue(test4.getParent().getDayNum() == 27);
		Day test5 = new Day(5);	
		test5.setWeight(1);
		assertTrue(test5.getWeight() == 1);
		test5.setFound(true);
		assertTrue(test5.isFound());
		test5.setParent(new Day(27));
		assertTrue(test5.getParent().getDayNum() == 27);
	}
	/** 
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.Day#addAdjacent(edu.ncsu.csc316.rentals.rental.Rental)}.
	 */
	@Test
	public void testAddAdjacent() {
		Day test1 = new Day(1);		
		Day test2 = new Day(2);
		Day test3 = new Day(3);
		Day test4 = new Day(4);
		Day test5 = new Day(5);	
		Rental testRent1 = new Rental(85, test1, test2, "Chevrolet", "Tahoe");
		Rental testRent2 = new Rental(180, test1, test3, "Chevrolet", "Silverado");
		Rental testRent3 = new Rental(225, test1, test4, "Toyota", "Prius");
		Rental testRent4 = new Rental(500, test1, test5, "Honda", "CRV");
		test1.addAdjacent(testRent4);
		test1.addAdjacent(testRent3);
		test1.addAdjacent(testRent2);
		test1.addAdjacent(testRent1);
		assertTrue(test1.getAdjacent().getModel().equals("Tahoe"));
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.Day#getDayNum()}.
	 */
	@Test
	public void testGetDayNum() {
		Day test1 = new Day(1);	
		assertTrue(test1.getDayNum() == 1);
		Day test2 = new Day(2);
		assertTrue(test2.getDayNum() == 2);
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.Day#getAdjacent()}.
	 */
	@Test
	public void testGetAdjacent() {
		Day test1 = new Day(1);	
		assertTrue(test1.getDayNum() == 1);
		Day test2 = new Day(2);
		assertTrue(test2.getDayNum() == 2);
		Rental testRent1 = new Rental(85, test1, test2, "Chevrolet", "Tahoe");
		
		test1.addAdjacent(testRent1);
		assertTrue(test1.getNumAdjacent() == 1);
		assertTrue(test1.getAdjacent().getModel().equals("Tahoe"));
		test1.setBestRental(testRent1);
		assertTrue(test1.getBestRental().getCost() == 85);
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.Day#queryString()}.
	 */
	@Test
	public void testQueryString() {
		String testStringNone = "Available rentals for day 1\n   No rentals available.\n]";
		Day test1 = new Day(1);	
		assertTrue(test1.getDayNum() == 1);
		if( !test1.queryString().equals(testStringNone) )
			fail("Strings do not match");
		Day test2 = new Day(2);
		assertTrue(test2.getDayNum() == 2);
		Rental testRent1 = new Rental(85, test1, test2, "Chevrolet", "Tahoe");		
		String testString1 = "Available rentals for day 1\n"
				+ "   $85.00 Chevrolet Tahoe for day 1 to day 2"
				+ "\n]";
		test1.addAdjacent(testRent1);
		System.out.println(test1.queryString());
		System.out.println(testString1);
		if( !test1.queryString().equals(testString1) )
			fail("Strings do not match");
	}

}
