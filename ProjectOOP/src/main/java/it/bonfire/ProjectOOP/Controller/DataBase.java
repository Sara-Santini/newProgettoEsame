package it.bonfire.ProjectOOP.Controller;

import java.io.IOException;
import java.util.HashSet;
import java.util.Iterator;
import org.json.simple.parser.ParseException;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;
import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Image;
import it.bonfire.ProjectOOP.Others.Downloader;
import it.bonfire.ProjectOOP.Others.Parsing;

public class DataBase {
	private HashSet<API_Instagram> api=new HashSet<API_Instagram>();
	 
	public DataBase() {
		Downloader iooDownloader=new Downloader();
		Parsing parsing=new Parsing();
		String urlString= "https://graph.instagram.com/me/media?fields=id,caption,media_type,media_url,children&access_token=IGQVJYcF9aRXNPN1FXVUxnaFptSTZAZAWDdGc19XYk03ajRTOU1PbTJGMFdJb2xmdlR1aV9rVmxfU3BTaUJJd0s5MlNqYlZAxTVV5a1J6cHBXdGpraFhUdDJCR283cmdlYVlGRE55S1g3ZAGRHV3ZATWDNjbwZDZD";
		try {
			api=parsing.GetAPIInstagramFromJson(iooDownloader.getJSONbyURL(urlString));
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
		this.api= api;
		}
	
	
	
	
	
	
	
	
	public HashSet<API_Instagram> getApi() {
		return api;
	}
	public void setApi(HashSet<API_Instagram> api) {
		this.api = api;
	}
	public void addApi(Image image)
	{ if(api.contains((API_Instagram)image)) {
		throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"già esistente");
	}
		api.add((API_Instagram)image);
	}

	public void deleteAPI(String id)  {
		Iterator<API_Instagram> p = api.iterator();
		int i =0;
		while(p.hasNext()&& i==0) {
			API_Instagram ap =p.next();
			if(ap.getId().equals(id)) {
				
				api.remove(ap);	
			   i++;
			}
		}
		if(i==0) throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"non presente");
		
		
	

	}

}
