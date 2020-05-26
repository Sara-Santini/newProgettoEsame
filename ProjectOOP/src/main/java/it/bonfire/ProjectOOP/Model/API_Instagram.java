/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Model;

/**
 * Description of API_Instagram.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 */

public abstract class API_Instagram {
	/**
	 * Description of the property id.
	 */
	private String id;

	/**
	 * Description of the property caption.
	 */
	private String caption;

	/**
	 * Description of the property media_type.
	 */
	private String media_type = null;

	/**
	 * The constructor.
	 */

	public API_Instagram(String id, String caption, String media_type) {
		this.id = id;
		this.caption = caption;
		this.media_type = media_type;

	}

	public API_Instagram() {

	}

	/**
	 * Description of the method getCaption.
	 * 
	 * @return caption
	 */
	public String getCaption() {
		return caption;

	}

	/**
	 * Description of the method setCaption.
	 * 
	 * @param caption
	 */
	public void setCaption(String caption) {

		this.caption = caption;

	}

	/**
	 * Description of the method getMedia_type.
	 * 
	 * @return media_type
	 */
	public String getMedia_type() {

		return media_type;

	}

	/**
	 * Description of the method setMedia_type.
	 * 
	 * @param media_type
	 */
	public void setMedia_type(String media_type) {

		this.media_type = media_type;

	}

	/**
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Description of the method setId.
	 * 
	 * @param id
	 */
	public void setId(String id) {

		this.id = id;

	}

	@Override
	public String toString() {
		return "API_Instagram [id=" + id + ", caption=" + caption + ", media_type=" + media_type + "]";
	}
	

}
