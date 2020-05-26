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
	 * Description of the property fotografias.
	 */
	private Fotografia fotografias = null;

	
	/**
	 * The constructor.
	 */
	public Image() {
		super();

	}

	public Image(String id, String caption, String media_type, Fotografia fotografias) {
		super(id, caption, media_type);
		this.fotografias = fotografias;
	}

	/**
	 * @return fotografias
	 */
	public Fotografia getFotografias() {
		return fotografias;
	}
	/**
	 * @param fotografias the fotografias to set
	 */
	public void setFotografias(Fotografia fotografias) {
		this.fotografias = fotografias;
	}
@Override
	public String toString() {
		return "Image [fotografias=" + fotografias + "]";
	}

}
