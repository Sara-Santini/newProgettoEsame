/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Model;

/**
 * Class which describes the features of an image.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
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
	 * 
	 * @param id id of photo
	 * @param caption description of photo
	 * @param media_type type of photo
	 * @param photos the photo
	 */
	public Image(String id, String caption, String media_type, Photos photos) {
		super(id, caption, media_type);
		this.photos = photos;
	}

	/**
	 * the constructor
	 * @param api HashSet 
	 * @param photos the photo
	 */
	public Image(API_Instagram api, Photos photos) {
		super(api.getId(), api.getCaption(), api.getMedia_type());
		this.photos = photos;
	}

	/**
	 * Method that gives back a photo.
	 * 
	 * @return photos
	 */
	public Photos getPhotos() {
		return photos;
	}

	/**
	 * Method which sets a value to attribute to photos.
	 * 
	 * @param photos the photos to set
	 */
	public void setPhotos(Photos photos) {
		this.photos = photos;
	}

	/**
	 * 
	 * Methods which gives back the string of Image.
	 * 
	 * @return String
	 * @see API_Instagram
	 */
	@Override
	public String toString() {
		return super.toString() + "Image [photos=" + photos + "]";
	}

}
