/**
 * 
 */
package edu.ncsu.csc316.rentals.rental;

/**
 * The Rental acts as an Edge object for a graph
 * @author Ryan Buchanan
 *
 */
public class Rental {
	private int cost;
	private Day sDay; //Acts as Vertex 1, and acts as a root to jump back to.
	private Day eDay; //Acts as Vertex 2
	private String make;
	private String model;
	private Rental nextAdjacent; //The next connected Rental(Edge) to the original Day(Vertex)
	/**
	 * Rental Constructor
	 * @param cost rental cost
	 * @param sday start day
	 * @param eday end day
	 * @param make make of the car
	 * @param model model of the car
	 */
	public Rental(int cost, Day sday, Day eday, String make, String model) {
		setCost(cost);
		setsDay(sday);
		seteDay(eday);
		setMake(make); 
		setModel(model);
	}
	/**
	 * returns the cost
	 * @return the cost
	 */
	public int getCost() {
		return cost;
	}
	/**
	 * sets the cost
	 * @param cost the cost to set
	 */
	private void setCost(int cost) {
		this.cost = cost;
	}
	/**
	 * gets the end day
	 * @return the eDay
	 */
	public Day geteDay() {
		return eDay;
	}
	/**
	 * sets the end day
	 * @param eday2 the eDay to set
	 */
	private void seteDay(Day eday2) {
		this.eDay = eday2;
	}
	/**
	 * returns the make
	 * @return the make
	 */
	public String getMake() {
		return make;
	}
	/**
	 * sets the make
	 * @param make the make to set
	 */
	private void setMake(String make) {
		this.make = make;
	}
	/**
	 * return the model
	 * @return the model
	 */
	public String getModel() {
		return model;
	}
	/**
	 * sets the model
	 * @param model the model to set
	 */
	private void setModel(String model) {
		this.model = model;
	}
	/**
	 * return the sDay
	 * @return the sDay
	 */
	public Day getsDay() {
		return sDay;
	}
	/**
	 * sets the sDay
	 * @param sDay the sDay to set
	 */
	private void setsDay(Day sDay) {
		this.sDay = sDay;
	}
	/**
	 * returns the nextAdjacent
	 * @return the nextAdjacent
	 */
	public Rental getNextAdjacent() {
		return nextAdjacent;
	}
	/**
	 * sets the nextAdjacent
	 * @param nextAdjacent the nextAdjacent to set
	 */
	public void setNextAdjacent(Rental nextAdjacent) {
		this.nextAdjacent = nextAdjacent;
	}
	/**
	 * Returns a string of the rental.
	 * @return the string of the rental object
	 */
	public String toString(){
		StringBuilder builder = new StringBuilder();
		builder.append("[ ");
		builder.append(sDay.getDayNum() + " to " + eDay.getDayNum() + ", ");
		builder.append("Cost = " + cost + ", ");
		builder.append("Car = " + make + " " + model);
		builder.append(" ]");
		return builder.toString();
	}
}
