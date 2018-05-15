/**
 * 
 */
package edu.ncsu.csc316.rentals.rentaltest;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.rentals.manager.VehicleRentalManagerIO;
import edu.ncsu.csc316.rentals.rental.Day;
import edu.ncsu.csc316.rentals.rental.Rental;
import edu.ncsu.csc316.rentals.rental.RentalsGraph;

/**
 * Rentals Graph test class
 * @author Ryan Buchanan
 *
 */
public class RentalsGraphTest { 
	/**
	 * Test
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.RentalsGraph#RentalsGraph()}.
	 */
	@Test
	public void testRentalsGraph() {
		VehicleRentalManagerIO ioTester = new VehicleRentalManagerIO();
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
	
		Day test6 = new Day(6);		
		Day test7 = new Day(7);
		Day test8 = new Day(8);
		Day test9 = new Day(9);
		Day test10 = new Day(10);	
		graph.addDay(test10);
		graph.addDay(test9);
		graph.addDay(test8);
		graph.addDay(test7); 
		graph.addDay(test6);
		//Check capacity
		graph.addDay(new Day(11));
		graph.addDay(new Day(12));
		graph.addDay(new Day(13));
		graph.addDay(new Day(14));
		graph.addDay(new Day(15));
	} 

}
