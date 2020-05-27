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
import it.bonfire.ProjectOOP.Model.Fotografia;

/**
 * Classe che mette a disposizione i metodi per recuperare le infomazioni da un
 * CSV rintracciato parsando un JSON
 */
public class Downloader {

	/**
	 * Metodo che riceve un URL di un formato JSON,e poi scaricato ed inserito
	 * all'interno di un JSON object
	 * 
	 * @param url Stringa che identifica il JSON
	 * @return Restituisce un oggetto di tipo JSON object
	 * @throws IOException    Errore che viene lanciato nell'eventualità che ci
	 *                        siano problemi nell'Input/Output
	 * @throws ParseException Errore lanciato nel convertire una stringa in oggetto
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
public void getImageAlbumUrl(HashSet<API_Instagram> collezione) {
		Iterator<API_Instagram> r = collezione.iterator();
		while (r.hasNext()) {
			API_Instagram appoggio = r.next();
			if (appoggio.getMedia_type().equals("CAROUSEL_ALBUM")) {
				Album album = (Album) appoggio;
				Iterator<Fotografia> p = album.getFotografias().iterator();
				while (p.hasNext()) {
					Fotografia a = p.next();
					String id = a.getId_photos();
					String url = getURL(id);
					a.setMedia_url(url);

				}

			}
		}

	}

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
