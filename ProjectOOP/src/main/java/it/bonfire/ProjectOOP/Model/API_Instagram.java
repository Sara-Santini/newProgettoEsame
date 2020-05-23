/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Model;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of API_Instagram.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author sara Santini
 */
public abstract class API_Instagram {
	/**
	 * Description of the property id.
	 */
	private String id = null;

	/**
	 * Description of the property caption.
	 */
	private String caption = null;

	/**
	 * Description of the property media_type.
	 */
	private String media_type = null;

	// Start of user code (user defined attributes for API_Instagram)

	// End of user code

	/**
	 * The constructor.
	 */
	
	public API_Instagram(String id, String caption, String media_type) {
		// Start of user code constructor for API_Instagram)
		super();
		this.id = id;
		this.caption = caption;
		this.media_type = media_type;
		// End of user code
	}
	public API_Instagram() {
		
	}

	/**
	 * Description of the method setId.
	 * @param id 
	 * @return 
	 */
	public String setId(int id) {
		// Start of user code for method setId
		String setId = "";
		return setId;
		// End of user code
	}

	/**
	 * Description of the method getCaption.
	 * @return 
	 */
	public String getCaption() {
		// Start of user code for method getCaption
		String getCaption = "";
		return getCaption;
		// End of user code
	}

	/**
	 * Description of the method setCaption.
	 * @param caption 
	 */
	public void setCaption(String caption) {
		// Start of user code for method setCaption
		// End of user code
	}

	/**
	 * Description of the method getMedia_type.
	 * @return 
	 */
	public String getMedia_type() {
	
		return media_type;
		// End of user code
	}

	/**
	 * Description of the method setMedia_type.
	 * @param media_type 
	 */
	public void setMedia_type(String media_type) {
		// Start of user code for method setMedia_type
		// End of user code
	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}


	
}
