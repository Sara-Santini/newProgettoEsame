/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Model;

/**
 * Class which describes some features of a photo.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 */

public abstract class API_Instagram {
	/**
	 * It is the identity of a photo.
	 */
	private String id;

	/**
	 * It is the caption of a photo.
	 */
	private String caption;

	/**
	 * It is the media_type of a photo.
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

	/**
	 * The constructor.
	 */
	public API_Instagram() {

	}

	/**
	 * Method that gives back the caption of API_Instagram.
	 * 
	 * @return caption
	 */
	public String getCaption() {
		return caption;

	}

	/**
	 * Method which sets a caption, given by the user, to API_Instagram.
	 * 
	 * @param caption
	 */
	public void setCaption(String caption) {

		this.caption = caption;

	}

	/**
	 * Method that gives back the media_type of API_Instagram.
	 * 
	 * @return media_type
	 */
	public String getMedia_type() {

		return media_type;

	}

	/**
	 *  Method which sets a value to attribute to Media_type.
	 * 
	 * @param media_type
	 */
	public void setMedia_type(String media_type) {

		this.media_type = media_type;

	}

	/**
	 * Method that gives back the id of API_Instagram.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 *  Method which sets a value to attribute to Id.
	 * 
	 * @param id
	 */
	public void setId(String id) {

		this.id = id;

	}

	
	/**
	 * Methods which gives back the string of API_Instagram.
	 * 
	 * @return String.
	 */
	@Override
	public String toString() {

		return "API_Instagram [id=" + id + ", caption=" + caption + ", media_type=" + media_type + "]";
	}

}
