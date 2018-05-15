/**
 * 
 */
package edu.ncsu.csc316.rentals.manager;

import edu.ncsu.csc316.rentals.rental.Day;
import edu.ncsu.csc316.rentals.rental.PriorityQueue;
import edu.ncsu.csc316.rentals.rental.Rental;
import edu.ncsu.csc316.rentals.rental.RentalsGraph;

/**
 * This is the manager for the system that controls
 *  the interaction between the data and the user.
 * @author Ryan Buchanan
 *
 */
public class VehicleRentalManager {
	
	private RentalsGraph graph;
	private VehicleRentalManagerIO fileIO;
	/**
	 * Constructs a new Rental manager with the given input files
	 * 
	 * @param pathToFile
	 *            - the path to the employee input file
	 */
	public VehicleRentalManager(String pathToFile) {
		graph = new RentalsGraph();
		fileIO = new VehicleRentalManagerIO();
		
		graph = fileIO.loadRentalsFile(graph, pathToFile);
	} 

	/**
	 * Returns the String representation of the rentals that
	 * minimize the total cost from the start day to the end day
	 * (or for as many days from the start day while rentals are possible).
	 * 
	 * @param start - the start day as an integer
	 * @param end - the end day as an integer
	 * @return the String representation of the rentals
	 */
	public String getRentals(int start, int end) {
		//Dijkstra's Algorithm
		PriorityQueue que = new PriorityQueue();
		//Initialize the queue and the starting vertex
		for(int i = 0; i < graph.getSize(); i++){
			if(graph.getDay(i).getDayNum() == start)
				graph.getDay(i).setWeight(0); //Starting vertex
			else
				graph.getDay(i).setWeight(Integer.MAX_VALUE / 2); //all others
			graph.getDay(i).setFound(false);
			graph.getDay(i).setParent(null);
			que.add(graph.getDay(i)); //insert
		}
		//Move through the incident edges
		while(!que.isEmpty()){
			Day temp = que.deleteMin();
			temp.setFound(true);
			Rental trav = temp.getAdjacent();
			while(trav != null){
				//Opposite vertex
				Day opp = trav.geteDay();
				// weight + distance
				int rate = temp.getWeight() + trav.getCost();
				if( rate < opp.getWeight()){
					opp.setWeight(rate);
					opp.setParent(temp);
					opp.setBestRental(trav);
					que.updatePriority(opp, rate);
				}
				trav = trav.getNextAdjacent();
			}
		}
		//Get the proper string
		StringBuilder builder = new StringBuilder();

		int numAbove = 0;
		Day ret;
		//Handles all values that are above the size of the graph
		if(end > graph.getSize()){
			numAbove = end - graph.getSize();
			ret = graph.lookUp(end - numAbove);
		} else{
			ret = graph.lookUp(end);
		}
		int size = end - start + 1;
		Rental[] reverser = new Rental[size];	
		int count = 0;	
		int total = 0;
		//Go backwards through the list until we reach the starting day
		while(ret.getParent() != null){
			if(ret.getBestRental() == null){
				reverser[count++] = new Rental(-1, ret, null, null, null);
				ret = ret.getParent();
				continue;
			}
			total += ( ret.getWeight() - ret.getParent().getWeight() );
			reverser[count++] = ret.getBestRental(); 
			ret = ret.getParent();
		}
		//Start to build the string.
		builder.append("Rental total is $" + String.format( "%.2f", (double)total ) + "\n");
		builder.append("[\n");
		for(int i = count - 1; i >= 0; i--){
			if(reverser[i].getCost() == -1){
				builder.append("   No rentals available on day " + reverser[i].getsDay() + "\n");
			}
			Rental rent = reverser[i];
			builder.append("   From day " + rent.getsDay().getDayNum() + " to day " + rent.geteDay().getDayNum() + ": $");
			builder.append(String.format( "%.2f", (double)rent.getCost() ) + ", ");
			builder.append(rent.getMake() + " " + rent.getModel() + "\n");
		}
		if(numAbove > 0){
			for(int k = 1; k <= numAbove; k++)
				builder.append("   No rentals available on day " + (k + graph.getSize()) + "\n");
		}
		builder.append("]");
	
		return builder.toString();  
	}
	/**
	 * Returns the String representation of the rentals 
	 * that are available for the requested day.
	 * 
	 * @param start - the day for which to retrieve available rentals
	 * @return the String representation of the rentals
	 */
	public String getRentalsForDay(int start) {
		return graph.lookUp(start).queryString();
	}
}
