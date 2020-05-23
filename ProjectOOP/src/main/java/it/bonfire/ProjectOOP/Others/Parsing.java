/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Others;


import java.util.HashSet;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import it.bonfire.ProjectOOP.Model.API_Instagram;
import it.bonfire.ProjectOOP.Model.Album;
import it.bonfire.ProjectOOP.Model.Fotografia;
import it.bonfire.ProjectOOP.Model.Image;

/**
 * Description of Parsing.
 * 
 * @author arian
 */
public class Parsing {

	/**
	 * Description of the method GetJSONFromUrl.
	 */
	public HashSet<API_Instagram> GetAPIInstagramFromJson(JSONObject jsonObject) 
	{
     HashSet<API_Instagram> collezione=new HashSet<>();
     HashSet<Fotografia> fotografias= new HashSet<Fotografia>();
	             JSONArray posizioni = (JSONArray) jsonObject.get("data");

					for (int i = 0; i < posizioni.size(); i++) {
						jsonObject = (JSONObject) posizioni.get(i);
						String id = (String) jsonObject.get("id");
						String caption=(String) jsonObject.get("caption");
						String media_type = (String) jsonObject.get("media_type");
						String media_url=(String) jsonObject.get("media_url");
						
						if(media_type.equals("CAROUSEL_ALBUM"))
						{    
						   JSONObject jsonprovo= (JSONObject) jsonObject.get("children");
							JSONArray album = (JSONArray) jsonprovo.get("data");
							for (int j = 0; j < album.size(); j++) {
								
								JSONObject jsonObject1 = (JSONObject)album.get(j);
								String albumid = (String) jsonObject1.get("id");
								
							  fotografias.add(new Fotografia(albumid));
								
								}
							API_Instagram ciao= (API_Instagram) new Album(id,caption,media_type,fotografias);
							collezione.add(ciao);
						}
						else { API_Instagram appoggio = (API_Instagram) new Image(id,caption,media_type,new Fotografia(id,media_url));
						collezione.add(appoggio);
					}}
					return collezione;
			}
	public String urlAlbum(JSONObject jsonObject) {
		  
		
		
	}
	}




