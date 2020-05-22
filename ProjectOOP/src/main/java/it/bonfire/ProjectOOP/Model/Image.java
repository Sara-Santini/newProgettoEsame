/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package Model;

import Model.API_Instagram;
// Start of user code (user defined imports)

// End of user code

/**
 * Description of Image.
 * 
 * @author arian
 */
public class Image extends API_Instagram {
	/**
	 * Description of the property fotografias.
	 */
	public Fotografia fotografias = null;

	// Start of user code (user defined attributes for Image)

	// End of user code

	/**
	 * The constructor.
	 */
	public Image() {
		// Start of user code constructor for Image)
		super();
		// End of user code
	}

	// Start of user code (user defined methods for Image)

	// End of user code
	/**
	 * Returns fotografias.
	 * @return fotografias 
	 */
	public Fotografia getFotografias() {
		return this.fotografias;
	}

	/**
	 * Sets a value to attribute fotografias. 
	 * @param newFotografias 
	 */
	public void setFotografias(Fotografia newFotografias) {
		if (this.fotografias != null) {
			this.fotografias.set(null);
		}
		this.fotografias.set(this);
	}

}
