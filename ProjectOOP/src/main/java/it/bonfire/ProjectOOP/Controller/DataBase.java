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
import it.bonfire.ProjectOOP.Filters.Filter;
import it.bonfire.ProjectOOP.Filters.FilterService;
import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Image;
import it.bonfire.ProjectOOP.Model.Photos;
import it.bonfire.ProjectOOP.Others.Downloader;
import it.bonfire.ProjectOOP.Others.Parsing;
import it.bonfire.ProjectOOP.Statistics.Statistics;

public class DataBase {
	private HashSet<API_Instagram> api = new HashSet<API_Instagram>();
	private Statistics stats ;
	private  FilterService filterService;
		
	

	public DataBase() {
		Downloader iooDownloader = new Downloader();
		Parsing parsing = new Parsing();
		String urlString = "https://graph.instagram.com/me/media?fields=id,caption,media_type,media_url,children&access_token=IGQVJYcF9aRXNPN1FXVUxnaFptSTZAZAWDdGc19XYk03ajRTOU1PbTJGMFdJb2xmdlR1aV9rVmxfU3BTaUJJd0s5MlNqYlZAxTVV5a1J6cHBXdGpraFhUdDJCR283cmdlYVlGRE55S1g3ZAGRHV3ZATWDNjbwZDZD";
		try {
			api = parsing.GetAPIInstagramFromJson(iooDownloader.getJSONbyURL(urlString));
			iooDownloader.getImageAlbumUrl(api);
			parsing.DownloadImage(api);
		 stats= new Statistics(api);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.getMessage();
		}

	}

	public DataBase(HashSet<API_Instagram> api) {
		this.api = api;
	}

	public HashSet<API_Instagram> getApi() {
		return api;
	}

	public void setApi(HashSet<API_Instagram> api) {
		this.api = api;
	}

	public void addApi(Image image) {
		if (api.contains((API_Instagram) image)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "già esistente");
		}
		api.add((API_Instagram) image);
	}
	

	public boolean deleteApi(String id) {
		Iterator<API_Instagram> p = api.iterator();
		boolean i=false;
		while (p.hasNext() && i==false) {
			API_Instagram ap = p.next();
			if (ap.getMedia_type().equals("CAROUSEL_ALBUM")) {
			
			}
			if (ap.getId().equals(id)) {

				api.remove(ap);
				i=true;
			}
		}
			if(i==false) throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "non presente");
			return i;
				
	}

	public void addApi(Album album) {
		if (api.contains((API_Instagram) album))
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "già esistente");
		api.add((API_Instagram) album);
	}
	public void getPhotoHashtag()  {
		Filter filter = new Filter();
		try {
			filter.dowPhotosWithHashtag(filter.photosWithHashtag(api));
		} catch (IOException e) {

			FilterNotFoundException a= (FilterNotFoundException) e;
			 a.getMessage();
		}}
		
		public void getSortPhotos() {
			Filter filter = new Filter();
			try {
				filter.sortPhotos(filter.photosMore100Kb(api,102400), filter.photosUnder100Kb(api,102400));
			} catch (IOException e) {
				
				FilterNotFoundException a= (FilterNotFoundException) e;
				 a.getMessage();
			}
	     
	}
		public FilterService filterservis(String json) throws ParseException {
			JSONParser parser = new JSONParser();
			Object obj = new Object();
				obj = parser.parse(json);
				JSONObject jsonObj = (JSONObject) obj;
			filterService=new FilterService(api);
			JSONArray nfilter=(JSONArray) jsonObj.get("filter");
			for (int i = 0; i < nfilter.size(); i++) {
				JSONObject jsonObject = (JSONObject) nfilter.get(i);
				String field = (String) jsonObject.get("field");
				String param= (String) jsonObject.get("param");
				if(param==null)param="0";
				filterService.Operator(field,(int)Integer.valueOf(param));}
			return filterService;
			}

		public Photos SearchPhotos(String id) {
			Iterator<API_Instagram> iter= api.iterator();
			Photos photos =new Photos();
			boolean b=false;
			while(iter.hasNext() && b==false) {
				API_Instagram im = iter.next();
			if (im.getClass().equals(Image.class) && im.getId().equals(id))
				{
				
				Image image= (Image) im;
				photos=image.getPhotos();
				b=true;
				}
			
			else {
				
				Album album = (Album) im;
				
				Iterator<Photos> a = album.getPhotos().iterator();
				while (a.hasNext()) {
					Photos appoggio1 = a.next();
					if (appoggio1.getId_Photos().equals(id)) 
						{photos=appoggio1;
						b=true;
						}
				}
			
		}
			}
			return photos;
			}
		public String getStatistics () {
			Statistics stats= new Statistics(api);
			return stats.toString();
			
			
		}
		public String getStatisticsFilter () {
			Statistics stats= new Statistics(filterService.getApi());
			return stats.toString();
			
			
		}

		/**
		 * @return the stats
		 */
		public Statistics getStats() {
			return stats;
		}

		/**
		 * @param stats the stats to set
		 */
		public void setStats(Statistics stats) {
			this.stats = stats;
		}

}
