package it.bonfire.ProjectOOP.Controller;

import java.io.IOException;
import java.security.PublicKey;
import java.util.HashSet;
import java.util.Iterator;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import it.bonfire.ProjectOOP.Exceptions.FilterNotFoundException;
import it.bonfire.ProjectOOP.Filters.Filter;
import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Image;
import it.bonfire.ProjectOOP.Others.Downloader;
import it.bonfire.ProjectOOP.Others.Parsing;
import it.bonfire.ProjectOOP.Statistics.Statistics;

public class DataBase {
	private HashSet<API_Instagram> api = new HashSet<API_Instagram>();

	public DataBase() {
		Downloader iooDownloader = new Downloader();
		Parsing parsing = new Parsing();
		String urlString = "https://graph.instagram.com/me/media?fields=id,caption,media_type,media_url,children&access_token=IGQVJYcF9aRXNPN1FXVUxnaFptSTZAZAWDdGc19XYk03ajRTOU1PbTJGMFdJb2xmdlR1aV9rVmxfU3BTaUJJd0s5MlNqYlZAxTVV5a1J6cHBXdGpraFhUdDJCR283cmdlYVlGRE55S1g3ZAGRHV3ZATWDNjbwZDZD";
		try {
			api = parsing.GetAPIInstagramFromJson(iooDownloader.getJSONbyURL(urlString));
			iooDownloader.getImageAlbumUrl(api);
			parsing.DownloadImage(api);
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
		Filter filter = new Filter(api);
		try {
			filter.PhotosWithHashtag(api);
		} catch (IOException e) {

			FilterNotFoundException a= (FilterNotFoundException) e;
			 a.getMessage();
		}}
		
		public void getSortPhotos() {
			Filter filter = new Filter(api);
			try {
				filter.sortPhotos();
			} catch (IOException e) {
				
				FilterNotFoundException a= (FilterNotFoundException) e;
				 a.getMessage();
			}
	     
	}
		public String getStatistics () {
			Statistics stats= new Statistics(api);
			return stats.toString();
			
			
		}

}
