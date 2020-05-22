/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package Model;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Fotografia.
 * 
 * @author arian
 */
public class Fotografia {
	/**
	 * Description of the property pixelHeight.
	 */
	public int pixelHeight = 0;

	/**
	 * Description of the property images.
	 */
	public Image images = null;

	/**
	 * Description of the property media_url.
	 */
	public String media_url = "";

	/**
	 * Description of the property id_photos.
	 */
	public int id_photos = 0;

	/**
	 * Description of the property pixelWeight.
	 */
	public int pixelWeight = 0;

	/**
	 * Description of the property byte.
	 */
	public int byte=0;

	/**
	 * Description of the property albums.
	 */
	public Album albums = null;

	// Start of user code (user defined attributes for Fotografia)

	// End of user code

	/**
	 * The constructor.
	 */
	public Fotografia() {
		// Start of user code constructor for Fotografia)
		super();
		// End of user code
	}

	/**
	 * Description of the method getMedia_url.
	 * @return 
	 */
	public String getMedia_url() {
		// Start of user code for method getMedia_url
		String getMedia_url = "";
		return getMedia_url;
		// End of user code
	}

	/**
	 * Description of the method setMedia_url.
	 * @param media_url 
	 */
	public void setMedia_url(String media_url) {
		// Start of user code for method setMedia_url
		// End of user code
	}

	/**
	 * Description of the method getId_Photos.
	 * @return 
	 */
	public int getId_Photos() {
		// Start of user code for method getId_Photos
		int getId_Photos = 0;
		return getId_Photos;
		// End of user code
	}

	/**
	 * Description of the method setId_Photos.
	 * @param id_photos 
	 */
	public void setId_Photos(int id_photos) {
		// Start of user code for method setId_Photos
		// End of user code
	}

	// Start of user code (user defined methods for Fotografia)

	// End of user code
	/**
	 * Returns pixelHeight.
	 * @return pixelHeight 
	 */
	public int getPixelHeight() {
		return this.pixelHeight;
	}

	/**
	 * Sets a value to attribute pixelHeight. 
	 * @param newPixelHeight 
	 */
	public void setPixelHeight(int newPixelHeight) {
		this.pixelHeight = newPixelHeight;
	}

	/**
	 * Returns images.
	 * @return images 
	 */
	public Image getImages() {
		return this.images;
	}

	/**
	 * Sets a value to attribute images. 
	 * @param newImages 
	 */
	public void setImages(Image newImages) {
		if (this.images != null) {
			this.images.set(null);
		}
		this.images.set(this);
	}

	/**
	 * Returns media_url.
	 * @return media_url 
	 */
	public String getMedia_url() {
		return this.media_url;
	}

	/**
	 * Sets a value to attribute media_url. 
	 * @param newMedia_url 
	 */
	public void setMedia_url(String newMedia_url) {
		this.media_url = newMedia_url;
	}

	/**
	 * Returns id_photos.
	 * @return id_photos 
	 */
	public int getId_photos() {
		return this.id_photos;
	}

	/**
	 * Sets a value to attribute id_photos. 
	 * @param newId_photos 
	 */
	public void setId_photos(int newId_photos) {
		this.id_photos = newId_photos;
	}

	/**
	 * Returns pixelWeight.
	 * @return pixelWeight 
	 */
	public int getPixelWeight() {
		return this.pixelWeight;
	}

	/**
	 * Sets a value to attribute pixelWeight. 
	 * @param newPixelWeight 
	 */
	public void setPixelWeight(int newPixelWeight) {
		this.pixelWeight = newPixelWeight;
	}

	/**
	 * Returns byte.
	 * @return byte 
	 */
	public int getByte() {
		return this.byte;
	}

	/**
	 * Sets a value to attribute byte. 
	 * @param newByte 
	 */
	public void setByte(int newByte) {
	    this.byte = newByte;
	}

	/**
	 * Returns albums.
	 * @return albums 
	 */
	public Album getAlbums() {
		return this.albums;
	}

	/**
	 * Sets a value to attribute albums. 
	 * @param newAlbums 
	 */
	public void setAlbums(Album newAlbums) {
		this.albums = newAlbums;
	}

}
