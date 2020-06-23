package it.bonfire.ProjectOOP.Filters;

import java.util.HashSet;
import java.util.Iterator;

import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Image;
import it.bonfire.ProjectOOP.Model.Photos;
/**
 * Class that implements a function that deletes photos that have a wide of pixel greater than the one.
 * @author Francesco Voto
 * @author Sara Santini
 * @author Arianna Nazzarelli 
 *
 */
public class FilterWi extends Filters{
	
	/**
	 * Method that deletes photos that have a wide of pixel greater than the one
	 * passed by the user.
	 * 
	 * @param collezione New collection of API_Instagram.
	 * @param W          Wide of a photo's pixels.
	 * @see API_Instagram api_instagram
	 * @see Image image
	 * @see Album album
	 * @return HashSet
	 */
	public FilterWi(HashSet<API_Instagram> collezione,Integer W) {
		    super(collezione);
			Iterator<API_Instagram> iter = super.api.iterator();
			while (iter.hasNext()) {
				API_Instagram im = iter.next();
				if (im.getClass().equals(Image.class)) {
					Image image = (Image) im;
					if (image.getPhotos().getPixelWide() < W)
						iter.remove();
				} else {
					Album album = (Album) im;
					Iterator<Photos> a = album.getPhotos().iterator();
					while (a.hasNext()) {
						Photos appoggio1 = a.next();
						if (appoggio1.getPixelWide() < W)
							a.remove();

					}
					if (album.getPhotos().isEmpty())
						iter.remove();
				}

			}
		}
	
	}


