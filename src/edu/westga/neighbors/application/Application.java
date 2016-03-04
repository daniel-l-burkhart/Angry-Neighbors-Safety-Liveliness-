
package edu.westga.neighbors.application;

import edu.westga.neighbors.controller.AngryNeighborsController;

/**
 * The Class Application.
 */
public class Application {

	/**
	 * The main method.
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
