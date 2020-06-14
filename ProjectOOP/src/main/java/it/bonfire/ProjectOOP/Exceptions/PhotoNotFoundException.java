package it.bonfire.ProjectOOP.Exceptions;

/**
 * Class that extends IOException and it is called when an image doesn't exists.
 * 
 * @author Francesco Voto
 * @author Sara Santini
 * @author Arianna Nazzarelli
 *
 */
public class PhotoNotFoundException extends Exception {

	private static final long serialVersionUID = 1L;

	/**
	 * The constructor.
	 */
	public PhotoNotFoundException() {
		super();
		System.out.println("Photo not founded!");
	}

	/**
	 * Method that gives back the message to the user that the statistic isn't founded.
	 * @return message.
	 */
	public String geMessage() {
		return "photo not founded!";
	}

}
