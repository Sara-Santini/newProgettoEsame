package it.bonfire.ProjectOOP.Exceptions;

/**
 * Class that extends MalformedUrlException and it is called when the user input a wrong URL.  
 * @author Francesco Voto
 * @author Sara Santini
 * @author Arianna Nazzarelli
 *
 */
import java.net.MalformedURLException;

public class WrongURLException extends MalformedURLException {
	private static final long serialVersionUID = 1L;

	/**
	 * The constructor.
	 */
	public WrongURLException() {
		super();
		System.out.println("Attenzione: URL errato.");

	}

}
