package it.bonfire.ProjectOOP.Exceptions;

/**
 * Class that extends IOException and it is called when the user wants to do a
 * exception but it doesn't exists.
 * 
 * @author Francesco Voto
 * @author Sara Santini
 * @author Arianna Nazzarelli
 *
 */
public class StatsNotFoundException extends ClassNotFoundException {

	private static final long serialVersionUID = 1L;

	/**
	 * The constructor.
	 */
	public StatsNotFoundException() {
		super();
		System.out.println("Attenzione: statistica non esistente");

	}


}
