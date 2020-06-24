package it.bonfire.ProjectOOP.Exceptions;

import java.io.IOException;

/**
 * Class that extends IOException and it is called when the user wants to do a
 * filter but it doesn't exists.
 * 
 * @author Francesco Voto
 * @author Sara Santini
 * @author Arianna Nazzarelli
 *
 */

public class FilterNotFoundException extends IOException{

	private static final long serialVersionUID = 1L;
/**
 * The constructor.
 */
	public FilterNotFoundException() {
		super();
		System.out.println("failed filter");
		
	}
}
