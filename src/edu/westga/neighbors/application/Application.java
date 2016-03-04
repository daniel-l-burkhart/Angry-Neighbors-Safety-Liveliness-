
package edu.westga.neighbors.application;

import edu.westga.neighbors.model.Field;
import edu.westga.neighbors.model.Neighbor;
import edu.westga.neighbors.model.Peterson;

/**
 * @author danielburkhart
 *
 */
public class Application {

	/**
	 * 
	 */
	public Application() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		Field field = new Field();
		Peterson peterson = new Peterson();
		Neighbor firstNeighbor = new Neighbor("Name", field, peterson, 1);
		Neighbor secondNeighbor = new Neighbor("SecondName", field, peterson, 2);
		
		firstNeighbor.setNeighbor(secondNeighbor);
		secondNeighbor.setNeighbor(firstNeighbor);
		
		Thread firstThread = new Thread(firstNeighbor);
		Thread secondThread = new Thread(secondNeighbor);
		
		firstThread.start();
		secondThread.start();

		System.out.println("Begin");
		
		try {
			Thread.sleep(10*1000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		firstNeighbor.stop();
		secondNeighbor.stop();
		
		System.out.println("End");
	}

}
