package edu.westga.neighbors.model;

public class Field {

	private int visitors;

	public Field() {

		this.visitors = 0;

	}

	public void enter() {

		if ((this.visitors + 1) == 2) {
			throw new IllegalStateException("Neighbors are fighting");
		} else {
			this.visitors++;
		}
	}

	public void leave() {
		this.visitors--;
	}

}
