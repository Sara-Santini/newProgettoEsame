package it.bonfire.ProjectOOP.Exceptions;

/**
 * Class that extends Exception and it is called when the user wants to do a
 * filter but the collection is empty.
 * 
 * @author Francesco Voto
 * @author Sara Santini
 * @author Arianna Nazzarelli
 *
 */
public class EmptyCollectionException extends Exception {
	private static final long serialVersionUID = 1L;
	
	public EmptyCollectionException() {
		super();
		System.out.println("The collection is Empty: you cannot filter anything.");
		
	}
}
