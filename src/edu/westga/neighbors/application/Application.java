
package edu.westga.neighbors.application;

import edu.westga.neighbors.controller.AngryNeighborsController;

/**
 * The Application class that houses the main method.
 * 
 * @author Daniel Burkhart
 * @version Spring 2016
 */
public class Application {

	/**
	 * The main method that is the entry point of the program.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {

		AngryNeighborsController controller = new AngryNeighborsController();

		System.out.println("Begin");

		controller.openField();

		System.out.println("End");
	}

}
