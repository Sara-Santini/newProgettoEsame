/*******************************************************************************
 * 2020, All rights reserved.
 *******************************************************************************/
package it.bonfire.ProjectOOP.Others;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashSet;
import java.util.Iterator;


import javax.imageio.ImageIO;

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
	public static int N = 1;

	/**
	 * Description of the method GetJSONFromUrl.
	 */
	public HashSet<API_Instagram> GetAPIInstagramFromJson(JSONObject jsonObject) {
		HashSet<API_Instagram> collezione = new HashSet<>();

		JSONArray posizioni = (JSONArray) jsonObject.get("data");

		for (int i = 0; i < posizioni.size(); i++) {
			jsonObject = (JSONObject) posizioni.get(i);
			String id = (String) jsonObject.get("id");
			String caption = (String) jsonObject.get("caption");
			String media_type = (String) jsonObject.get("media_type");
			String media_url = (String) jsonObject.get("media_url");

			if (media_type.equals("CAROUSEL_ALBUM")) {
				HashSet<Fotografia> fotografias = new HashSet<Fotografia>();
				JSONObject jsonprovo = (JSONObject) jsonObject.get("children");
				JSONArray album = (JSONArray) jsonprovo.get("data");
				for (int j = 0; j < album.size(); j++) {

					JSONObject jsonObject1 = (JSONObject) album.get(j);
					String albumid = (String) jsonObject1.get("id");

					fotografias.add(new Fotografia(albumid));

				}
				API_Instagram ciao = (API_Instagram) new Album(id, caption, media_type, fotografias);
				collezione.add(ciao);
			} else {
				API_Instagram appoggio = (API_Instagram) new Image(id, caption, media_type,
						new Fotografia(id, media_url));
				collezione.add(appoggio);
			}
		}
		return collezione;
	}

	public void DownloadImage(HashSet<API_Instagram> collezione) throws IOException {

		try {
			Iterator<API_Instagram> l = collezione.iterator();

			while (l.hasNext()) {
				API_Instagram appoggio = l.next();
				if (appoggio.getMedia_type().equals("CAROUSEL_ALBUM")) {
					Album util = (Album) appoggio;

					Iterator<Fotografia> p = util.getFotografias().iterator();
					while (p.hasNext()) {
						Fotografia a = p.next();
						URL url = new URL(a.getMedia_url());
						BufferedImage image = ImageIO.read(url);
						File file = new File(
								"C:\\Users\\arian\\Pictures\\Album" + N + "\\" + a.getId_photos() + ".jpg");
						ImageIO.write(image, "jpg", file);
					}
					N++;
				} else {
					Image util1 = (Image) appoggio;
					URL url = new URL(util1.getFotografias().getMedia_url());
					BufferedImage image = ImageIO.read(url);
					File file = new File("C:\\Users\\arian\\Pictures\\" + util1.getId() + ".jpg");
					ImageIO.write(image, "jpg", file);

				}
			}
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public String getURL(String id) {
		String url = "https://graph.instagram.com/" + id
				+ "?fields=media_url&access_token=IGQVJYcF9aRXNPN1FXVUxnaFptSTZAZAWDdGc19XYk03ajRTOU1PbTJGMFdJb2xmdlR1aV9rVmxfU3BTaUJJd0s5MlNqYlZAxTVV5a1J6cHBXdGpraFhUdDJCR283cmdlYVlGRE55S1g3ZAGRHV3ZATWDNjbwZDZD";
		return url;
	}
}
