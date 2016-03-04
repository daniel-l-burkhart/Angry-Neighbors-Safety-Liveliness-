/**
 * 
 */
package edu.westga.neighbors.model;

/**
 * @author danielburkhart
 *
 */
public class Peterson {

	private int indicator;

	/**
	 * 
	 */
	public Peterson() {
		this.indicator = 0;
	}

	public synchronized void set(int value) {
		this.indicator = value;
	}

	public int getStatus() {
		return this.indicator;
	}

}
