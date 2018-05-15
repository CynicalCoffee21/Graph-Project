/**
 * 
 */
package edu.ncsu.csc316.rentals.rental;

import java.util.Arrays;

/**
 * The PriorityQueue uses Min-Heap behavior to help
 * the adjacency list (Rentals Graph) do it's job.
 * 
 * Much of this class is not original to me.
 * 
 * 	I got most of the methods and logic form this video:
 *  https://www.youtube.com/watch?v=t0Cq6tVNRBA&index=16&t=1s&list=WL
 * 
 * @author Ryan Buchanan
 *
 */
public class PriorityQueue {
	private int capacity = 10;
	private int size;
	private Day[] days;
	/**
	 * Constructor
	 */
	public PriorityQueue() { 
		days = new Day[capacity];
		size = 0;
	}
	/**
	 * Returns size
	 * @return size
	 */
	public int getSize(){
		return size;
	}
	/**
	 * Returns the left child index
	 * @param parIndex
	 * @return left child index
	 */
	private int getLeftIndex(int parIndex){ 
		return 2 * parIndex + 1;
	}
	/**
	 * Returns right child index
	 * @param parIndex
	 * @return right child index
	 */
	private int getRightIndex(int parIndex){
		return 2 * parIndex + 2;
	}
	/**
	 * Returns parent index
	 * @param kiddo
	 * @return parent index
	 */
	private int getParIndex(int kiddo){
		return (kiddo - 1) / 2;
	}
	/**
	 * tells if a node has a left child
	 * @param index
	 * @return true/false
	 */
	private boolean hasLeftChild(int index){
		return getLeftIndex(index) < size;
	}
	/**
	 * tells if a node has a right child
	 * @param index
	 * @return true/false
	 */
	private boolean hasRightChild(int index){
		return getRightIndex(index) < size;
	}
	/**
	 * checks if parent exists
	 * @param index
	 * @return true/false
	 */
	private boolean hasParent(int index){
		return getParIndex(index) >= 0;
	}
	/**
	 * Returns the left child
	 * @param index
	 * @return the left child
	 */
	private Day leftChild(int index){
		return days[getLeftIndex(index)];
	}
	/**
	 * Returns the right child
	 * @param index
	 * @return the right child
	 */
	private Day rightChild(int index){
		return days[getRightIndex(index)];
	}
	/**
	 * Returns the parent node
	 * @param index
	 * @return the parent
	 */
	private Day getParent(int index){
		return days[getParIndex(index)];
	}
	/**
	 * Swaps two items
	 * @param indexOne 
	 * @param indexTwo
	 */
	private void swap(int indexOne, int indexTwo){
		Day temp = days[indexOne];
		days[indexOne] = days[indexTwo];
		days[indexTwo] = temp;
	}
	/**
	 * Ensures array size
	 */
	private void ensureCapacity(){
		if(size >= capacity){
			capacity *= 2;
			days = Arrays.copyOf(days, capacity);			
		}
	} 
	/**
	 * Returns the top day of the heap
	 * @return first index in the list
	 */
	public Day peek(){ 
		if( size == 0 ) 
			throw new IllegalStateException();
		return days[0];
	}
	/**
	 * Checks if the queue is empty
	 * @return true/false
	 */
	public boolean isEmpty(){
		if(size == 0)
			return true;
		return false;
	}
	/**
	 * Adds the new weight to the given day, then reorganizes
	 * @param day Day
	 * @param newWeight wieght
	 */
	public void updatePriority(Day day, int newWeight){
		for(int i = 0; i < size; i++)
			if(days[i].getDayNum() == day.getDayNum()){
				days[i].setWeight(newWeight);
				break;
			}
		heapifyDown();
	}
	/**
	 * Remove the top and replace it with the bottom index
	 * @return top index
	 */
	public Day deleteMin(){
		if( size == 0 ) 
			throw new IllegalStateException();
		Day rent = days[0];
		days[0] = days[size - 1];
		size--;
		heapifyDown();
		return rent;
	}
	/**
	 * adds a day to the back of the list
	 * @param day Day
	 */
	public void add(Day day){
		ensureCapacity();
		days[size] = day;
		size++;
		heapifyUp();
	}
	/**
	 * Reorganizes the heap from the top down
	 */
	private void heapifyDown() {
		int index = 0;
		while(hasLeftChild(index)){
			int smaller = getLeftIndex(index);
			if(hasRightChild(index) && rightChild(index).getWeight() 
					< leftChild(index).getWeight()){
				smaller = getRightIndex(index);
			}
			if( days[index].getWeight() < days[smaller].getWeight()){
				break;
			} else {
				swap(index, smaller);
			}
			index = smaller;
		}
	}
	/**
	 * Reorganizes the heap from bottom up
	 */
	private void heapifyUp() {
		int index = size - 1;
		while(hasParent(index) && getParent(index).getWeight() 
				> days[index].getWeight()){
			swap(getParIndex(index), index);
			index = getParIndex(index);
		}
	}
}
