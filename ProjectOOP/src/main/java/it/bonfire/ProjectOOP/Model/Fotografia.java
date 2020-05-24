/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Model;

/**
 * Description of Fotografia.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 */
public class Fotografia {
	/**
	 * Description of the property pixelHeight.
	 */
	private int pixelHeight = 0;

	/**
	 * Description of the property media_url.
	 */
	private String media_url = null;

	/**
	 * Description of the property id_photos.
	 */
	private String id_photos = null;

	/**
	 * Description of the property pixelWeight.
	 */
	private int pixelWeight = 0;

	/**
	 * Description of the property byte.
	 */
	private int nbyte = 0;

	/**
	 * The constructor.
	 * 
	 * @param id_photos
	 */
	public Fotografia(String id_photos) {
		this.id_photos = id_photos;
	}

	/**
	 * @param media_url
	 * @param id_photos
	 */
	public Fotografia(String id_photos, String media_url) {

		this.id_photos = id_photos;
		this.media_url = media_url;
	}

	/**
	 * Description of the method setId_Photos.
	 * 
	 * @param id_photos
	 */
	public void setId_Photos(String id_photos) {
		this.id_photos = id_photos;
	}

	/**
	 * Returns id_photos.
	 * 
	 * @return id_photos
	 */
	public String getId_photos() {
		return id_photos;
	}

	/**
	 * 
	 * @return pixelHeight
	 */
	public int getPixelHeight() {
		return pixelHeight;
	}

	/**
	 * Sets a value to attribute pixelHeight.
	 * 
	 * @param PixelHeight
	 */
	public void setPixelHeight(int PixelHeight) {
		this.pixelHeight = PixelHeight;
	}

	/**
	 * 
	 * @return media_url
	 */
	public String getMedia_url() {
		return media_url;
	}

	/**
	 * Sets a value to attribute media_url.
	 * 
	 * @param Media_url
	 */
	public void setMedia_url(String Media_url) {
		this.media_url = Media_url;
	}

	/**
	 * 
	 * @return pixelWeight
	 */
	public int getPixelWeight() {
		return pixelWeight;
	}

	/**
	 * Sets a value to attribute pixelWeight.
	 * 
	 * @param PixelWeight
	 */
	public void setPixelWeight(int PixelWeight) {
		this.pixelWeight = PixelWeight;
	}

	/**
	 * 
	 * @return byte
	 */
	public int getnByte() {
		return nbyte;
	}

	/**
	 * Sets a value to attribute byte.
	 * 
	 * @param Byte
	 */
	public void setnByte(int Byte) {
		this.nbyte = Byte;
	}

}
