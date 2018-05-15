/**
 * 
 */
package edu.ncsu.csc316.rentals.rental;

import java.util.Arrays;

/**
 * The RentalsGraph acts as an adjacency list
 * @author Ryan Buchanan
 *
 */
public class RentalsGraph {
	private Day[] days;
	private int capacity = 10;
	private int size;
	/**
	 * Constructor
	 */
	public RentalsGraph() {
		size = 0;
		days = new Day[capacity];
	}
	/**
	 * Adds a day to the array, and increments size.
	 * @param day Day
	 * @return true/false boolean
	 */
	public boolean addDay(Day day){
		ensureCapacity();
		
		if(day == null)
			return false;
		
		days[size++] = day;
		return true;
	}
	/**
	 * Ensures the capacity so that the Days array does not overflow.
	 */
	private void ensureCapacity(){
		if( size == capacity ){ 
			capacity *= 2;
			days = Arrays.copyOf(days, capacity);
		} 
	} 
	/**
	 * Find and return the given day.
	 * @param dayNum number of the day
	 * @return Day object
	 */
	public Day lookUp(int dayNum){
		//if( dayNum >= size )
			//return null;
		for(int i = 0; i < size; i++){
			if( days[i].getDayNum() == dayNum )
				return days[i];
		}
		return null; 
	}
	/**
	 * Returns the size of the current graph.
	 * @return size
	 */
	public int getSize(){
		return size;
	}
	/**
	 * Get day by index
	 * @param index index
	 * @return days[index]
	 */
	public Day getDay(int index){
		if(index >= size)
			return null;
		return days[index];
	}
	/**
	 * Returns a string of the list.
	 * @return StringBuilder of the list
	 *
	public String toString(){ 
		StringBuilder builder = new StringBuilder();
		for(int i = 0; i < size; i++){
			builder.append(days[i].toString() + "\n");
		}
		return builder.toString();
	}
	*/
}
