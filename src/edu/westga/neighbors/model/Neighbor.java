/**
 * 
 */
package edu.westga.neighbors.model;

/**
 * @author danielburkhart
 *
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
	 * The neighbor class
	 * 
	 * @param name
	 * @param field
	 */
	public Neighbor(String name, Field field, Peterson peterson, int indicator) {

		if (name == null) {
			throw new IllegalArgumentException("Name should not be null");
		} else if (field == null) {
			throw new IllegalArgumentException("Field should not be null");
		}

		this.name = name;
		this.field = field;
		this.keepWorking = true;
		this.neighbor = null;
		this.peterson = peterson;
		this.peterson.set(indicator);
		this.indicator = indicator;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {

		while (this.keepWorking) {
			if (this.neighbor == null) {
				throw new IllegalStateException("Neighbor is null");
			}

			this.handleFlag();

			while (this.peterson.getStatus() == this.indicator && this.flag) {
				this.enterField();

				this.pickBerries();

				this.leaveField();

				this.lowerFlag();
			}
			
			this.waitForTwoSeconds();

		}
	}

	private void leaveField() {
		this.field.leave();
		System.out.println(this.name + " leaves the field");
	}

	private void enterField() {
		this.field.enter();
		System.out.println(this.name + " enters the field");
	}

	private void handleFlag() {
		if (this.neighbor.flag) {
			this.neighbor.lowerFlag();

		} else {
			this.raiseFlag();
		}
	}

	private void waitForTwoSeconds() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void pickBerries() {

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}

	}

	public void stop() {
		this.keepWorking = false;
	}

	public void setNeighbor(Neighbor neighbor) {
		if (neighbor == null) {
			throw new IllegalArgumentException("Neighbor cannot be null");
		}
		this.neighbor = neighbor;
	}

	public boolean getFlagStatus() {
		return this.flag;
	}

	public synchronized void lowerFlag() {
		this.flag = false;
	}

	public synchronized void raiseFlag() {
		this.flag = true;
	}
}
