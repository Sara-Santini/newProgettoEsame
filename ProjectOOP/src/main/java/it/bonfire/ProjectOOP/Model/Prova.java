package it.bonfire.ProjectOOP.Model;

import java.io.IOException;
import java.util.HashSet;
import org.json.simple.JSONObject;
import org.json.simple.parser.ParseException;
import it.bonfire.ProjectOOP.Others.Downloader;
import it.bonfire.ProjectOOP.Others.Parsing;
import it.bonfire.ProjectOOP.Statistics.Statistics;
import it.bonfire.ProjectOOP.Filters.Filter;

public class Prova {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Downloader load = new Downloader();
		try {
			JSONObject obj = load.getJSONbyURL("https://graph.instagram.com/me/media?fields=id,caption,media_type,media_url,children&access_token=IGQVJYcF9aRXNPN1FXVUxnaFptSTZAZAWDdGc19XYk03ajRTOU1PbTJGMFdJb2xmdlR1aV9rVmxfU3BTaUJJd0s5MlNqYlZAxTVV5a1J6cHBXdGpraFhUdDJCR283cmdlYVlGRE55S1g3ZAGRHV3ZATWDNjbwZDZD");
			Parsing pars = new Parsing();
			HashSet<API_Instagram> api_insta = pars.GetAPIInstagramFromJson(obj);
			load.getImageAlbumUrl(api_insta);
			pars.DownloadImage(api_insta);
//			Filter filter= new Filter(api_insta);
//			filter.sortPhotos();
//			filter.PhotosWithHashtag(api_insta);
			Statistics stat=new Statistics(api_insta);
			int a=0; float u=0;
			u=stat.averageofbytes();
			u=stat.averageOfHashtag();
			u=stat.averageofpixel();
			u=stat.medianofbytes(); 
			a=stat.TotHashtag();
			

		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
