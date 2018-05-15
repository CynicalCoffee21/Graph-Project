/**
 * 
 */
package edu.ncsu.csc316.rentals.rental;

/**
 * The Day acts as a Vertex object in graph
 * @author Ryan Buchanan
 *
 */
public class Day {
	private boolean found = false;
	private int weight = -1;
	private Day parent = null;
	
	private int dayNum;
	//Linked List of Rental Objects that act as Edges,
	//for the Day objects that act as vertices.
	int numAdjacent = 0;
	private Rental adjacent;
	private Rental bestRental;
	/**
	 * Constructor
	 * @param dayNum the day number
	 */
	public Day(int dayNum) {
		setDayNum(dayNum);
	}
	/**
	 * adds an adjacent rental object
	 * @param rental Rental object
	 */
	public void addAdjacent(Rental rental){
		//If the list is empty, set the root
		if( adjacent == null ){
			adjacent = rental;
			numAdjacent++;
			return;
		}
		Rental temp = adjacent;
		Rental prev = null;
		//Move through the list.
		while( (temp.getNextAdjacent() != null) &&  
				(rental.getCost() > temp.getCost())){
			prev = temp;
			temp = temp.getNextAdjacent();
		}
		//If we reach the end, insert at the end
		if(temp.getNextAdjacent() == null){
			if(temp.getCost() <= rental.getCost()){
				temp.setNextAdjacent(rental);
				numAdjacent++;
				return;
			}
			if( numAdjacent == 1 ){
				rental.setNextAdjacent(temp);
				adjacent = rental;
				numAdjacent++;
				return;
			}
		}
		if( temp.equals(adjacent) ){
			rental.setNextAdjacent(temp);
			adjacent = rental;
			numAdjacent++;
			return;
		}
		//otherwise we are going to insert between two nodes
		rental.setNextAdjacent(temp);
		prev.setNextAdjacent(rental);
		numAdjacent++;
	}
	/**
	 * return the dayNum
	 * @return dayNum the number of the day
	 */
	public int getDayNum() {
		return dayNum;
	}
	/**
	 * sets the number (day)
	 * @param dayNum the dayNum to set
	 */
	private void setDayNum(int dayNum) {
		this.dayNum = dayNum;
	}
	/**
	 * returns the root adjacent (edge)
	 * @return adjacent Rental
	 */
	public Rental getAdjacent() {
		return adjacent;
	}
	/**
	 * Returns a string version of the day object, and its adjacent rentals list.
	 * @return returns the string version of the adjacency list and the day number
	 *
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Day number = ");
		builder.append(getDayNum());
		
		if( adjacent == null ){
			return builder.toString();
		}
		
		Rental temp = adjacent;
		//Move through the list.
		while( temp != null ){
			builder.append(" --> " + temp.toString());
			temp = temp.getNextAdjacent();
		}
		return builder.toString();
	}*/
	/**
	 * Returns a string version of the day object, and its adjacent rentals list.
	 * 
	 * Available Rentals for day 1
	 * [
	 *  $85.00 Chevrolet Tahoe for day 1 to day 2
	 *  $180.00 Chevrolet Silverado for day 1 to day 3
	 *  $255.00 Toyota Prius for day 1 to day 4
	 *  $500.00 Honda CRV for day 1 to day 5
	 * ]
	 * 
	 * @return returns the string version of the adjacency list and the day number
	 */
	public String queryString(){
		StringBuilder builder = new StringBuilder();
		builder.append("Available rentals for day ");
		builder.append(getDayNum() + "\n");
		//builder.append("[\n");
		if( adjacent == null ){
			builder.append("   No rentals available.\n");
			builder.append("]");
			return builder.toString();
		}
		
		Rental temp = adjacent;
		//Move through the list and add each rental to the string.
		while( temp != null ){
			builder.append("   $");
			builder.append(String.format( "%.2f", (double)temp.getCost() ));
			builder.append(" ");
			builder.append(temp.getMake()); 
			builder.append(" ");
			builder.append(temp.getModel());
			builder.append(" for day ");
			builder.append(temp.getsDay().getDayNum());
			builder.append(" to day ");
			builder.append(temp.geteDay().getDayNum());
			builder.append("\n");
			temp = temp.getNextAdjacent();
		}
		builder.append("]");
		return builder.toString();
	}
	/**
	 * Returns num adj.
	 * @return number of adjacent
	 */
	public int getNumAdjacent(){
		return numAdjacent;
	}
	/**
	 * checks found
	 * @return the found
	 */
	public boolean isFound() {
		return found;
	}
	/**
	 * sets found
	 * @param found the found to set
	 */
	public void setFound(boolean found) {
		this.found = found;
	}
	/**
	 * gets weight
	 * @return the weight
	 */
	public int getWeight() {
		return weight;
	}
	/**
	 * sets weight
	 * @param weight the weight to set
	 */
	public void setWeight(int weight) {
		this.weight = weight; 
	}
	/**
	 * gets parent
	 * @return the parent
	 */
	public Day getParent() {
		return parent;
	}
	/**
	 * sets parent
	 * @param parent the parent to set
	 */
	public void setParent(Day parent) {
		this.parent = parent;
	}
	/**
	 * bestRental setter
	 * @param trav traversal
	 */
	public void setBestRental(Rental trav) {
		this.bestRental = trav;	
	}
	/**
	 * bestRental getter
	 * @return bestRental
	 */
	public Rental getBestRental(){
		if(bestRental == null)
			return null;
		return bestRental;
	}
}
