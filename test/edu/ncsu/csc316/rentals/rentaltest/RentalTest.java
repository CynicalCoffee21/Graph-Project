/**
 * 
 */
package edu.ncsu.csc316.rentals.rentaltest;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.rentals.rental.Day;
import edu.ncsu.csc316.rentals.rental.Rental;

/**
 * Test for the rental object
 * @author Ryan Buchanan
 *
 */
public class RentalTest {

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.Rental#Rental(int, edu.ncsu.csc316.rentals.rental.Day, edu.ncsu.csc316.rentals.rental.Day, java.lang.String, java.lang.String)}.
	 */
	@Test
	public void testRental() {
		Day test1 = new Day(1);		
		Day test2 = new Day(2);
	
		Rental testRent1 = new Rental(85, test1, test2, "Chevrolet", "Tahoe");

		assertTrue(testRent1.getMake().equals("Chevrolet"));
		assertTrue(testRent1.getModel().equals("Tahoe"));
		assertTrue(testRent1.getCost() == 85);
		assertTrue(testRent1.geteDay().getDayNum() == 2);
		assertTrue(testRent1.getsDay().getDayNum() == 1);
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.Rental#getCost()}.
	 */
	@Test
	public void testGetCost() {
		Day test1 = new Day(1);		
		Day test2 = new Day(2);	
		Rental testRent1 = new Rental(85, test1, test2, "Chevrolet", "Tahoe");
		Rental testRent2 = new Rental(555, test2, test1, "Chevrolet", "Tahoe");
		assertTrue(testRent1.getCost() == 85);
		assertTrue(testRent2.getCost() == 555);
		assertFalse(testRent2.getCost() == 85);
		assertFalse(testRent1.getCost() == 555);
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.Rental#geteDay()}.
	 */
	@Test
	public void testGeteDay() {
		Day test1 = new Day(1);		
		Day test2 = new Day(2);	
		Rental testRent1 = new Rental(85, test1, test2, "Chevrolet", "Tahoe");
		Rental testRent2 = new Rental(555, test2, test1, "Chevrolet", "Tahoe");
		assertTrue(testRent1.geteDay().getDayNum() == 2);
		assertTrue(testRent2.geteDay().getDayNum() == 1);
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.Rental#getMake()}.
	 */
	@Test
	public void testGetMake() {
		Day test1 = new Day(1);		
		Day test2 = new Day(2);	
		Rental testRent1 = new Rental(85, test1, test2, "Chevrolet", "Tahoe");
		Rental testRent2 = new Rental(555, test2, test1, "Chevrolet", "Tahoe");
		assertTrue(testRent1.getMake().equals("Chevrolet"));
		assertTrue(testRent2.getMake().equals("Chevrolet"));
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.Rental#getModel()}.
	 */
	@Test
	public void testGetModel() {
		Day test1 = new Day(1);		
		Day test2 = new Day(2);	
		Rental testRent1 = new Rental(85, test1, test2, "Chevrolet", "Tahoe");
		Rental testRent2 = new Rental(555, test2, test1, "Chevrolet", "Tahoe");
		assertTrue(testRent1.getModel().equals("Tahoe"));
		assertTrue(testRent2.getModel().equals("Tahoe"));
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.Rental#getsDay()}.
	 */
	@Test
	public void testGetsDay() {
		Day test1 = new Day(1);		
		Day test2 = new Day(2);	
		Rental testRent1 = new Rental(85, test1, test2, "Chevrolet", "Tahoe");
		Rental testRent2 = new Rental(555, test2, test1, "Chevrolet", "Tahoe");
		assertTrue(testRent1.getsDay().getDayNum() == 1);
		assertTrue(testRent2.getsDay().getDayNum() == 2);
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.Rental#getNextAdjacent()}.
	 */
	@Test
	public void testGetNextAdjacent() {
		Day test1 = new Day(1);		
		Day test2 = new Day(2);	
		Rental testRent1 = new Rental(85, test1, test2, "Chevrolet", "Tahoe");
		Rental testRent2 = new Rental(555, test2, test1, "Chevrolet", "Tahoe");

		testRent1.setNextAdjacent(testRent2);
		assertTrue(testRent1.getNextAdjacent().getCost() == 555);
		assertTrue(testRent2.getNextAdjacent() == null);
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.Rental#setNextAdjacent(edu.ncsu.csc316.rentals.rental.Rental)}.
	 */
	@Test
	public void testSetNextAdjacent() {
		Day test1 = new Day(1);		
		Day test2 = new Day(2);	
		Rental testRent1 = new Rental(85, test1, test2, "Chevrolet", "Tahoe");
		Rental testRent2 = new Rental(555, test2, test1, "Chevrolet", "Tahoe");

		testRent1.setNextAdjacent(testRent2);
		assertTrue(testRent1.getNextAdjacent().getCost() == 555);
		assertTrue(testRent2.getNextAdjacent() == null);
	}

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.Rental#toString()}.
	 */
	@Test
	public void testToString() {
		Day test1 = new Day(1);		
		Day test2 = new Day(2);	
		Rental testRent1 = new Rental(85, test1, test2, "Chevrolet", "Tahoe");
		Rental testRent2 = new Rental(555, test2, test1, "Chevrolet", "Tahoe");
		String testString1 = "[ 1 to 2, Cost = 85, Car = Chevrolet Tahoe ]";
		String testString2 = "[ 2 to 1, Cost = 555, Car = Chevrolet Tahoe ]";
		assertTrue(testRent1.toString().equals(testString1));
		assertTrue(testRent2.toString().equals(testString2));
	}

}
