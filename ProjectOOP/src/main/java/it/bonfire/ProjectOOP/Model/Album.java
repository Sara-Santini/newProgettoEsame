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
	 * Description of the property fotografias.
	 */
	private HashSet<Fotografia> fotografias;


	/**
	 * The constructor.
	 */
	/**
	 * @param id
	 * @param caption
	 * @param media_type
	 * @param fotografias
	 */
	public Album(String id, String caption, String media_type, HashSet<Fotografia> fotografias) {
		super(id, caption, media_type);
		this.fotografias = fotografias;
	}
	
	/**
	 * @return fotografias 
	 */
	public HashSet<Fotografia> getFotografias() {
		return fotografias;
	}
	
	/**
	 * @param fotografias the fotografias to set
	 */
	public void setFotografias(HashSet<Fotografia> fotografias) {
		this.fotografias = fotografias;
	}

	@Override
	public String toString() {
		return "Album [fotografias=" + fotografias + "]";
	}
	
}


