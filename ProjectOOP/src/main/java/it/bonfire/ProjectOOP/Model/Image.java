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
	 * Description of the property Photos.
	 */
	private Photos photos = null;

	
	/**
	 * The constructor.
	 */
	public Image() {
		super();

	}

	public Image(String id, String caption, String media_type, Photos photos) {
		super(id, caption, media_type);
		this.photos = photos;
	}
	
	public Image(API_Instagram api, Photos photos) {
		super(api.getId(), api.getCaption(), api.getMedia_type());
		this.photos = photos;
	}

	/**
	 * @return photos
	 */
	public Photos getPhotos() {
		return photos;
	}
	/**
	 * @param photos the photos to set
	 */
	public void setPhotos(Photos photos) {
		this.photos = photos;
	}
@Override
	public String toString() {
		return "Image [photos=" + photos + "]";
	}

}
