package it.bonfire.ProjectOOP.Others;



import java.io.*;
import java.net.URL;
import java.util.HashSet;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;


   
/**
 * Classe che mette a disposizione i metodi per recuperare le infomazioni da un CSV rintracciato parsando un JSON
 */
public class Downloader {

    /**
     * Metodo che riceve un URL di un formato JSON,e poi scaricato ed inserito all'interno di un JSON object
     * @param url Stringa che identifica il JSON
     * @return Restituisce un oggetto di tipo JSON object
     * @throws IOException Errore che viene lanciato nell'eventualità che ci siano problemi nell'Input/Output
     * @throws ParseException  Errore lanciato nel convertire una stringa in oggetto
     */ 
	public JSONObject getJSONbyURL(String url) throws IOException, ParseException {
		String totdata = "";
		String lines = "";
	

		try (InputStream imput = new URL(url).openStream()) {
			BufferedReader buffer = new BufferedReader(new InputStreamReader(imput));
			while ((lines = buffer.readLine()) != null) {
				totdata += lines;
			}

			JSONParser parser = new JSONParser();
			Object obj = parser.parse(totdata);

			JSONObject jsonObject = (JSONObject) obj;
			return jsonObject;}

		}
	public String getImageAlbumUrl (HashSet<API_Instagram> collezione) {
		while (collezione.iterator().hasNext()) {
			API_Instagram appoggio =collezione.iterator().next();
			if (appoggio.getMedia_type().equals("CAROUSEL_ALBUM")) {
				Album ricerca= (Album) appoggio;
				
			}
		}
	
	}
	}
