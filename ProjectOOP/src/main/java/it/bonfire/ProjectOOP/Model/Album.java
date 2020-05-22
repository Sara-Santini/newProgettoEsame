/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package Model;

import Model.API_Instagram;
// Start of user code (user defined imports)

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
	public HashSet<Fotografia> fotografias = new HashSet<Fotografia>();

	// Start of user code (user defined attributes for Album)

	// End of user code

	/**
	 * The constructor.
	 */
	public Album() {
		// Start of user code constructor for Album)
		super();
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

}
