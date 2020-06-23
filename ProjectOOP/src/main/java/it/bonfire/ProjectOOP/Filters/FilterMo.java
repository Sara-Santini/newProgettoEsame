package it.bonfire.ProjectOOP.Filters;

import java.util.HashSet;
import java.util.Iterator;
import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Image;
import it.bonfire.ProjectOOP.Model.Photos;

public class FilterMo extends Filters {
	/**
	 * 
	 * @param collezione New collection of API_Instagram.
	 * @param Bt         Bytes of the image.
	 * @see API_Instagram api
	 * @see Image image
	 * @see Album album
	 * @see Photos photos
	 * @return HashSet
	 */
	public FilterMo(HashSet<API_Instagram> collezione, Integer Bt) {
	
		super(collezione);
			Iterator<API_Instagram> iter = super.api.iterator();
			while (iter.hasNext()) {
				API_Instagram im = iter.next();
				if (im.getClass().equals(Image.class)) {
					Image image = (Image) im;
					if (image.getPhotos().getnByte() < Bt)
						iter.remove();
				} else {

					Album album = new Album((Album) im);

					Iterator<Photos> a = album.getPhotos().iterator();
					while (a.hasNext()) {
						Photos appoggio1 = a.next();
						if (appoggio1.getnByte() < Bt)
							a.remove();

					}
					if (album.getPhotos().isEmpty())
						iter.remove();
				}

			}
		}
}
