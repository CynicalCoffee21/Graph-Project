/**
 * 
 */
package edu.ncsu.csc316.rentals.managerui;

import java.io.File;
import java.util.Scanner;

import edu.ncsu.csc316.rentals.manager.VehicleRentalManager;

/**
 * This is the UI for the vehicle rental manager
 * @author Ryan Buchanan
 *
 */
public class VehicleRentalManagerUI {
	private static VehicleRentalManager vroom;
	/**
	 * The main method of the program that handles
	 * all of the user interface and interaction.
	 * @param args string array
	 */
	public static void main(String[] args){
		System.out.println("Welcome to the Vehicle Rental Manager. ");
		System.out.println(" ");
		Scanner input = new Scanner(System.in);	
		String inputFile;
		
		//Loop until user provides some from of valid input.
		while( true ){
			System.out.println("Please enter a valid rental file to continue (or 'exit' to quit): ");
			inputFile = input.nextLine();
			//If the user enters 'exit' the program exits
			if(inputFile.equals("exit")){
				System.out.println("Goodbye.");
				System.exit(0);
			}
			//Check for file validity
			else if(!(new File(inputFile).exists())){
				System.out.println("The given file path was invalid, please try again.");
				System.out.println(" ");
				continue;
			}
			break;
		}

		vroom = new VehicleRentalManager(inputFile); 
		main:
		while( true ) {
			String command = null;
			System.out.println(" ");
			System.out.println("Welcome to the vehicle rental manager main menu.");
			System.out.println("From here you may choose to: ");
			System.out.println("1) type 'exit' to exit.");
			System.out.println("2) type 'optimize' to generate the optimal rental sequence.");
			System.out.println("3) type 'query' to determine which rentals exist for a given day.");
			System.out.println(" ");
			command = input.nextLine();
			
			if( command.equals("exit") ){
				System.out.println("Goodbye.");
				break;
			} else if( command.equals("optimize") ){
				System.out.println("Please enter a start Day: ");
				int sDay = Integer.parseInt(input.nextLine());
				System.out.println("Please enter an end Day: ");
				int eDay = Integer.parseInt(input.nextLine());				
				System.out.println( vroom.getRentals(sDay, eDay) );				
				continue main;
			} else if( command.equals("query") ){
				System.out.println("Please enter a day to query: ");
				int qDay = Integer.parseInt(input.nextLine());
				System.out.println( vroom.getRentalsForDay(qDay) );
				continue main;
			} else {
				System.out.println("That was an invalid command, please try again.");
				continue main;
			}						
		}
		input.close();	
	}	
}
