/**
 * 
 */
package edu.ncsu.csc316.rentals.manager;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import edu.ncsu.csc316.rentals.rental.Day;
import edu.ncsu.csc316.rentals.rental.Rental;
import edu.ncsu.csc316.rentals.rental.RentalsGraph;

/**
 * Rental manager file reader
 * @author Ryan Buchanan
 *
 */
public class VehicleRentalManagerIO {
	
	/**
	 * Load the input file. If the starting day does not exist, create it and add the rental as
	 * an adjacent Rental. If it does exist, simply find it and add the new rental to the list
	 * of adjacent rental objects.
	 * 
	 * @param graph empty graph to fill
	 * @param filename file path 
	 * @return Return a full graph, based on the input file
	 */
	public RentalsGraph loadRentalsFile(RentalsGraph graph, String filename ){
		BufferedReader lineReader;
		String line = null;
		
		try {
			lineReader = new BufferedReader( new FileReader(filename) );			
			lineReader.readLine(); //skip first line
			
			while( (line = lineReader.readLine()) != null  ){
				String[] lineArray = line.split(",");
				int sDay = Integer.parseInt(lineArray[0]);
				int eDay = Integer.parseInt(lineArray[1]);
				int cost = Integer.parseInt(lineArray[2]);
				String make = lineArray[3];
				String model = lineArray[4];
				
				//System.out.println("Day " + sDay + " to Day " + eDay + ": " +
						//"Cost = " + cost + " Car = " + make + " " + model);	
				
				Day newSDay = graph.lookUp(sDay);
				Day newEDay = graph.lookUp(eDay);
				
				//If the start day doesn't exist, create it and add it.
				if( newSDay  == null ){
					newSDay = new Day(sDay);
					graph.addDay(newSDay);
				}
				
				//If the ending day doesn't exist, create it and add it.
				if( newEDay == null ){
					newEDay = new Day(eDay);
					graph.addDay(newEDay);  
				}
				//Create the new rental object, and add it to the adjacency list of the start day
				newSDay.addAdjacent( new Rental(cost, newSDay, newEDay, make, model) );
				
			}
			//System.out.println( graph.toString() );
			lineReader.close();
		} catch (IOException e) {	 
			System.out.println("Failed to load");
			return null;
		}
		return graph;		
	}

}
