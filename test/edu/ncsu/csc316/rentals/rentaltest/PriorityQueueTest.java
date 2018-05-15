/**
 * 
 */
package edu.ncsu.csc316.rentals.rentaltest;

import static org.junit.Assert.*;

import org.junit.Test;

import edu.ncsu.csc316.rentals.rental.Day;
import edu.ncsu.csc316.rentals.rental.PriorityQueue;

/**
 * Priority Queue Test Class
 * @author Ryan Buchanan
 *
 */
public class PriorityQueueTest {
	private PriorityQueue pq;

	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.PriorityQueue#PriorityQueue()}.
	 */
	@Test
	public void testPriorityQueue() { 
		pq = new PriorityQueue();
		if(pq == null)
			fail("Creation Failed"); 
		assertTrue(pq.getSize() == 0);
	}
	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.PriorityQueue#deleteMin()}.
	 */
	@Test
	public void testPoll() {
		pq = new PriorityQueue();
		Day test1 = new Day(1);
		test1.setWeight(5);
		Day test2 = new Day(2);
		test2.setWeight(4);
		Day test3 = new Day(3);
		test3.setWeight(3);
		Day test4 = new Day(4);
		test4.setWeight(2);
		Day test5 = new Day(5);	
		test5.setWeight(1);
		pq.add(test5);
		pq.add(test4);	
		pq.add(test3);
		pq.add(test2);	
		pq.add(test1);
		assertTrue(pq.deleteMin().getWeight() == 1);
		assertTrue(pq.deleteMin().getWeight() == 2);
		assertTrue(pq.deleteMin().getWeight() == 3);
		assertTrue(pq.deleteMin().getWeight() == 4);
		assertTrue(pq.deleteMin().getWeight() == 5);
		/*Rental testRent1 = new Rental(5, test1, test2, "Chevrolet", "Tahoe");
		Rental testRent2 = new Rental(18, test1, test3, "Chevrolet", "Silverado");
		Rental testRent3 = new Rental(25, test1, test4, "Toyota", "Prius");
		Rental testRent4 = new Rental(50, test1, test5, "Honda", "CRV");
		Rental testRent5 = new Rental(45, test2, test3, "Jeep", "Compass");
		Rental testRent6 = new Rental(90, test2, test4, "Jeep", "Cherokee");
		Rental testRent7 = new Rental(220, test2, test5, "Ford", "Explorer");
		Rental testRent8 = new Rental(50, test4, test5, "Honda", "Accord");
		Rental testRent9 = new Rental(55, test3, test4, "Kia", "Soul");
		Rental testRent10 = new Rental(90, test3, test5, "Ford", "Explorer");
		pq.add(testRent10);
		pq.add(testRent9);
		pq.add(testRent8);
		pq.add(testRent7);
		pq.add(testRent6);

		assertTrue(pq.deleteMin().get == 5);
		assertTrue(pq.deleteMin().getCost() == 18);
		assertTrue(pq.deleteMin().getCost() == 25);
		assertTrue(pq.deleteMin().getCost() == 45);
		assertTrue(pq.deleteMin().getCost() == 50);
		assertTrue(pq.deleteMin().getCost() == 50);
		assertTrue(pq.deleteMin().getCost() == 55);'*/
	}
	
	/**
	 * Test method for {@link edu.ncsu.csc316.rentals.rental.PriorityQueue#add(edu.ncsu.csc316.rentals.rental.Rental)}.
	 */
	@Test
	public void testAddAndPeekAndUpdate() {
		pq = new PriorityQueue();
		Day test1 = new Day(1);
		test1.setWeight(15);
		Day test2 = new Day(2);
		test2.setWeight(14);
		Day test3 = new Day(3);
		test3.setWeight(13);
		Day test4 = new Day(4);
		test4.setWeight(12);
		Day test5 = new Day(5);	
		test5.setWeight(11);
		Day test6 = new Day(6);	
		test6.setWeight(9);
		Day test7 = new Day(7);
		test7.setWeight(8);
		Day test8 = new Day(8);
		test8.setWeight(7);
		Day test9 = new Day(9);
		test9.setWeight(6);
		Day test10 = new Day(10);
		test10.setWeight(5);
		pq.add(test10);
		assertTrue(pq.peek().getWeight() == 5);
		pq.add(test9);
		assertTrue(pq.peek().getWeight() == 5);
		pq.add(test8);
		assertTrue(pq.peek().getWeight() == 5);
		pq.add(test7);
		assertTrue(pq.peek().getWeight() == 5);
		pq.add(test6);
		pq.add(test5);
		assertTrue(pq.peek().getWeight() == 5);
		pq.add(test4);
		pq.add(test3);
		pq.add(test2);
		assertTrue(pq.peek().getWeight() == 5);
		pq.add(test1);
		assertTrue(pq.peek().getWeight() == 5);
		//Ensure Capacity
		Day test11 = new Day(11);	
		test11.setWeight(4);
		Day test12 = new Day(12);
		test12.setWeight(3);
		Day test13 = new Day(13);
		test13.setWeight(2);
		Day test14 = new Day(14);
		test14.setWeight(1);
		Day test15 = new Day(15);	
		test15.setWeight(0);
		pq.add(test11);
		assertTrue(pq.peek().getWeight() == 4);
		pq.add(test12);
		assertTrue(pq.peek().getWeight() == 3);
		pq.add(test13);
		assertTrue(pq.peek().getWeight() == 2);
		pq.add(test14);
		assertTrue(pq.peek().getWeight() == 1);
		pq.add(test15);
		assertTrue(pq.peek().getWeight() == 0);
		//Update Method
		pq.updatePriority(test15, 42);
		assertTrue(pq.peek().getWeight() == 1);
		pq.updatePriority(test14, 42); 
		assertTrue(pq.peek().getWeight() == 2);
		pq.updatePriority(test13, 42);
		assertTrue(pq.peek().getWeight() == 3);
	}

}
