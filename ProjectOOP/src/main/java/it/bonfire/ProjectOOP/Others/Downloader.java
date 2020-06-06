package it.bonfire.ProjectOOP.Others;

import java.io.*;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import com.fasterxml.jackson.annotation.JsonIgnore;

import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Photos;

/**
 * Class which makes avaible some methods to take information by a CSV tracked by parsing a JSON.
 */
public class Downloader {

	/**
	 * Method that downloads and puts an URL, received in a JSON format, into a JSON Object.
	 * 
	 * @param url String that identify the JSONObject
	 * @return  JSONObject
	 * @throws IOException    Error that is thrown if there is any problem in the process of input/output.
	 * @throws ParseException Error that is thrown if there is any problem on the conversion of a string into an object.
		 */
	public JSONObject getJSONbyURL(String url) throws IOException, ParseException {
		String totdata = "";
		String lines ="";

		try (InputStream imput = new URL(url).openStream()) {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(imput));
			while ((lines = buffer.readLine()) != null) {
				totdata += lines;
			}

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(totdata);

			JSONObject jsonObject = (JSONObject) obj;
			return jsonObject;
		}

	}
	
@JsonIgnore
/**
 * Method that gets the URL of the images of an album from a collection and it sets the value to the parameter id of the photo.
 * @see Album
 * @see API_Instagram
 * @param collezione It is a collection of API_Instagram
 * @return HashSet<API_Instagram> 
 */
public HashSet<API_Instagram> getImageAlbumUrl(HashSet<API_Instagram> collezione) {
		Iterator<API_Instagram> r = collezione.iterator();
		while (r.hasNext()) {
			API_Instagram appoggio = r.next();
			if (appoggio.getMedia_type().equals("CAROUSEL_ALBUM")) {
				Album album = (Album) appoggio;
				Iterator<Photos> p = album.getPhotos().iterator();
				while (p.hasNext()) {
					Photos a = p.next();
					String id = a.getId_Photos();
					String url = getURL(id);
					a.setMedia_Url(url);
					

				}

			}
		}
		return collezione;

	}

/**
 * Methods that gets the URL of an image.
 * @param id Identify the photo.
 * @return URL.
 */
	public String getURL(String id) {
		String url = "https://graph.instagram.com/" + id
				+ "?fields=media_url&access_token=IGQVJYcF9aRXNPN1FXVUxnaFptSTZAZAWDdGc19XYk03ajRTOU1PbTJGMFdJb2xmdlR1aV9rVmxfU3BTaUJJd0s5MlNqYlZAxTVV5a1J6cHBXdGpraFhUdDJCR283cmdlYVlGRE55S1g3ZAGRHV3ZATWDNjbwZDZD";

		try {
			JSONObject fotoAlbum = getJSONbyURL(url);
			url = (String) fotoAlbum.get("media_url");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return url;
	}
}



