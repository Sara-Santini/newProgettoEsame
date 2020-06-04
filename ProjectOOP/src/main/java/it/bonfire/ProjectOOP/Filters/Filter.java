/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Filters;


import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Photos;
import it.bonfire.ProjectOOP.Model.Image;
import it.bonfire.ProjectOOP.Others.Parsing;
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
	Parsing par=new Parsing();;

	/**
	 * The constructor.
	 */

	public Filter() {
		
	}
	public void sortPhotos2(HashSet<API_Instagram> more100,HashSet<API_Instagram> under100) throws IOException {
		new File(par.getDir() + "\\FotoMeno100kb").mkdir();
		new File(par.getDir() + "\\FotoPiu100kb").mkdir();
		  par=new Parsing();
       par.setDir(par.getDir()+"\\FotoMeno100kb");
     
     par.DownloadImage(under100);
     par=new Parsing();
     par.setDir(par.getDir()+"\\FotoPiu100kb");
     par.DownloadImage(more100);

			
		
	}



	public void dowPhotosWithHashtag(HashSet<API_Instagram> collezione) throws IOException {
		
		Parsing pars = new Parsing();
		new File(par.getDir() + "\\PhotosWithHashtag").mkdir();
		pars.setDir(pars.getDir()+ "\\PhotosWithHashtag");
		pars.DownloadImage(collezione);

		}
	public HashSet<API_Instagram> photosWithHashtag(HashSet<API_Instagram> collezione) {
		HashSet<API_Instagram> api = new HashSet<API_Instagram>(collezione);
		Iterator<API_Instagram> iter = api.iterator();
		while (iter.hasNext()) {
			API_Instagram im = iter.next();
				if (!im.getCaption().contains("#"))	iter.remove();
			
				}
		 return api;
			}
	  
		
	public HashSet<API_Instagram> photosMore100Kb(HashSet<API_Instagram> collezione) {
		int Bt = 102400;
		HashSet<API_Instagram> api = new HashSet<API_Instagram>(collezione);
		Iterator<API_Instagram> iter = api.iterator();
		while (iter.hasNext()) {
			API_Instagram im = iter.next();
			if (im.getClass().equals(Image.class)) {
				Image image = (Image) im;
				if (image.getPhotos().getnByte() < Bt)
					iter.remove();
			} else {
				
				Album album = new Album((Album)im);
				
				Iterator<Photos> a = album.getPhotos().iterator();
				while (a.hasNext()) {
					Photos appoggio1 = a.next();
					if (appoggio1.getnByte() < Bt) a.remove();

				}
				if(album.getPhotos().isEmpty()) iter.remove();
			}

		}
   return api;
	}
	public HashSet<API_Instagram> photosUnder100Kb(HashSet<API_Instagram> collezione) {
		int Bt = 102400;
		HashSet<API_Instagram> api1 = new HashSet<API_Instagram>(collezione);
		Iterator<API_Instagram> iter = api1.iterator();
		while (iter.hasNext()) {
			API_Instagram im = iter.next();
			if (im.getClass().equals(Image.class)) {
				Image image = (Image) im;
				if (image.getPhotos().getnByte() > Bt)
					iter.remove();
			} else {
				Album album = new Album((Album)im);
				Iterator<Photos> a = album.getPhotos().iterator();
				while (a.hasNext()) {
					Photos appoggio1 = a.next();
					if (appoggio1.getnByte() > Bt) a.remove();

				}
				if(album.getPhotos().isEmpty()) iter.remove();
			}

		}
   return api1;
	}

	public HashSet<API_Instagram> PhotosHight(HashSet<API_Instagram> collezione) {
		int H = 1100;
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
				if(album.getPhotos().isEmpty()) iter.remove();
			}

		}
   return api;
	}
	public HashSet<API_Instagram> PhotosWight(HashSet<API_Instagram> collezione) {
		int W = 600;
		HashSet<API_Instagram> api = new HashSet<API_Instagram>(collezione);
		Iterator<API_Instagram> iter = api.iterator();
		while (iter.hasNext()) {
			API_Instagram im = iter.next();
			if (im.getClass().equals(Image.class)) {
				Image image = (Image) im;
				if (image.getPhotos().getPixelWeight() < W)
					iter.remove();
			} else {
				Album album = (Album) im;
				Iterator<Photos> a = album.getPhotos().iterator();
				while (a.hasNext()) {
					Photos appoggio1 = a.next();
					if (appoggio1.getPixelWeight() < W)
						a.remove();

				}
				if(album.getPhotos().isEmpty()) iter.remove();
			}

		}
   return api;
	}
}
