/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Filters;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import it.bonfire.ProjectOOP.Exceptions.WrongURLException;
import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Photos;
import it.bonfire.ProjectOOP.Model.Image;
import it.bonfire.ProjectOOP.Others.Parsing;

/**
 * Class in which are described some filters that the user can makes on the
 * collection.
 * 
 * @author Arianna Nazzarelli
 * @author Sara Santini
 * @author Francesco Voto
 */
public class Filter {
	/**
	 * Collection of API_Instagram.
	 */
	HashSet<API_Instagram> collezione;
	/**
	 * New Object of Parsing.
	 */
	Parsing par = new Parsing();

	/**
	 * The constructor.
	 */

	public Filter() {

	}

	/**
	 * Method that places downloaded images with more and under than 100Kb of pixel
	 * in a specific directory.
	 * 
	 * @param more100  Collection of images with more than 100Kb
	 * @param under100 Collection of images with under than 100Kb
	 * @throws IOException which is thrown if there is any problem in the process of
	 *                     input/output.
	 * @see Parsing
	 * @see DownloadImage
	 */
	public void sortPhotos(HashSet<API_Instagram> more100, HashSet<API_Instagram> under100) throws IOException,WrongURLException {
		new File(par.getDir() + par.getPath() + "FotoMeno100kb").mkdir();
		new File(par.getDir() + par.getPath() + "FotoPiu100kb").mkdir();
		par = new Parsing();
		par.setDirOk(par.getDir() + par.getPath() + "FotoMeno100kb");

		par.DownloadImage(under100);
		par = new Parsing();
		par.setDirOk(par.getDir() + par.getPath() + "FotoPiu100kb");
		par.DownloadImage(more100);

	}

	/**
	 * Method that creates a file in order to save there images with hashtag.
	 * 
	 * @param collezione New collection of API_Instagram.
	 * @see Parsing
	 * @see DownloadImage
	 * @throws IOException which is thrown if there is any problem in the process of
	 *                     input/output.
	 */
	public void dowPhotosWithHashtag(HashSet<API_Instagram> collezione) throws IOException, WrongURLException{

		Parsing pars = new Parsing();
		new File(par.getDir() + pars.getPath() + "PhotosWithHashtag").mkdir();
		pars.setDirOk(pars.getDir() + pars.getPath() + "PhotosWithHashtag");
		pars.DownloadImage(collezione); 

	}

	/**
	 * Method that downloads images with hashtag.
	 * 
	 * @see API_Instagram
	 * @param collezione  collection of API_Instagram.
	 * @return HashSet<API_Instagram>
	 */
	public HashSet<API_Instagram> photosWithHashtag(HashSet<API_Instagram> collezione) {
		HashSet<API_Instagram> api = new HashSet<API_Instagram>(collezione);
		Iterator<API_Instagram> iter = api.iterator();
		while (iter.hasNext()) {
			API_Instagram im = iter.next();
			if (im.getCaption()==null || !im.getCaption().contains("#"))
				iter.remove();

		}
		return api;
	}

	/**
	 * Method that downloads photos with more than 100Kb
	 * 
	 * @param collezione New collection of API_Instagram.
	 * @param Bt         Bytes of the image.
	 * @see API_Instagram
	 * @see Image
	 * @see Album
	 * @see Photos
	 * @return HashSet<API_Instagram>
	 */
	public HashSet<API_Instagram> photosMore100Kb(HashSet<API_Instagram> collezione, int Bt) {

		HashSet<API_Instagram> api = new HashSet<API_Instagram>(collezione);
		Iterator<API_Instagram> iter = api.iterator();
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
		return api;
	}

	/**
	 * Method that downloads photos with under than 100Kb.
	 * 
	 * @param collezione New collection of API_Instagram.
	 * @param Bt         Bytes of the image.
	 * @see API_Instagram
	 * @see Image
	 * @see Album
	 * @see Photos
	 * @return HashSet<API_Instagram>
	 */
	public HashSet<API_Instagram> photosUnder100Kb(HashSet<API_Instagram> collezione, int Bt) {

		HashSet<API_Instagram> api1 = new HashSet<API_Instagram>(collezione);
		Iterator<API_Instagram> iter = api1.iterator();
		while (iter.hasNext()) {
			API_Instagram im = iter.next();
			if (im.getClass().equals(Image.class)) {
				Image image = (Image) im;
				if (image.getPhotos().getnByte() > Bt)
					iter.remove();
			} else {
				Album album = new Album((Album) im);
				Iterator<Photos> a = album.getPhotos().iterator();
				while (a.hasNext()) {
					Photos appoggio1 = a.next();
					if (appoggio1.getnByte() > Bt)
						a.remove();

				}
				if (album.getPhotos().isEmpty())
					iter.remove();
			}

		}
		return api1;
	}

	/**
	 * Method that deletes photos that have a height of pixel minor than the one
	 * passed by the user.
	 * 
	 * @param collezione New collection of API_Instagram
	 * @param H          Height of a photo's pixels.
	 * @see API_Instagram.
	 * @see Image.
	 * @see Album.
	 * @return HashSet<API_Instagram>
	 */

	public HashSet<API_Instagram> PhotosHeight(HashSet<API_Instagram> collezione, int H) {

		HashSet<API_Instagram> api = new HashSet<API_Instagram>(collezione);
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
		return api;
	}

	/**
	 * Method that deletes photos that have a wide of pixel greater than the one
	 * passed by the user.
	 * 
	 * @param collezione New collection of API_Instagram.
	 * @param W          Wide of a photo's pixels.
	 * @see API_Instagram.
	 * @see Image.
	 * @see Album.
	 * @return HashSet<API_Instagram>
	 */
	public HashSet<API_Instagram> PhotosWide(HashSet<API_Instagram> collezione, int W) {

		HashSet<API_Instagram> api = new HashSet<API_Instagram>(collezione);
		Iterator<API_Instagram> iter = api.iterator();
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
		return api;
	}
}
