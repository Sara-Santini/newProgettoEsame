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
			Filter ciaoFilter=new Filter();
			ciaoFilter.dowPhotosWithHashtag(ciaoFilter.photosWithHashtag(api_insta));
			HashSet<API_Instagram> aa=ciaoFilter.photosMore100Kb(api_insta,102400);
			HashSet<API_Instagram> bb= ciaoFilter.photosUnder100Kb(api_insta,102400); 
			ciaoFilter.sortPhotos(aa,bb);
			Statistics statistics=new Statistics(api_insta);
			float aaa=statistics.AverageOfPixel();
			int a=5;
		} catch (IOException | ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		

	}
}
