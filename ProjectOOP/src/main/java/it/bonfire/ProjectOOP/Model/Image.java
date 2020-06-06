/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Model;

/**
 * Class which describes the features of an image.
 * 
 * @author Arianna Nazzarelli
 * @author Frncesco Voto
 * @author Sara Santini
 */
public class Image extends API_Instagram {
	/**
	 * It's a new photo.
	 */
	private Photos photos = null;

	
	/**
	 * The constructor.
	 */
	public Image() {
		super();

	}
	/**
	 * The constructor.
	 */
	public Image(String id, String caption, String media_type, Photos photos) {
		super(id, caption, media_type);
		this.photos = photos;
	}
	/**
	 * The constructor.
	 */
	public Image(API_Instagram api, Photos photos) {
		super(api.getId(), api.getCaption(), api.getMedia_type());
		this.photos = photos;
	}

	/**
	 * Method that gives back a photo.
	 * @return photos
	 */
	public Photos getPhotos() {
		return photos;
	}
	/**
	 * Method which sets a photo, given by the user,to image.
	 * @param photos the photos to set
	 */
	public void setPhotos(Photos photos) {
		this.photos = photos;
	}

/**
 
* Methods which gives back the string of Image.
* 
* @return String
* @see API_Instagram
* */
	@Override
	public String toString() {
		return  super.toString()+"Image [photos=" + photos + "]";
	}

}
