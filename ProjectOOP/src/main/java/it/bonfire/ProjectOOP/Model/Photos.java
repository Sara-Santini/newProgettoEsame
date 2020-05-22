/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Model;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Photos.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 */
public abstract class Photos {
	/**
	 * Description of the property id.
	 */
	private int id = 0;

	/**
	 * Description of the property caption.
	 */
	private String caption = "";

	/**
	 * Description of the property media_type.
	 */
	private String media_type = "";

	// Start of user code (user defined attributes for Photos)

	// End of user code

	/**
	 * The constructor.
	 */
	public Photos() {
		// Start of user code constructor for Photos)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Photos)

	// End of user code
	/**
	 * Returns id.
	 * @return id 
	 */
	public int getId() {
		return this.id;
	}

	/**
	 * Sets a value to attribute id. 
	 * @param newId 
	 */
	public void setId(int newId) {
		this.id = newId;
	}

	/**
	 * Returns caption.
	 * @return caption 
	 */
	public String getCaption() {
		return this.caption;
	}

	/**
	 * Sets a value to attribute caption. 
	 * @param newCaption 
	 */
	public void setCaption(String newCaption) {
		this.caption = newCaption;
	}

	/**
	 * Returns media_type.
	 * @return media_type 
	 */
	public String getMedia_type() {
		return this.media_type;
	}

	/**
	 * Sets a value to attribute media_type. 
	 * @param newMedia_type 
	 */
	public void setMedia_type(String newMedia_type) {
		this.media_type = newMedia_type;
	}

}
