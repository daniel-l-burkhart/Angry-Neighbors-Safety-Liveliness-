package edu.westga.neighbors.model;

/**
 * The Class Peterson.
 *
 * @author Daniel Burkhart
 * @version Spring 2016
 */
public class Peterson {

	private int indicator;

	/**
	 * Instantiates a new peterson.
	 * 
	 * @precondition: None
	 * @postcondition: A peterson object is created.
	 */
	public Peterson() {
		this.indicator = 1;
	}

	/**
	 * Sets the turn value.
	 *
	 * @param value
	 *            the value
	 * 
	 * @precondition: None
	 * @postcondition: The turn value is set.
	 */
	public void set(int value) {
		this.indicator = value;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 * 
	 * @precondition: None
	 * @postcondition: None
	 */
	public int getStatus() {
		return this.indicator;
	}

}
