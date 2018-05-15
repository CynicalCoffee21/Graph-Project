/**
 * 
 */
package edu.ncsu.csc316.rentals.managertest;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.rentals.manager.VehicleRentalManager;

/**
 * Test for Rental Manager
 * @author CynicalCoffe
 *
 */
public class VehicleRentalManagerTest {
	VehicleRentalManager vroom;
	/**
	 * Test
	 * Test method for {@link edu.ncsu.csc316.rentals.manager.VehicleRentalManager#VehicleRentalManager(java.lang.String)}.
	 */
	@Test
	public void testVehicleRentalManager() {
		vroom = new VehicleRentalManager("input/sample.csv");
		if(vroom == null)
			fail("Not yet implemented"); 
	}

	/**
	 * Test
	 * Test method for {@link edu.ncsu.csc316.rentals.manager.VehicleRentalManager#getRentals(int, int)}.
	 */
	@Test
	public void testGetRentals() {
		vroom = new VehicleRentalManager("input/sample.csv");
		if(vroom == null)
			fail("failed to make");
		String rentals1 = "Available rentals for day 1\n" +
				"   $85.00 Chevrolet Tahoe for day 1 to day 2\n" +
				"   $180.00 Chevrolet Silverado for day 1 to day 3\n" +
				"   $255.00 Toyota Prius for day 1 to day 4\n" +
				"   $500.00 Honda CRV for day 1 to day 5\n" +
				"]"; 
		//System.out.println(rentals1);
		//System.out.println(vroom.getRentalsForDay(1));
		assertTrue(rentals1.equals(vroom.getRentalsForDay(1)));
	}
	/**
	 * Test
	 * Test method for {@link edu.ncsu.csc316.rentals.manager.VehicleRentalManager#getRentals(int, int)}.
	 */
	@Test
	public void testGetRentalsForDay(){
		vroom = new VehicleRentalManager("input/sample.csv");
		if(vroom == null)
			fail("failed to make");
		assertTrue(vroom.getRentals(1, 2) != null);
	}

}
