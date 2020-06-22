package it.bonfire.ProjectOOP.Controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import it.bonfire.ProjectOOP.Exceptions.FilterNotFoundException;
import it.bonfire.ProjectOOP.Exceptions.StatsNotFoundException;
import it.bonfire.ProjectOOP.Filters.Filter;
import it.bonfire.ProjectOOP.Filters.FilterService;
import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Image;
import it.bonfire.ProjectOOP.Model.Photos;
import it.bonfire.ProjectOOP.Others.Downloader;
import it.bonfire.ProjectOOP.Others.Parsing;
import it.bonfire.ProjectOOP.Statistics.StatisticService;
import it.bonfire.ProjectOOP.Statistics.Statistics;

/**
 * Class that represents the DataSet's initialization.
 * 
 * @author Sara Santini.
 * @author Francesco Voto.
 * @author Arianna Nazzarelli.
 */

public class DataBase {
	/**
	 * New collection of API_Instagram.
	 */
	private HashSet<API_Instagram> api = new HashSet<API_Instagram>();
	/**
	 * Object of Statistics.
	 */
	private StatisticService statsService;
	/**
	 * Object of FilterService.
	 */
	private FilterService filterService;

	/**
	 * The Constructor.
	 * 
	 * @see Downloader
	 * @see Parsing
	 * @see Statistics
	 */
	
	public DataBase() {
		Downloader iooDownloader = new Downloader();
		Parsing parsing = new Parsing();
		String urlString = "https://graph.instagram.com/me/media?fields=id,caption,media_type,media_url,children&access_token=IGQVJYcF9aRXNPN1FXVUxnaFptSTZAZAWDdGc19XYk03ajRTOU1PbTJGMFdJb2xmdlR1aV9rVmxfU3BTaUJJd0s5MlNqYlZAxTVV5a1J6cHBXdGpraFhUdDJCR283cmdlYVlGRE55S1g3ZAGRHV3ZATWDNjbwZDZD";
		try {
			api = parsing.GetAPIInstagramFromJson(iooDownloader.getJSONbyURL(urlString));
			iooDownloader.getImageAlbumUrl(api);
			parsing.DownloadImage(api);
			statsService = new StatisticService(api);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} catch(StatsNotFoundException e){
e.printStackTrace();
}

	}

	/**
	 * The Constructor.
	 * 
	 * @param api A collection of API_Instagram.
	 */
	public DataBase(HashSet<API_Instagram> api) {
		this.api = api;
	}

	/**
	 * Method that gives back the collection of API_Instagram.
	 * @return HashSet.
	 */
	public HashSet<API_Instagram> getApi() {
		return api;
	}

	/**
	 * Method which sets a value to attribute to the collection of API_Instagram.
	 * @param api new Hashset of API_Instagram
	 */
	public void setApi(HashSet<API_Instagram> api) {
		this.api = api;
	}

