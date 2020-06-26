/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Model;

import java.util.HashSet;

/**
 * Class which describes the album of Instagram.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 */
public class Album extends API_Instagram {
	/**
	 * New collection of photos.
	 * 
	 * @see Photos.
	 */
	private HashSet<Photos> photos = new HashSet<Photos>();

	/**
	 * The constructor.
	 */
	/**
	 * @param id Identify the photo.
	 * @param caption Description of a photo.
	 * @param media_type Type of the media.
	 * @param photos Photos of an album.
	 * 
	 * @see API_Instagram
	 * @see Photos photos
	 */
	public Album(String id, String caption, String media_type, HashSet<Photos> photos) {
		super(id, caption, media_type);
		this.photos = photos;
	}

	/**
	 * The constructor.
	 * @param a Album 
	 * @see API_Instagram api
	 * @see Photos photos
	 * 
	 */
	public Album(Album a) {
		super(a.getId(), a.getCaption(), a.getMedia_type());
		this.photos = new HashSet<Photos>(a.getPhotos());

	}

	/**
	 * Method that gives back a collection of Photos.
	 * 
	 * @return photos
	 */
	public HashSet<Photos> getPhotos() {
		return photos;
	}

	/**
	 * Method which sets a value to attribute to photos.
	 * 
	 * @see Photos photos.
	 * @param photos the photos to set
	 */
	public void setPhotos(HashSet<Photos> photos) {
		this.photos = photos;
	}

	/**
	 * Methods which gives back the string of the Album.
	 * 
	 * @see Photos photos.
	 * @return String.
	 */
	@Override
	public String toString() {
		return "Album [photos=" + photos + "]";
	}

}
