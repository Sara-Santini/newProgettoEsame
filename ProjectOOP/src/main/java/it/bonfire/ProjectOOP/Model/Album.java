/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Model;

import java.util.HashSet;


/**
 * Description of Album.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 */
public class Album extends API_Instagram {
	/**
	 * Description of the property photos.
	 */
	private HashSet<Photos> photos= new HashSet<Photos>();


	/**
	 * The constructor.
	 */
	/**
	 * @param id
	 * @param caption
	 * @param media_type
	 * @param fotografias
	 */
	public Album(String id, String caption, String media_type, HashSet<Photos> photos) {
		super(id, caption, media_type);
		this.photos = photos;
	}
	public Album(Album a) {
		super(a.getId(),a.getCaption(),a.getMedia_type());
		this.photos=new HashSet<Photos>(a.getPhotos());
	
	}
	
	/**
	 * @return photos 
	 */
	public HashSet<Photos> getPhotos() {
		return photos;
	}
	
	/**
	 * @param fotografias the photos to set
	 */
	public void setPhotos(HashSet<Photos> photos) {
		this.photos = photos;
	}

	@Override
	public String toString() {
		return "Album [fotografias=" + photos + "]";
	}
	
}


