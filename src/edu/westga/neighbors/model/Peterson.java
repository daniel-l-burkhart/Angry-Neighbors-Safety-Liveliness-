/**
 * 
 */
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
	 */
	public Peterson() {
		this.indicator = 0;
	}

	/**
	 * Sets the turn value.
	 *
	 * @param value
	 *            the value
	 */
	public synchronized void set(int value) {
		this.indicator = value;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public int getStatus() {
		return this.indicator;
	}

}
