/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Model;

import java.util.HashSet;

// End of user code

/**
 * Description of Album.
 * 
 * @author arian
 */
public class Album extends API_Instagram {
	/**
	 * Description of the property fotografias.
	 */
	private HashSet<Fotografia> fotografias;

	// Start of user code (user defined attributes for Album)

	// End of user code

	/**
	 * The constructor.
	 */
		// Start of user code constructor for Album)
	public Album(HashSet<Fotografia> fotografias) {
		super();
		this.fotografias = fotografias;
		// End of user code
	}

	// Start of user code (user defined methods for Album)

	// End of user code
	/**
	 * Returns fotografias.
	 * @return fotografias 
	 */
	public HashSet<Fotografia> getFotografias() {
		return this.fotografias;
	}

	/**
	 * @param fotografias the fotografias to set
	 */
	public void setFotografias(HashSet<Fotografia> fotografias) {
		this.fotografias = fotografias;
	}

}
