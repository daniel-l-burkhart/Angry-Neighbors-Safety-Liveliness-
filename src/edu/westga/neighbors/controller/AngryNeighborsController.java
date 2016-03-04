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
	private Neighbor firstNeighbor;
	private Neighbor secondNeighbor;
	private Thread firstThread;
	private Thread secondThread;

	/**
	 * Instantiates a new angry neighbors controller.
	 */
	public AngryNeighborsController() {

		this.field = new Field();
		this.peterson = new Peterson();

		this.firstNeighbor = new Neighbor("Mary, Queen of Scots", field, peterson, 1);
		this.secondNeighbor = new Neighbor("Elizabeth I", field, peterson, 2);

		this.firstNeighbor.setNeighbor(secondNeighbor);
		this.secondNeighbor.setNeighbor(firstNeighbor);

		this.firstThread = new Thread(this.firstNeighbor);
		this.secondThread = new Thread(this.secondNeighbor);

	}

	/**
	 * Opens field for business.
	 */
	public void openField() {

		this.startThreads();

		this.waitForTenSeconds();

		this.stopThreads();

	}

	/**
	 * Starts the threads.
	 */
	private void startThreads() {
		this.firstThread.start();
		this.secondThread.start();
	}

	/**
	 * Calls thread.sleep for 10 seconds to let the threads execute for that
	 * time.
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
	 */
	private void stopThreads() {
		this.firstNeighbor.stop();
		this.secondNeighbor.stop();
	}

}
