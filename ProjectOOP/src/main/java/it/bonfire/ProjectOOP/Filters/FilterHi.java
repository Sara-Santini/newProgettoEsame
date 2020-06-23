package it.bonfire.ProjectOOP.Filters;

import java.util.HashSet;
import java.util.Iterator;


import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Image;
import it.bonfire.ProjectOOP.Model.Photos;

/**
 * Class that implements a function to delete photo with a number of pixels minor than the one passed by the user.
 * @author Francesco Voto
 * @author Sara Santini
 * @author Arianna Nazzarelli
 * 
 *
 */
public class FilterHi extends Filters {
	/**
	 * Method that deletes photos that have a height of pixel minor than the one passed by the user.
	 * @param collezione New collection of API_Instagram
	 * @param H          Height of a photo's pixels.
	 * @see API_Instagram api_instagram
	 * @see Image image
	 * @see Photos photos
	 * @see Album album
	 * @return HashSet
	 */

	public FilterHi(HashSet<API_Instagram> collezione, Integer H) {
		   super(collezione);
			Iterator<API_Instagram> iter = api.iterator();
			while (iter.hasNext()) {
				API_Instagram im = iter.next();
				if (im.getClass().equals(Image.class)) {
					Image image = (Image) im;
					if (image.getPhotos().getPixelHeight() < H)
						iter.remove();
				} else {
					Album album = (Album) im;

					Iterator<Photos> a = album.getPhotos().iterator();
					while (a.hasNext()) {
						Photos appoggio1 = a.next();
						if (appoggio1.getPixelHeight() < H)
							a.remove();

					}
					if (album.getPhotos().isEmpty())
						iter.remove();
				}

			}

		}
}
