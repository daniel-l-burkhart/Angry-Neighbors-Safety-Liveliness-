package edu.westga.neighbors.model;

/**
 * The Class Field.
 *
 * @author Daniel Burkhart
 * @version Spring 2016
 */
public class Field {

	private int visitors;

	/**
	 * Instantiates a new field.
	 */
	public Field() {

		this.visitors = 0;

	}

	/**
	 * Enter the field.
	 */
	public void enter() {

		if (this.visitors == 2) {
			throw new IllegalStateException("Neighbors are fighting");
		}

		if (this.visitors < 2) {
			this.visitors++;
		}

	}

	/**
	 * Leave the field.
	 */
	public void leave() {
		this.visitors--;
	}

}
