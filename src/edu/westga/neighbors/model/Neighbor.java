package edu.westga.neighbors.model;

/**
 * The neighbor class that acts as our thread.
 *
 * @author Daniel Burkhart
 * @version Spring 2016
 */
public class Neighbor implements Runnable {

	private String name;
	private Field field;
	private boolean keepWorking;
	private Neighbor neighbor;
	private boolean flag;
	private Peterson peterson;
	private int indicator;

	/**
	 * Private constructor to ensure use of parameterized constructor
	 */
	private Neighbor() {

		this.name = null;
		this.field = null;
		this.keepWorking = false;
		this.flag = false;
		this.peterson = null;
		this.indicator = 0;

	}

	/**
	 * Makes a new neighbor.
	 *
	 * @param name
	 *            The name of the neighbor
	 * @param field
	 *            The field that the neighbors share
	 * @param peterson
	 *            The peterson shared turn
	 * @param indicator
	 *            The individual turn value of this neighbor to be used by the
	 *            peterson.
	 * 
	 * @precondition: name, field, and peterson cannot be null
	 * @postcondition: A neighbor object is created.
	 */
	public Neighbor(String name, Field field, Peterson peterson, int indicator) {

		if (name == null) {
			throw new IllegalArgumentException("Name should not be null");
		} else if (field == null) {
			throw new IllegalArgumentException("Field should not be null");
		} else if (peterson == null) {
			throw new IllegalArgumentException("Peterson is null");
		}

		this.name = name;
		this.field = field;
		this.keepWorking = true;
		this.neighbor = null;

		this.peterson = peterson;
		this.indicator = indicator;
	}

	/**
	 * The run method of the Thread.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	@Override
	public void run() {

		while (this.keepWorking) {

			if (this.neighbor == null) {
				throw new IllegalStateException("Neighbor is null");
			}

			this.peterson.set(this.indicator);

			this.lowerNeighborsAndRaiseMyFlag();

			if (this.isItMyTurn() && this.getFlagStatus()) {

				this.enterField();
				this.pickBerries();
				this.leaveField();
				this.lowerFlag();

			}

			this.waitForTwoSeconds();

		}
	}

	/**
	 * @return true if its this neighbors turn, false otherwise.
	 */
	private boolean isItMyTurn() {
		return (this.peterson.getStatus() == this.indicator);
	}

	/**
	 * Handles the flag.
	 * 
	 * @precondition: none
	 * @postcondition: flag has been raised.
	 */
	private void lowerNeighborsAndRaiseMyFlag() {
		if (this.neighbor.getFlagStatus()) {
			this.neighbor.lowerFlag();
		} else {
			this.raiseFlag();
		}
	}

	/**
	 * When one neighbor enters the field.
	 * 
	 * @precondition: none
	 * @postcondition: A neighbor enters the field.
	 */
	private void enterField() {
		this.field.enter();
		System.out.println(this.name + " enters the field");
	}

	/**
	 * When the neighbor picks berries.
	 * 
	 * @precondition: None
	 * @postcondition: None
	 */
	private void pickBerries() {

		try {
			Thread.sleep(500);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}

	}

	/**
	 * Neighbor leaves field.
	 * 
	 * @precondition: none
	 * @postcondition: A neighbor leaves the field.
	 */
	private void leaveField() {
		this.field.leave();
		System.out.println(this.name + " leaves the field");
	}

	/**
	 * Wait for two seconds.
	 * 
	 * @precondition: none
	 * @postcondition: none
	 */
	private void waitForTwoSeconds() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException exception) {
			exception.printStackTrace();
		}
	}

	/**
	 * Stop method for thread.
	 * 
	 * @precondition: none
	 * @postcondition: the threads are stopped.
	 */
	public void stop() {
		this.keepWorking = false;
	}

	/**
	 * Sets this neighbors neighbor.
	 *
	 * @param neighbor
	 *            The neighbor of this object.
	 * 
	 * @precondition: Neighbor cannot be null.
	 * @postcondition: This neighbor's neighbor is set.
	 */
	public void setNeighbor(Neighbor neighbor) {
		if (neighbor == null) {
			throw new IllegalArgumentException("Neighbor cannot be null");
		}
		this.neighbor = neighbor;
	}

	/**
	 * Finds if the flag is raised or lowered.
	 *
	 * @return True if flag is raised, false otherwise.
	 * 
	 * @precondition: None
	 * @postcondition: None
	 */
	public boolean getFlagStatus() {
		return this.flag;
	}

	/**
	 * Lowers this neighbor's flag.
	 * 
	 * @precondition: None
	 * @postcondition: Flag is lowered
	 */
	public void lowerFlag() {
		this.flag = false;
	}

	/**
	 * Raises this neighbor's flag.
	 * 
	 * @precondition: None
	 * @postcondition: Flag is raised
	 */
	public void raiseFlag() {
		this.flag = true;
	}
}
