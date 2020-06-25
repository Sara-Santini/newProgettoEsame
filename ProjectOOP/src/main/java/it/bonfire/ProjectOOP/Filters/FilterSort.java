package it.bonfire.ProjectOOP.Filters;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;

import it.bonfire.ProjectOOP.Exceptions.WrongURLException;
import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Others.Parsing;
/**
 * Class that downloads images in three albums: more100kb,under100kb,withHastag.
 * @author Arianna Nazzarelli
 * @author Francesco Voto
 * @author Sara Santini
 * 
 *
 */
public class FilterSort {
	/**
	 * new object of parsing.
	 */
	Parsing par;
	/**
	 * the constructor.
	 */
	public FilterSort() {

	
}
	/**
	 * Method that places downloaded images with more and under than 100Kb of pixel
	 * in a specific directory.
	 * 
	 * @param more100  Collection of images with more than 100Kb
	 * @param under100 Collection of images with under than 100Kb
	 * @see Parsing parsing 
	 */
	public void sortPhotos(HashSet<API_Instagram> more100, HashSet<API_Instagram> under100){
		
		new File(Parsing.getDir() + Parsing.getPath() + "FotoMeno100kb").mkdir();
		new File(Parsing.getDir() + Parsing.getPath() + "FotoPiu100kb").mkdir();
		par = new Parsing();
		par.setDirOk(Parsing.getDir() + Parsing.getPath() + "FotoMeno100kb");

		par.DownloadImage(under100);
		par = new Parsing();
		par.setDirOk(Parsing.getDir() + Parsing.getPath() + "FotoPiu100kb");
		par.DownloadImage(more100);
		
	}
	/**
	 * Method that creates a file in order to save there images with hashtag.
	 * 
	 * @param collezione New collection of API_Instagram.
	 * @see Parsing
	 * @throws WrongURLException error when the URL is wrong.
	 * @throws IOException which is thrown if there is any problem in the process of
	 *                     input/output.

	 */
	public void dowPhotosWithHashtag(HashSet<API_Instagram> collezione) throws IOException, WrongURLException{

		par = new Parsing();
		new File(Parsing.getDir() + Parsing.getPath()  + "PhotosWithHashtag").mkdir();
		par.setDirOk(Parsing.getDir() + Parsing.getPath() + "PhotosWithHashtag");
		par.DownloadImage(collezione); 

	}

}

