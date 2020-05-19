package it.bonfire.ProjectOOP;



import java.io.*;
import java.net.URL;


import org.json.simple.JSONObject;
import org.json.simple.JSONValue;
import org.json.simple.parser.ParseException;
   
/**
 * Classe che mette a disposizione i metodi per recuperare le infomazioni da un CSV rintracciato parsando un JSON
 */
public class Downloader {

    /**
     * Metodo che riceve un URL che si riferisce ad un JSON che viene scaricato ed inserito all'interno di un JSON object
     * @param url URL che identifica il JSON
     * @return Restituisce il JSON object
     * @throws IOException Errore che viene lanciato nel caso in cui ci siano problemi nell'Input/Output
     * @throws ParseException 
     */
    public static JSONObject getJSONFromURL(String url) throws IOException, ParseException {
    	String data = "";
		String line = ""; 
		
        try(InputStream is = new URL(url).openStream()) {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while ( ( line = br.readLine() ) != null ){
            	data+= line;
            }
            JSONObject obj;
			
				obj = (JSONObject) JSONValue.parseWithException(data);
	            return obj;
		
        
    }
        } }
