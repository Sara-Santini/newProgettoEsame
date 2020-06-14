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
	private String message = "Attenzione: statistica non esistente";

	private static final long serialVersionUID = 1L;

	/**
	 * The constructor.
	 */
	public StatsNotFoundException() {
		super();

	}

	/**
	 * The constructor.
	 * @param string message to return.
	 */
	public StatsNotFoundException(String string) {
		super(string);

	}

	/**
	 * Method that gives back the message that the statistics doesn't exists.
	 */
	public String getMessage() {
		return message;
	}

}
