/**
 * 
 */
package edu.ncsu.csc316.rentals.managertest;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.rentals.manager.VehicleRentalManagerIO;
import edu.ncsu.csc316.rentals.rental.Day;
import edu.ncsu.csc316.rentals.rental.Rental;
import edu.ncsu.csc316.rentals.rental.RentalsGraph;

/**
 * Test class for the IO functionality.
 * @author Ryan Buchanan
 *
 */
public class VehicleRentalManagerIOTest {
	VehicleRentalManagerIO ioTester;

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.manager.VehicleRentalManagerIO#loadRentalsFile(edu.ncsu.csc316.rentals.rental.RentalsGraph, java.lang.String)}.
	 */
	@Test
	public void testLoadRentalsFile() {
		ioTester = new VehicleRentalManagerIO();
		RentalsGraph graph = new RentalsGraph();		
		graph = ioTester.loadRentalsFile(graph, "input/sample.csv");
		if(graph == null)
			fail("Not yet implemented");
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
		Rental testRent5 = new Rental(65, test2, test3, "Jeep", "Compass");
		Rental testRent6 = new Rental(90, test2, test4, "Jeep", "Cherokee");
		Rental testRent7 = new Rental(220, test2, test5, "Ford", "Explorer");
		test2.addAdjacent(testRent5);
		test2.addAdjacent(testRent6);
		test2.addAdjacent(testRent7);
		Rental testRent8 = new Rental(50, test4, test5, "Honda", "Accord");
		test3.addAdjacent(testRent8);
		Rental testRent9 = new Rental(55, test3, test4, "Kia", "Soul");
		Rental testRent10 = new Rental(90, test3, test5, "Ford", "Explorer");
		test4.addAdjacent(testRent10);
		test4.addAdjacent(testRent9);
		
		assertTrue(graph.lookUp(1).getAdjacent().getModel().equals(testRent1.getModel()));
		assertTrue(graph.lookUp(2).getAdjacent().getModel().equals(testRent5.getModel()));
		assertTrue(graph.lookUp(4).getAdjacent().getModel().equals(testRent8.getModel()));
		assertTrue(graph.lookUp(3).getAdjacent().getModel().equals(testRent9.getModel()));
	}
	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.manager.VehicleRentalManagerIO#loadRentalsFile(edu.ncsu.csc316.rentals.rental.RentalsGraph, java.lang.String)}.
	 */
	@Test
	public void testLoadRentalsFile2() {
		ioTester = new VehicleRentalManagerIO();
		RentalsGraph graph = new RentalsGraph();		
		graph = ioTester.loadRentalsFile(graph, "input/sample2.csv");
		if(graph == null)
			fail("Not yet implemented");
		
	}
	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.manager.VehicleRentalManagerIO#loadRentalsFile(edu.ncsu.csc316.rentals.rental.RentalsGraph, java.lang.String)}.
	 */
	@Test
	public void testBadLoadRentalsFile() {
		ioTester = new VehicleRentalManagerIO();
		RentalsGraph graph = new RentalsGraph();
		
		graph = ioTester.loadRentalsFile(graph, "input/bad.csv");
		if(graph != null)
			fail("Not yet implemented");
	}
}
