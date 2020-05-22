/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Model;

/**
 * Description of Image.
 * 
 * @author Arianna Nazzarelli
 * @author Frncesco Voto
 * @author Sara Santini
 */
public class Image extends API_Instagram {
	/**
	 * Description of the property fotografias.
	 */
	private Fotografia fotografias = null;

	// Start of user code (user defined attributes for Image)

	// End of user code

	/**
	 * The constructor.
	 */
	public Image() {
		// Start of user code constructor for Image)
		super();
		// End of user code
	}
	

	public Image(int id, String caption, String media_type, Fotografia fotografias) {
		super(id, caption, media_type);
		this.fotografias = fotografias;
	}


	// Start of user code (user defined methods for Image)

	// End of user code
	/**
	 * Returns fotografias.
	 * @return fotografias 
	 */
	public Fotografia getFotografias() {
		return this.fotografias;
	}


	/**
	 * @param fotografias the fotografias to set
	 */
	public void setFotografias(Fotografia fotografias) {
		this.fotografias = fotografias;
	}

}
