package edu.westga.neighbors.controller;

import edu.westga.neighbors.model.Field;
import edu.westga.neighbors.model.Neighbor;
import edu.westga.neighbors.model.Peterson;

/**
 * The controller between our main and our model.
 * 
 * @author Daniel Burkhart
 * @version Spring 2016
 */
public class AngryNeighborsController {

	private Field field;
	private Peterson peterson;
	private Neighbor maryNeighbor;
	private Neighbor elizabethNeighbor;
	private Thread maryThread;
	private Thread elizabethThread;

	/**
	 * Instantiates a new angry neighbors controller.
	 * 
	 * @precondition: None
	 * @postcondition: A controller object is made
	 */
	public AngryNeighborsController() {

		this.field = new Field();
		this.peterson = new Peterson();

		this.maryNeighbor = new Neighbor("Mary, Queen of Scots", field, peterson, 1);
		this.elizabethNeighbor = new Neighbor("Elizabeth I", field, peterson, 2);

		this.maryNeighbor.setNeighbor(elizabethNeighbor);
		this.elizabethNeighbor.setNeighbor(maryNeighbor);

		this.maryThread = new Thread(this.maryNeighbor);
		this.elizabethThread = new Thread(this.elizabethNeighbor);

	}

	/**
	 * Opens field for business.
	 * 
	 * @precondition: None
	 * @postcondition: The field is open
	 */
	public void openField() {

		this.startThreads();

		this.waitForTenSeconds();

		this.stopThreads();

	}

	/**
	 * Starts the threads.
	 * 
	 * @precondition: None
	 * @postcondition: The threads started
	 */
	private void startThreads() {
		this.maryThread.start();
		this.elizabethThread.start();
	}

	/**
	 * Calls thread.sleep for 10 seconds to let the threads execute for that
	 * time.
	 * 
	 * @precondition: None
	 * @postcondition: The threads run for 10 seconds
	 */
	private void waitForTenSeconds() {
		try {
			Thread.sleep(10 * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Stops the threads.
	 * 
	 * @precondition: None.
	 * @postcondition: The threads stop
	 */
	private void stopThreads() {
		this.maryNeighbor.stop();
		this.elizabethNeighbor.stop();
	}

}