	/**
	 * Method that add an image to the collection of API_Instragram.
	 * 
	 * @see Image
	 * @see API_Instagram
	 * @param image The image that the user wants to add to the collection.
	 * @throws ResponseStatusException if the image is existing in the collection
	 *                                 yet.
	 */
	public void addApi(Image image) {
//		if (api.contains((API_Instagram) image)) {
//			
//			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "già esistente");
//		}
		for(API_Instagram a: api) {
     if (a.getId().equals(image.getId())) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "già esistente");
		}
		api.add((API_Instagram) image);
	}

	/**
	 * Method that deletes an image or an album of the API_Instragram's collection.
	 * 
	 * @param id Identify the photos.
	 * @return true or false if the image is found and deleted.
	 * @see API_Instagram
	 * @throws ResponseStatusException if the image or the album is not present in
	 *                                 the API.
	 */
	public boolean deleteApi(String id) {
		Iterator<API_Instagram> p = api.iterator();
		boolean i = false;
		while (p.hasNext() && i == false) {
			API_Instagram ap = p.next();
			if (ap.getMedia_type().equals("CAROUSEL_ALBUM")) {

			}
			if (ap.getId().equals(id)) {

				api.remove(ap);
				i = true;
			}
		}
		if (i == false)
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "non presente");
		return i;

	}

	/**
	 * Method that add an album to the collection of API_Instragram.
	 * 
	 * @param album that the user wants to add to the collection.
	 * @see Album
	 * @see API_Instagram
	 * @throws ResponseStatusException if the Album is existing yet.
	 * 
	 */
	public void addApi(Album album) {
		if (api.contains((API_Instagram) album))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "già esistente");
		api.add((API_Instagram) album);
	}

	/**
	 * Method that gives back the photos with a hashtag in their caption.
	 * 
	 * @see Filter
	 */
	public void getPhotoHashtag() {
		Filter filter = new Filter();
		try {
			filter.dowPhotosWithHashtag(filter.photosWithHashtag(api));
		} catch (IOException e) {

			FilterNotFoundException a = (FilterNotFoundException) e;
			a.getMessage();
		}
	}

	/**
	 * Method that gives back the photos with more and less than 100KB of bytes and
	 * organizes them.
	 * 
	 * @see Filter
	 */
	public void getSortPhotos() {
		Filter filter = new Filter();
		try {
			filter.sortPhotos(filter.photosMore100Kb(api, 102400), filter.photosUnder100Kb(api, 102400));
		} catch (IOException e) {

			FilterNotFoundException a = (FilterNotFoundException) e;
			a.getMessage();
		}

	}

	/**
	 * Method that manage the call of filter by using jolly character.
	 * 
	 * @param json String of a JsonObject
	 * @see FilterService
	 * @return a FilterService
	 * @throws ParseException Error that is thrown if there is any problem on the
	 *                        conversion of a string into an object.
	 * @throws FilterNotFoundException It is thrown when the filter doesn't exists.
	 * @throws NumberFormatException It is thrown when the format of number isn't correct.
	 */
	public FilterService filterservice(String json) throws ParseException, NumberFormatException, FilterNotFoundException {
		JSONParser parser = new JSONParser();
		Object obj = new Object();
		obj = parser.parse(json);
		JSONObject jsonObj = (JSONObject) obj;
		filterService = new FilterService(api);
		JSONArray nfilter = (JSONArray) jsonObj.get("filter");
		for (int i = 0; i < nfilter.size(); i++) {
			JSONObject jsonObject = (JSONObject) nfilter.get(i);
			String field = (String) jsonObject.get("field");
			String param = (String) jsonObject.get("param");
			if (param.isEmpty())
				param = "0";
			filterService.Operator(field, (int) Integer.valueOf(param));
		}
		return filterService;
	}

	/**
	 * Method that search a photo in the collection of API_Instagram by using an id
	 * passed by the user.
	 * 
	 * @param id Identify the photo to search.
	 * @return a Photo.
	 * @throws FilterNotFoundException It is thrown when the filter doesn't exists.
	 * @see Photos
	 * @see API_Instagram
	 * @see Album
	 * @see Image
	 */
	public Photos SearchPhotos(String id) throws FilterNotFoundException {
		Iterator<API_Instagram> iter = api.iterator();
		Photos photos = new Photos();
		boolean b = false;
		while (iter.hasNext() && b == false) {
			API_Instagram im = iter.next();
			if (im.getClass().equals(Image.class) && im.getId().equals(id)) {

				Image image = (Image) im;
				photos = image.getPhotos();
				b = true;
			}

			else if (im.getClass().equals(Album.class)){

				Album album = (Album) im;

				Iterator<Photos> a = album.getPhotos().iterator();
				while (a.hasNext()) {
					Photos appoggio1 = a.next();
					if (appoggio1.getId_Photos().equals(id)) {
						photos = appoggio1;
						b = true;
					}
				}

			}
		}
		if(!b) throw new FilterNotFoundException();
		return photos;
	}

	/**
	 * Method that gives back the statistics of filtered images.
	 * 
	 * @return StatisticService.
	 * @throws StatsNotFoundException It is thrown when the statistic doesn't exists. 
	 */
	public StatisticService getStatisticsFilter() throws StatsNotFoundException {
		StatisticService stats = new StatisticService(filterService.getApi());
		return stats;

	}

	/**
	 * Method that gives back the statistics.
	 * 
	 * @return the statistics.
	 */
	public StatisticService getStats() {
		return statsService;
	}

	/**
	 * @param stats the statistics to set
	 */
	public void setStats(StatisticService stats) {
		this.statsService = stats;
	}

}

