/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Filters;

import java.io.File;
import java.util.HashSet;
import java.util.Iterator;

import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Fotografia;
import it.bonfire.ProjectOOP.Model.Image;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of FilterImageName.
 * 
 * @author Arianna Nazzarelli
 * @author Sara Santini
 * @author Francesco Voto
 */
public class Filter {
	HashSet<API_Instagram> collezione;

	/**
	 * The constructor.
	 */

	public Filter(HashSet<API_Instagram> collezione) {
		super();
		this.collezione = collezione;
	}

	public void sortPhotos(){
		new File("C:\\\\Users\\\\39346\\\\Pictures\\\\FotoMeno100kb").mkdir();
		new File("C:\\\\Users\\\\39346\\\\Pictures\\\\FotoPiu100kb").mkdir();
	     int n=1;
	   Iterator<API_Instagram> p= collezione.iterator();
		while(p.hasNext()) {
			API_Instagram appoggio = p.next();
			if (appoggio.getMedia_type().equals("CAROUSEL_ALBUM")) {
				Album album = (Album) appoggio;
				Iterator<Fotografia> a = album.getFotografias().iterator();
			while (a.hasNext()) {
					Fotografia appoggio1 =a.next();
					File photo = new File("C:\\Users\\39346\\Pictures\\Album"+n+"\\" +appoggio1.getId_photos()+".jpg" ); 
					if (appoggio1.getnByte()<102.400) {
					photo.renameTo(new File("C:\\Users\\39346\\Pictures\\FotoMeno100kb")); 
					
				}
			else {
				photo.renameTo(new File("C:\\Users\\39346\\Pictures\\FotoPiu100kb")); 
				
			}
				
			}
			n++;
			}
				else {
					Image image= (Image) appoggio;
					File photo = new File("C:\\Users\\39346\\Pictures"+ image.getId()+".jpg"); 
					if (image.getFotografias().getnByte()<102.400) {
						photo.renameTo(new File("C:\\Users\\39346\\Pictures\\FotoMeno100kb" + photo.getName())); 
						
					}
				else {
					photo.renameTo(new File("C:\\Users\\39346\\Pictures\\FotoPiu100kb" + photo.getName())); 
				
					
				}
	   
	   
   }
}}}
