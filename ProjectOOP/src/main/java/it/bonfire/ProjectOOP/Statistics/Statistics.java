/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Statistics;



import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Vector;

import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Fotografia;
import it.bonfire.ProjectOOP.Model.Image;

/**
 * Description of StatsByte.
 * 
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 */
public class Statistics {
	private HashSet <API_Instagram> collezione;
	private Vector<Float> bytes = new Vector<>();
	private Vector<Long> pixel;

	/**
	 * @param collezione
	 */
	public Statistics(HashSet<API_Instagram> collezione) {
		this.collezione = collezione;
	}
	public void initializer () {
	Iterator<API_Instagram> p= collezione.iterator();
		while(p.hasNext()) {
			API_Instagram appoggio = p.next();
			if (appoggio.getMedia_type().equals("CAROUSEL_ALBUM")) {
				Album album = (Album) appoggio;
				Iterator<Fotografia> a = album.getFotografias().iterator();
			
				while (a.hasNext()) {
					Fotografia appoggio1 =a.next();
					
					bytes.add((float) (appoggio1.getnByte()/1024));
					pixel.add((long) (appoggio1.getPixelHeight()*appoggio1.getPixelWeight()));
				}
			}
				else {
					Image image= (Image) appoggio;
					bytes.add((float) (image.getFotografias().getnByte()/1024));
					pixel.add((long) (image.getFotografias().getPixelHeight()*image.getFotografias().getPixelWeight()));
					
				}
			

		}
		
	}
	public float averageofbytes () {
		float somma=0;
		for(int i=0;i<bytes.size();i++){
			somma+= bytes.get(i);
		}
		 return somma/bytes.size();
	}
	
	public float medianofbytes () {
		Collections.sort(bytes);
		int median= (int) bytes.size()/2;
		return bytes.get(median);	
	}
	public long medianofpixels () {
		Collections.sort(pixel);
		int median= (int) pixel.size()/2;
		return pixel.get(median);	
	}

	
}